package client;

import client.header.Header;
import client.mainContent.MainPanel;
import client.resources.MyCssResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

/**
 * Created by cotletkaman on 11.03.16.
 */
public class WelcomePage extends Composite {
    private static WelcomePageUiBinder uiBinder = GWT.create(WelcomePageUiBinder.class);
    interface WelcomePageUiBinder extends UiBinder<Widget, WelcomePage> {}

    @UiField
    Header header;

    @UiField
    MainPanel content;

    interface Resources extends ClientBundle {
        @Source("resources/main.css")
        MyCssResource getCss();
    }

    public WelcomePage(){
        initWidget(uiBinder.createAndBindUi(this));
    }
}
