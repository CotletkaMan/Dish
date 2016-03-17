package client.mainContent.activites;

import client.mainContent.ClientFactory;
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
public class FirstDishesPresenterImpl extends DishesPresenterImpl {
    private RemoteAccess remoteAccess;

    public FirstDishesPresenterImpl(Place place , ClientFactory factory){
        super(place , factory , "First");
        remoteAccess = factory.getRemoteAccess();
    }

    protected void getDishes(){
        remoteAccess.getType("FIRST", new MethodCallback<List<ShortDish>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                debug(throwable.getMessage());

            }

            @Override
            public void onSuccess(Method method, List<ShortDish> shortDishs) {
                setDishes(shortDishs);
            }
        });
    }
}
