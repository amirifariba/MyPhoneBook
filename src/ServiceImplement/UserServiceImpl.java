package ServiceImplement;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Entities.UserEntity;
import Managers.UserManager;

@Path("/user")
public class UserServiceImpl {
	UserManager manager = new UserManager();

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserEntity loadUser(@PathParam("id") int id) {
		return manager.load(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean saveUser(UserEntity entity) {
		return manager.save(entity);
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserEntity validateUser(UserEntity entity) {
		return manager.validateUser(entity);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserEntity> selectallUser() {
		return manager.findAll();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateUser(@PathParam("id") int id, UserEntity user) {
		System.out.println("username is " + user.getUserName());
		return manager.Update(id, user);
	}

	@DELETE
	@Path("/{id}")
	public boolean deleteById(@PathParam("id") int id) {
		return manager.Delete(id);
	}

	public UserServiceImpl() {
	}

}
