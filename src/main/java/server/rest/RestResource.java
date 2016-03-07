package server.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

/**
 * Created by cotletkaman on 18.02.16.
 */
public class RestResource extends ResourceConfig {
    public RestResource(){
      //  register(new CDIbinder());
        register(JspMvcFeature.class);
        packages(true , "server.rest");
    }
}
