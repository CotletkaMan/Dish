package client.mainContent.activites;

import client.mainContent.ClientFactory;
import client.mainContent.places.AllDishPlace;
import client.mainContent.places.BasicPlace;
import client.mainContent.presenters.AddNewPresenter;
import client.mainContent.views.AddNewView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import shared.entity.Dish;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class AddNewPresenterImpl extends AbstractActivity implements  AddNewPresenter {
    private ClientFactory clientFactory;
    private AddNewView addNewView;

    public AddNewPresenterImpl(Place place , ClientFactory factory){
        this.clientFactory = factory;
    }

    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        addNewView = clientFactory.getAddNewView();
        addNewView.setPresenter(this);
        panel.setWidget(addNewView.asWidget());
    }

    public void addNewDish(Dish dish){
        clientFactory.getRemoteAccess().putAppDish(dish , new MethodCallback() {
            public void onSuccess(Method method, Object response) {
                clientFactory.getPlaceController().goTo(new AllDishPlace());
            }

            public void onFailure(Method method, Throwable exception) {
                clientFactory.getPlaceController().goTo(new BasicPlace());
            }
        });
    }
}
