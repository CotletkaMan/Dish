package server.rest;

import server.DAOoperations.AppDishOperaion.AppDishCollectionImpl;
import server.DAOoperations.AppDishOperaion.ExtendAppDishOperation;
import server.DAOoperations.BasicCollectionOperations;
import shared.entity.ShortDish;
import shared.entity.TypeDishes;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cotletkaman on 05.02.16.
 */
@Path("/dishes")
@Produces("application/json")
public class DishesResource {
    @Context
    private UriInfo uriInfo;

    @EJB
    private AppDishCollectionImpl appDishOperations;

    @GET
    public List<ShortDish> getAllDishes(){
        BasicCollectionOperations<ShortDish> basicAppDish = appDishOperations;
        return basicAppDish.findAll();
    }

    @GET
    @Consumes("text/plain")
    public List<ShortDish> getTypeDishes(String type){
        TypeDishes dishes = TypeDishes.valueOf(type);
        ExtendAppDishOperation extendAppDishOperation = appDishOperations;
        return extendAppDishOperation.getType(dishes);
    }

    @POST
    @Consumes("application/json")
    public List<ShortDish> getFilterDishes(HashMap<String , Object> map){
        return appDishOperations.filter(map);
    }

    @Path("{dishID}")
    public DishResource getDishResource(@PathParam("dishID") String id){
        return new DishResource(id , uriInfo);
    }
}
