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

	ClientConfig clientConfig = new ClientConfig();

	public ContactEntity[] selectAll() {
		ContactEntity[] contacts = null;
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("http://localhost:8080/MyPhoneBook3/api/").path("contact");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() == 200) {
			contacts = response.readEntity(ContactEntity[].class);
		}
		return contacts;
	}

	public ContactEntity selectOne(int id) {
		String id1 = Integer.toString(id);
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("http://localhost:8080/MyPhoneBook3/api/").path("contact").path(id1);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ContactEntity contact = response.readEntity(ContactEntity.class);

		return contact;
	}

	public boolean Update(int id, Pojo contact) {
		String id1 = Integer.toString(id);
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target("http://localhost:8080/MyPhoneBook3/api/").path("contact").path(id1);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
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
		WebTarget webTarget = client.target("http://localhost:8080/MyPhoneBook3/api").path("contact");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
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
		WebTarget webTarget = client.target("http://localhost:8080/MyPhoneBook3/api").path("contact").path(id1);
		Invocation.Builder invocationBuilder = webTarget.request();
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

}
