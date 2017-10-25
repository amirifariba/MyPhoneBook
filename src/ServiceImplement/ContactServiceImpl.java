package ServiceImplement;

import java.util.List;

import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DataManagement.ActionResult;
import Entities.ContactEntity;
import Managers.ContactManager;

@Path("/contact")
public class ContactServiceImpl {
	ContactManager manager = new ContactManager();

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ContactEntity load(@PathParam("id") int id) {
		return manager.load(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean save(ContactEntity entity) {
		return manager.save(entity);
		// ActionResult<Long>(true, "New contact saved successfully.",
		// entity.getContactId());

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContactEntity> selectallContact() {
		return manager.findAll();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateContact(@PathParam("id") int id, ContactEntity contact) {
		return manager.Update(id, contact);
	}

	@DELETE
	@Path("/{id}")
	public boolean deleteById(@PathParam("id") int id) {
		return manager.Delete(id);
	}

	public ContactServiceImpl() {
	}

}
