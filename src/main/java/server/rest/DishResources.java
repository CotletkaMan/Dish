package server.rest;

import server.DAOoperations.AppDishCRUDImpl;
import shared.entity.AppDish;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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
    @Produces("application/json")
    public AppDish getAppDish(){
        AppDish dish = appDishCRUD.findById(Long.decode(id));
        if(dish == null)
            throw new RuntimeException("Dish with id = " + id + " not found");
        return dish;
    }

    @DELETE
    public Response deleteDish(){
        appDishCRUD.delete(Long.decode(id));
        return Response.status(200).build();
    }
}
