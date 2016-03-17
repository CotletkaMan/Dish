package client.mainContent.views;

import client.mainContent.presenters.DishPresenter;
import com.google.gwt.user.client.ui.IsWidget;
import shared.entity.AppDish;

/**
 * Created by cotletkaman on 14.03.16.
 */
public interface DishView extends IsWidget {
    void setPresenter(DishPresenter presenter);
    void setDish(AppDish dish);
}
