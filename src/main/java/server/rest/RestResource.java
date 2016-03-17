package server.rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by cotletkaman on 18.02.16.
 */
public class RestResource extends ResourceConfig {
    public RestResource(){
        register(new CDIBinder());
        register(JacksonFeature.class);
        packages(true , "server.rest");
    }
}
