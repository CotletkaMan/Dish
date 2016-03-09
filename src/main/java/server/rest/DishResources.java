package server.rest;

import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.mvc.Template;
import org.glassfish.jersey.server.mvc.Viewable;
import server.DAOoperations.AppDishCRUDImpl;
import shared.entity.AppDish;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.HashMap;

/**
 * Created by cotletkaman on 06.02.16.
 */
@ManagedBean
public class DishResources {
    private String id;

    @Context
    private UriInfo uriInfo;

    @Inject
    private AppDishCRUDImpl appDishCRUD;

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    @GET
    //@Produces("application/json")
    public Viewable getAppDish(){
        AppDish dish = appDishCRUD.findById(Long.decode(id));
        if(dish == null)
            throw new RuntimeException("Dish with id = " + id + " not found");
        return new Viewable("/viewDish.jsp" , dish.getDish());
    }

    @DELETE
    public Response deleteDish(){
        appDishCRUD.delete(Long.decode(id));
        return Response.status(200).build();
    }
}
