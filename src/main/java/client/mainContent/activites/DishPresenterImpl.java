package client.mainContent.activites;

import client.mainContent.ClientFactory;
import client.mainContent.places.AllDishPlace;
import client.mainContent.places.DishPlace;
import client.mainContent.presenters.DishPresenter;
import client.mainContent.views.DishView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import shared.DecodeJSONAppDish;
import shared.entity.AppDish;
import shared.entity.Dish;
import shared.entity.TypeDishes;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class DishPresenterImpl extends AbstractActivity implements DishPresenter {
    private ClientFactory clientFactory;
    private DishView dishView;
    private String id;
    private DecodeJSONAppDish decodeJSONAppDish = GWT.create(DecodeJSONAppDish.class);


    public DishPresenterImpl(DishPlace place , ClientFactory factory){
        this.clientFactory = factory;
        id = place.getId();
    }

    public void start(AcceptsOneWidget panel, EventBus eventBus){
        dishView = clientFactory.getDishView();
        dishView.setPresenter(this);

        clientFactory.getRemoteAccess().getAppDish(id, new MethodCallback<AppDish>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                AppDish appDish = new AppDish();
                appDish.setDish(new Dish());
                appDish.getDish().setName("Name");
                appDish.getDish().setTypeDishes(TypeDishes.FIRST);
                appDish.setCreateDate(new Date());
                appDish.setCountView(0L);
                appDish.setCountLike(0L);
                appDish.getDish().setName(decodeJSONAppDish.encode(appDish).toString() + " :: " + method.getData().toString());
                dishView.setDish(appDish);
            }

            @Override
            public void onSuccess(Method method, AppDish dish) {
                dishView.setDish(dish);
            }
        });

        panel.setWidget(dishView.asWidget());
    }

    public void back(){
        clientFactory.getPlaceController().goTo(new AllDishPlace());
    }
}
