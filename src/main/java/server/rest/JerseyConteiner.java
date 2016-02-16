package server.rest;


import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cotletkaman on 06.02.16.
 */
public class JerseyConteiner extends Application {
    public Set<Class<?>> getClasses(){
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(DishesResource.class);
        set.add(DishResource.class);
        return set;
    }
}
