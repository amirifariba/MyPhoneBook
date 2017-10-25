package RestClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class HttpAuthenticationFeauture {
	public void authenticate() {
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("username", "password");
		final Client client = ClientBuilder.newClient();
		client.register(feature);
		// HttpAuthenticationFeature feature =
				// HttpAuthenticationFeature.basic(user.getUserName(),
				// user.getPassword());
				// clientConfig.register(feature);
				// clientConfig.register(JacksonFeature.class);
				// Client client = ClientBuilder.newClient( new ClientConfig().register(
				// LoggingFilter.class ) );
	}

}
