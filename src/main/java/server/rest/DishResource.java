package server.rest;

import server.DAOoperations.AppDishOperaion.AppDishCRUDImpl;
import shared.entity.AppDish;
import shared.entity.Dish;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import java.util.Date;

/**
 * Created by cotletkaman on 06.02.16.
 */
public class DishResource {
    private String id;
    private UriInfo uriInfo;

    @EJB
    private AppDishCRUDImpl appDishCRUD;

    public DishResource(String id , UriInfo uriInfo){
        this.uriInfo = uriInfo;
        this.id = id;
    }

    @GET
    @Produces("application/json")
    public AppDish getAppDish(){
        AppDish dish = appDishCRUD.findById(Long.decode(id));
        if(dish == null)
            throw new RuntimeException("Dish with id = " + id + " not found");
        return dish;
    }

    @PUT
    @Consumes("application/json")
    public Response putAppDish(JAXBElement<Dish> dishJAXBElement){
        Dish dish = dishJAXBElement.getValue();
        AppDish appDish = new AppDish();
        appDish.setDish(dish);
        appDish.setCreateDate(new Date());
        appDish.setCountView(0L);
        appDish.setCountLike(0L);

        appDishCRUD.create(appDish);
        return Response.created(uriInfo.getAbsolutePath()).build();
    }
}
