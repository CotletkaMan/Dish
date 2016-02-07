package server.rest;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by cotletkaman on 06.02.16.
 */
@ApplicationPath("Main")
public class JerseyConteiner extends ResourceConfig {
    public JerseyConteiner(){
        packages("server.rest.DishesResources;server.rest.DishResource");
    }
}
