package client.mainContent.activites;

import client.mainContent.ClientFactory;
import client.mainContent.places.DishPlace;
import client.mainContent.presenters.DishesUnitPresenter;
import client.mainContent.views.DishesUnitView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import shared.entity.Dish;
import shared.entity.ShortDish;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class DishesUnitPresenterImpl implements DishesUnitPresenter {
    private ClientFactory clientFactory;
    private DishesUnitView dishesUnitView;
    private String id;

    public DishesUnitPresenterImpl(ShortDish dish , ClientFactory factory){
        this.clientFactory = factory;
        dishesUnitView = clientFactory.getDishesUnitView();
        dishesUnitView.setDish(dish);
        id = dish.getId().toString();
        dishesUnitView.setPresenter(this);
    }

    public void lookDish(){
       clientFactory.getPlaceController().goTo(new DishPlace(id));
    }

    public DishesUnitView getDishesUnitView(){
        return dishesUnitView;
    }
}
