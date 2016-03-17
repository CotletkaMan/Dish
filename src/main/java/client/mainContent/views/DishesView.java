package client.mainContent.views;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created by cotletkaman on 14.03.16.
 */
public interface DishesView extends IsWidget {
    void addDish(DishesUnitView view);
    void setTitle(String text);
}
