package client.header.buttons.first;

import client.header.ButtonPresenter;
import client.header.ButtonView;
import client.mainContent.places.FirstDishPlace;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.Panel;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class FirstButtonPresenterImpl implements ButtonPresenter {
    private ButtonView buttonView;
    private PlaceController controller;

    public FirstButtonPresenterImpl(Panel panel , PlaceController controller){
        this.controller = controller;
        buttonView = new FirstButtonViewImpl();
        buttonView.setPresenter(this);
        panel.add(buttonView);
    }

    public void buttonAction(){
        controller.goTo(new FirstDishPlace());
    }
}
