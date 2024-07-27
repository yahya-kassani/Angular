package service;

import com.liferay.portal.kernel.exception.PortalException;
import dto.EtudiantDto;

import java.util.List;
import java.util.Optional;

public interface EtudiantService {
    Optional<EtudiantDto> getEtudiantDtoById(long etudiantId) throws PortalException;
    List<EtudiantDto> getAllEtudiantDto(int start,int end);
    void deleteEtudiantById(long etudiantId) throws PortalException;

    //EtudiantDto updateEtudiant(EtudiantDto etudiantDto) throws PortalException;
}