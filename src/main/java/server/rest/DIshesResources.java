package server.rest;

import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.mvc.Template;
import org.glassfish.jersey.server.mvc.Viewable;
import server.DAOoperations.AppDishCRUDImpl;
import server.DAOoperations.CRUDinterface;
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
import javax.xml.bind.JAXBElement;
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

    @GET
    public Viewable getType(@QueryParam("type") String type) {
        ExtendAppDishOperation extendAppDishOperation = appDishOperations;
        return new Viewable("/findAll.jsp" , extendAppDishOperation.getType(TypeDishes.valueOf(type)));
    }

    @POST
    @Consumes("application/json")
    public List<ShortDish> getFiltered(HashMap<String , Object> map){
        return appDishOperations.filter(map);
    }


    @GET
    @Path("/AddNew")
    public Viewable getForm(){
        return new Viewable("/index.jsp" , this);
    }

    @PUT
    @Path("/AddNew")
    @Consumes("text/plain")
   // public Response putAppDish(JAXBElement<Dish> dishJAXBElement){
    public String putAppDish(String text){

        System.out.println(text);
    /*    Dish dish = dishJAXBElement.getValue();
        AppDish appDish = new AppDish();
        appDish.setDish(dish);
        appDish.setCreateDate(new Date());
        appDish.setCountView(0L);
        appDish.setCountLike(0L);

        appDishCRUD.create(appDish);*/
        return "DONE!";
    }

    @Path("{dishID}")
    public DishResources getDish(@PathParam("dishID") String id){
        return new DishResources(id);
    }
}
