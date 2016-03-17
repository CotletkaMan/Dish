package client.header.buttons.desert;

import client.header.ButtonPresenter;
import client.header.ButtonView;
import client.mainContent.places.DesertDishPlace;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.Panel;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class DesertButtonPresenterImpl implements ButtonPresenter {
    private ButtonView buttonView;
    private PlaceController controller;

    public DesertButtonPresenterImpl(Panel panel , PlaceController controller){
        this.controller = controller;
        buttonView = new DesertButtonViewImpl();
        buttonView.setPresenter(this);
        panel.add(buttonView);
    }

    public void buttonAction(){
        controller.goTo(new DesertDishPlace());
    }
}
