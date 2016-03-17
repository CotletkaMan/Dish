package client.header.buttons.all;

import client.header.ButtonPresenter;
import client.header.ButtonView;
import client.mainContent.places.AllDishPlace;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.Panel;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class AllButtonPresenterImpl implements ButtonPresenter {
    private ButtonView buttonView;
    private PlaceController controller;

    public AllButtonPresenterImpl(Panel panel , PlaceController controller){
        this.controller = controller;
        buttonView = new AllButtonViewImpl();
        buttonView.setPresenter(this);
        panel.add(buttonView);
    }

    public void buttonAction(){
        controller.goTo(new AllDishPlace());
    }
}
