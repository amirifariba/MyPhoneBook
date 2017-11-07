package RestClient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.internal.util.Base64;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Entities.Pojo;
import Entities.UserEntity;

public class UserClient implements RestClient {
	String ip="localhost";
	String user;
	String pass;
	
	public UserClient(String ip, String user, String pass) {
		this.ip = ip;
		this.user = user;
		this.pass = pass;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	ClientConfig clientConfig = new ClientConfig();

	public UserClient() {
	}

	@Override
	public UserEntity[] selectAll() {
		UserEntity[] users = null;
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("http://" + this.ip + ":8080/MyPhoneBook3/api").path("user");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() == 200) {
			users = response.readEntity(UserEntity[].class);
		}
		return users;
	}

	@Override
	public UserEntity selectOne(int id) {
		String id1 = Integer.toString(id);
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("http://" + this.ip + ":8080/MyPhoneBook3/api").path("user").path(id1);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		UserEntity user = response.readEntity(UserEntity.class);

		return user;
	}

	@Override
	public boolean Update(int id, Pojo user) {
		String id1 = Integer.toString(id);
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("http://" + this.ip + ":8080/MyPhoneBook3/api").path("user").path(id1);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(user, MediaType.APPLICATION_JSON));
		// UserEntity user1= response.readEntity(UserEntity.class);
		int status = response.getStatus();
		System.out.println(status);
		if (status == 200) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean Save(Pojo user) {
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("http://" + this.ip + ":8080/MyPhoneBook3/api").path("user");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		int status = response.getStatus();
		System.out.println(status);
		if (status == 200) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean Delete(int id) {
		String id1 = Integer.toString(id);
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("http://" + this.ip + ":8080/MyPhoneBook3/api").path("user").path(id1);
		Invocation.Builder invocationBuilder = webTarget.request();
		Response response = invocationBuilder.delete();
		int status = response.getStatus();
		System.out.println(status);
		if (status == 200) {
			return true;
		} else
			return false;
	}

	public String validateUser() {
		UserEntity user = new UserEntity(this.user, this.pass);
		String roleName;
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("http://" + this.ip + ":8080/MyPhoneBook3/api").path("user").path("login");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		UserEntity user1 = response.readEntity(UserEntity.class);
		roleName = user1.getRole().getRoleName();
		
		System.out.println(roleName);
		return roleName;

	}
	
}
