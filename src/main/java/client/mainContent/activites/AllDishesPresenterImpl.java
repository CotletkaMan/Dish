package client.mainContent.activites;

import client.mainContent.ClientFactory;
import client.mainContent.places.AllDishPlace;
import client.mainContent.places.BasicPlace;
import com.google.gwt.place.shared.Place;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import shared.RemoteAccess;
import shared.entity.ShortDish;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class AllDishesPresenterImpl extends DishesPresenterImpl {
    private RemoteAccess remoteAccess;

    public AllDishesPresenterImpl(Place place , ClientFactory factory){
        super(place , factory , "All");
        remoteAccess = factory.getRemoteAccess();
    }

    protected void getDishes(){
        remoteAccess.getType("ALL" , new MethodCallback<List<ShortDish>>(){
            public void onSuccess(Method method, List<ShortDish> response) {
                setDishes(response);
            }

            public void onFailure(Method method, Throwable exception) {
                debug(exception.getMessage());
            }
        });
    }
}
