package ServiceImplement;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ServerResponse;

import Entities.UserEntity;
import Managers.UserManager;


/**
 * This filter verify the access permissions for a user based on username and
 * passowrd provided in request
 */
@Provider
public class AuthenticationFilter implements javax.ws.rs.container.ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED)
			.entity("You cannot access this resource").build();
	private static final Response ACCESS_FORBIDDEN = Response.status(Response.Status.FORBIDDEN)
			.entity("Access blocked for all users !!").build();
	
	

	@Override
	public void filter(ContainerRequestContext requestContext) {
		String roleName;
		Method method = resourceInfo.getResourceMethod();
		/*// Access allowed for all
		if (!method.isAnnotationPresent(PermitAll.class)) {
			// Access denied for all
			if (method.isAnnotationPresent(DenyAll.class)) {
				requestContext.abortWith(ACCESS_FORBIDDEN);
				return;
			}
*/
			// Get request headers
			final MultivaluedMap<String, String> headers = requestContext.getHeaders();

			// Fetch authorization header
			final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

			// If no authorization information present; block access
			if (authorization == null || authorization.isEmpty()) {
				roleName="guest";

			}
			else
			{
				String authToken = authorization.get(0);
				authToken = authToken.replaceFirst(AUTHENTICATION_SCHEME, "");
				String decodedString = Base64.decodeAsString(authToken);
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				UserManager user = new UserManager();
				roleName = user.validateUser(new UserEntity(tokenizer.nextToken(),tokenizer.nextToken())).getRole().getRoleName();
				

			}
			
			

			// Verify user access
			if (method.isAnnotationPresent(RolesAllowed.class)) {
				RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
				Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

				// Is user valid?
				if (!isUserAllowed(roleName, rolesSet)) {
					requestContext.abortWith(ACCESS_DENIED);
                    return;

				}
			}
		}
	//}


	private boolean isUserAllowed(final String roleName, final Set<String> rolesSet) {
		boolean isAllowed = false;

		if (roleName.equals("firstAdmin")) {

			// Step 2. Verify user role
			if (rolesSet.contains(roleName)) {
				isAllowed = true;
			}
		}
		if (roleName.equals("secondAdmin")) {

			// Step 2. Verify user role
			if (rolesSet.contains(roleName)) {
				isAllowed = true;
			}
		}
		if (roleName.equals("user")) {

			// Step 2. Verify user role
			if (rolesSet.contains(roleName)) {
				isAllowed = true;
			}
		}
		if (roleName.equals("guest")) {

			// Step 2. Verify user role
			if (rolesSet.contains(roleName)) {
				isAllowed = true;
			}
		}
		
		return isAllowed;
	}

	// Step 1. Fetch password from database and match with password in
	// argument
	// If both match then get the defined role for user from database and
	// continue; else return isAllowed [false]
	// Access the database and do this part yourself
	// String userRole = userMgr.getUserRole(username);

}
