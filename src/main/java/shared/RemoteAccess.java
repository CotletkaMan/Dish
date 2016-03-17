package shared;

import org.fusesource.restygwt.client.Attribute;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;
import shared.entity.AppDish;
import shared.entity.Dish;
import shared.entity.ShortDish;

import javax.ws.rs.*;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cotletkaman on 17.03.16.
 */
@Path("/rs/dishes")
public interface RemoteAccess extends RestService {
    @GET
    void getType(@QueryParam("type") @Attribute("type") String type, MethodCallback<List<ShortDish>> methodCallback);

    @POST
    void getFiltered(HashMap<String, Object> map, MethodCallback<List<ShortDish>> methodCallback);

    @POST
    @Path("/AddNew")
    void putAppDish(Dish dish, MethodCallback methodCallback);

    @GET
    @Path("/{id}")
    void getAppDish(@PathParam("id") String id, MethodCallback<AppDish> callback);

}
