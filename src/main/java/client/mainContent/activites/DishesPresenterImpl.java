package client.mainContent.activites;

import client.mainContent.ClientFactory;
import client.mainContent.presenters.BasicPresenter;
import client.mainContent.presenters.DishesUnitPresenter;
import client.mainContent.views.DishesUnitView;
import client.mainContent.views.DishesView;
import client.mainContent.views.uiBinder.DishesUnitViewImpl;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import shared.entity.ShortDish;

import java.util.Collections;
import java.util.List;

/**
 * Created by cotletkaman on 14.03.16.
 */
public abstract class DishesPresenterImpl extends AbstractActivity implements  BasicPresenter{
    private ClientFactory clientFactory;
    private DishesView dishesView;
    private String title;

    public DishesPresenterImpl(Place place , ClientFactory factory , String text){
        this.clientFactory = factory;
        title = text;
    }

    public void start(AcceptsOneWidget panel, EventBus eventBus){
        dishesView = clientFactory.getDishesView();
        dishesView.setTitle(title);
        getDishes();
        panel.setWidget(dishesView.asWidget());
    }

    protected abstract void getDishes();

    public void setDishes(List<ShortDish> dishList){
        for(ShortDish dish : dishList){
            DishesUnitPresenter dishesUnitPresenter = new DishesUnitPresenterImpl(dish , clientFactory);
            dishesView.addDish(dishesUnitPresenter.getDishesUnitView());
        }
    }

    public void debug(String text){
        dishesView.setTitle(text);
    }



}
