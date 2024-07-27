package restetudiant.application;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import com.liferay.portal.kernel.exception.PortalException;
import dto.EtudiantDto;
import impl.EtudiantServiceImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author lenovo
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/greetings",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest"
	},
	service = Application.class
)
public class RestEtudiantApplication extends Application {

	@Reference
	EtudiantServiceImpl etudiantService;
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(
		@PathParam("name") String name,
		@QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}
		return greeting;
	}

	@GET
	@Path("/etudiants/{start}/{end}")
	@Produces("text/json")
	public List<EtudiantDto> getAllEtudiants(@PathParam("start") int start, @PathParam("end") int end) {
		return etudiantService.getAllEtudiantDto(start,end);
	}

	@GET
	@Path("/etudiant/{id}")
	@Produces("text/json")
	public Response getEtudiantById(@PathParam("id") long id) throws PortalException {
		Optional<EtudiantDto> etudiant = etudiantService.getEtudiantDtoById(id);
		if (etudiant.isPresent()) {
			return Response.ok(etudiant.get()).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@DELETE
	@Path("/etudiant/{id}")
	@Produces("text/plain")
	public Response deleteEtudiantById(@PathParam("id") long id) {
		try {
			etudiantService.deleteEtudiantById(id);
			return Response.ok("Etudiant supprimé avec succès.").build();
		} catch (PortalException e) {
			return Response.status(Response.Status.NOT_FOUND).entity("Etudiant non trouvé.").build();
		}
	}



}