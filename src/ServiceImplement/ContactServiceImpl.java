package ServiceImplement;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


import Entities.ContactEntity;
import Managers.ContactManager;

@Path("/contact")
public class ContactServiceImpl {
	ContactManager manager = new ContactManager();

	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ContactEntity load(@PathParam("id") int id,@Context ContainerRequestContext requestContext) {
		return manager.load(id);
	}
	
	
	@RolesAllowed({ "firstAdmin", "secondAdmin","user"})
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean save(ContactEntity entity,@Context ContainerRequestContext requestContext) {
		return manager.save(entity);
		// ActionResult<Long>(true, "New contact saved successfully.",
		// entity.getContactId());

	}
	
	
	@RolesAllowed({ "firstAdmin", "secondAdmin","user","guest"})
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContactEntity> selectallContact(@Context ContainerRequestContext requestContext) {
		return manager.findAll();
	}

	@RolesAllowed({ "firstAdmin", "secondAdmin" })
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateContact(@PathParam("id") int id, @Context ContainerRequestContext requestContext,ContactEntity contact) {
		return manager.Update(id, contact);
	}

	
	@RolesAllowed({ "firstAdmin", "secondAdmin" })
	@DELETE
	@Path("/{id}")
	public boolean deleteById(@PathParam("id") int id,@Context ContainerRequestContext requestContext) {
		return manager.Delete(id);
	}

	public ContactServiceImpl() {
	}

}
