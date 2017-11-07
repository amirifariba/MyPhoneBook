package ServiceImplement;


import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
 
@ApplicationPath("/api")
public class CustomApplication extends ResourceConfig
{
    public CustomApplication()
    {
        packages("ServiceImplement");
       register(AuthenticationFilter.class);
        //register(new AuthenticationFilter());
        //register(AuthenticationFilter.class);
    }
}
