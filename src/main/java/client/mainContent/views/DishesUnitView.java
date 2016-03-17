package client.mainContent.views;

import client.mainContent.presenters.DishesUnitPresenter;
import com.google.gwt.user.client.ui.IsWidget;
import shared.entity.ShortDish;

/**
 * Created by cotletkaman on 14.03.16.
 */
public interface DishesUnitView extends IsWidget{
    void setPresenter(DishesUnitPresenter presenter);
    void setDish(ShortDish dish);
}
