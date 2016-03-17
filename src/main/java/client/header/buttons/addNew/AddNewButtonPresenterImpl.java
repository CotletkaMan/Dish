package client.header.buttons.addNew;

import client.header.ButtonPresenter;
import client.header.ButtonView;
import client.mainContent.places.AddNewPlace;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.Panel;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class AddNewButtonPresenterImpl implements ButtonPresenter {
    private ButtonView buttonView;
    private PlaceController controller;

    public AddNewButtonPresenterImpl(Panel panel , PlaceController controller){
        this.controller = controller;
        buttonView = new AddNewButtonViewImpl();
        buttonView.setPresenter(this);
        panel.add(buttonView);
    }

    public void buttonAction(){
        controller.goTo(new AddNewPlace());
    }
}
