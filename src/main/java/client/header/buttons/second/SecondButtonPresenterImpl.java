package client.header.buttons.second;

import client.header.ButtonPresenter;
import client.header.ButtonView;
import client.mainContent.places.SecondDishPlace;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.Panel;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class SecondButtonPresenterImpl implements ButtonPresenter {
    private ButtonView buttonView;
    private PlaceController controller;

    public SecondButtonPresenterImpl(Panel panel , PlaceController controller){
        this.controller = controller;
        buttonView = new SecondButtonViewImpl();
        buttonView.setPresenter(this);
        panel.add(buttonView);
    }

    public void buttonAction(){
        controller.goTo(new SecondDishPlace());
    }
}
