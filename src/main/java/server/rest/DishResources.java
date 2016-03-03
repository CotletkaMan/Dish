package server.rest;

import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.mvc.Template;
import server.DAOoperations.AppDishCRUDImpl;
import shared.entity.AppDish;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * Created by cotletkaman on 06.02.16.
 */
@ManagedBean
public class DishResources {
    private String id;

    @Context
    private UriInfo uriInfo;

    @EJB
    private AppDishCRUDImpl appDishCRUD;

    public DishResources(String id){
        this.id = id;
    }

    @GET
    @Produces("application/json")
    @Template
    public AppDish getAppDish(){
        AppDish dish = appDishCRUD.findById(Long.decode(id));
        if(dish == null)
            throw new RuntimeException("Dish with id = " + id + " not found");
        return dish;
    }

    public DishResources(){}
}
