package server.rest;

import server.DAOoperations.AppDishCRUDImpl;
import server.DAOoperations.ExtendAppDishOperation;
import shared.entity.AppDish;
import shared.entity.Dish;
import shared.entity.ShortDish;
import shared.entity.TypeDishes;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cotletkaman on 05.02.16.
 */
@Path("/dishes")
@ManagedBean
public class DishesResources {
    @Context
    private UriInfo uriInfo;

    @Inject
    private AppDishCRUDImpl appDishCRUD;

    @Inject
    private ExtendAppDishOperation appDishOperations;

    @Inject
    private DishResources dishResources;

    @GET
    @Produces("application/json")
    public List<ShortDish> getType(@QueryParam("type") String type) {
        ExtendAppDishOperation extendAppDishOperation = appDishOperations;
        return extendAppDishOperation.getType(TypeDishes.valueOf(type));
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public List<ShortDish> getFiltered(HashMap<String , Object> map){
        return appDishOperations.filter(map);
    }

    @POST
    @Path("/AddNew")
    @Consumes("application/json")
    public Response putAppDish(Dish dish){
        System.err.println(dish.getName());
        AppDish appDish = new AppDish();
        appDish.setDish(dish);
        appDish.setCreateDate(new Date());
        appDish.setCountView(0L);
        appDish.setCountLike(0L);
        System.err.println(dish.getIngredients().keySet().toString());
        appDishCRUD.create(appDish);
        return Response.status(200).build();
    }

    @Path("{dishID}")
    public DishResources getDish(@PathParam("dishID") String id){
        dishResources.setId(id);
        return dishResources;
    }
}
