package impl;

import classe.service.ClasseLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import dto.EtudiantDto;
import etudiant.model.Etudiant;
import etudiant.service.EtudiantLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import service.EtudiantService;

import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component(
        immediate = true,
        service = EtudiantServiceImpl.class
)
public class EtudiantServiceImpl implements EtudiantService {

    @Reference
    EtudiantLocalService etudiantLocalService;

    @Reference
    ClasseLocalService classeLocalService;
    @Override
    public Optional<EtudiantDto> getEtudiantDtoById(long etudiantId) throws PortalException {
        Etudiant etudiant = etudiantLocalService.getEtudiant(etudiantId);
        if (etudiant != null) {
            EtudiantDto etudiantDto = new EtudiantDto(
                    etudiant.getEtudiantId(),
                    etudiant.getClasseId(),
                    etudiant.getImageId(),
                    etudiant.getPrenom(),
                    etudiant.getNom(),
                    classeLocalService.getClasse(etudiant.getClasseId()).getIntitule()
            );
            return Optional.of(etudiantDto);
        } else {
            return Optional.empty();
        }    }

    @Override
    public List<EtudiantDto> getAllEtudiantDto(int start, int end) {
        return etudiantLocalService.getEtudiants(start,end)
                .stream()
                .map(e -> {
                    try {
                        return new EtudiantDto(e.getEtudiantId(),e.getClasseId(),e.getImageId(),e.getPrenom(),e.getNom(),classeLocalService.getClasse(e.getClasseId()).getIntitule());
                    } catch (PortalException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEtudiantById(long etudiantId) throws PortalException {
        etudiantLocalService.deleteEtudiant(etudiantId);
    }

    


}