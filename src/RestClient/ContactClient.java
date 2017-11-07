package RestClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import Entities.ContactEntity;
import Entities.Pojo;

public class ContactClient implements RestClient {

	public String ip = "localhost";
	public String user;
	public String password;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public ClientConfig getClientConfig() {
		return clientConfig;
	}

	public void setClientConfig(ClientConfig clientConfig) {
		this.clientConfig = clientConfig;
	}

	ClientConfig clientConfig = new ClientConfig();

	public ContactEntity[] selectAll() {
		ContactEntity[] contacts = null;
		Client client = ClientBuilder.newClient(clientConfig);
<<<<<<< HEAD
		// "http://localhost:8080/MyPhoneBook3/api/"
		WebTarget webTarget = client.target("http://" + this.ip + ":8080/MyPhoneBook3/api/").path("contact");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("Authorization",
				"Basic" + authoEncode());
		Response response = invocationBuilder.get();
		if (response.getStatus() == 200) {
			contacts = response.readEntity(ContactEntity[].class);
		} else if (response.getStatus() == 401)
			System.out.println("you can not access this resource");
		
		System.err.println(response);
		
//		if (contacts == null){
//		 ContactEntity[] contactEntities = new ContactEntity[0];
//			return contactEntities; 
//		}
=======
		WebTarget webTarget = client.target("http://localhost:8080/MyPhoneBook3/api/").path("contact");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() == 200) {
			contacts = response.readEntity(ContactEntity[].class);
		}
>>>>>>> parent of 2864ceb... faze 2: swing is not completed
		return contacts;
	}

	public ContactEntity selectOne(int id) {
		String id1 = Integer.toString(id);
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("http://" + this.ip + ":8080/MyPhoneBook3/api/").path("contact").path(id1);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("Authorization",
				"Basic" + authoEncode());
		Response response = invocationBuilder.get();
		ContactEntity contact = response.readEntity(ContactEntity.class);

		return contact;
	}

	public boolean Update(int id, Pojo contact) {
		String id1 = Integer.toString(id);
<<<<<<< HEAD
		// Client client = ClientBuilder.newClient(clientConfig);
		Client client = ClientBuilder.newClient(new ClientConfig().register(new LoggingFilter()));
		WebTarget webTarget = client.target("http://" + this.ip + ":8080/MyPhoneBook3/api/").path("contact").path(id1);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("Authorization",
				"Basic" + authoEncode());
=======
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("http://localhost:8080/MyPhoneBook3/api/").path("contact").path(id1);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
>>>>>>> parent of 2864ceb... faze 2: swing is not completed
		Response response = invocationBuilder.put(Entity.entity(contact, MediaType.APPLICATION_JSON));
		// ContactEntity contact1= response.readEntity(ContactEntity.class);

		int status = response.getStatus();
		System.out.println(status);

		if (status == 200) {
			return true;
		} else
			return false;
	}

	public boolean Save(Pojo contact) {
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("http://" + this.ip + ":8080/MyPhoneBook3/api").path("contact");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON).header("Authorization",
				"Basic" + authoEncode());
		Response response = invocationBuilder.post(Entity.entity(contact, MediaType.APPLICATION_JSON));
		int status = response.getStatus();
		System.out.println(status);
		if (status == 200) {
			return true;
		} else
			return false;
	}

	public boolean Delete(int id) {
		String id1 = Integer.toString(id);
		Client client = ClientBuilder.newClient(clientConfig);
		// "http://localhost:8080/MyPhoneBook3/api"
		WebTarget webTarget = client.target("http://" + this.ip + ":8080/MyPhoneBook3/api").path("contact").path(id1);
		Invocation.Builder invocationBuilder = webTarget.request().header("Authorization",
				"Basic" + authoEncode());
		Response response = invocationBuilder.delete();
		int status = response.getStatus();
		System.out.println(status);
		if (status == 200) {
			return true;
		} else
			return false;
	}

	ContactClient() {
	}

<<<<<<< HEAD
	public ContactClient(String ip, String user, String pass) {
		this.ip = ip;
		this.user = user;
		this.password = pass;
	}

	public String authoEncode() {
		String authString = this.user + ":" + this.password;
		String authStringEnc = Base64.encodeAsString(authString);
		return authStringEnc;
	}
=======
>>>>>>> parent of 2864ceb... faze 2: swing is not completed
}
