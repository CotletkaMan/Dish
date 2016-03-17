package client.header;

import client.header.buttons.addNew.AddNewButtonPresenterImpl;
import client.header.buttons.all.AllButtonPresenterImpl;
import client.header.buttons.desert.DesertButtonPresenterImpl;
import client.header.buttons.first.FirstButtonPresenterImpl;
import client.header.buttons.second.SecondButtonPresenterImpl;
import client.mainContent.ClientFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class Header extends Composite {
    interface HeaderUiBinder extends UiBinder<Widget, Header> {}
    private static HeaderUiBinder uiBinder = GWT.create(HeaderUiBinder.class);

    private ClientFactory clientFactory = GWT.create(ClientFactory.class);

    @UiField
    FlowPanel panel;

    public Header(){
        initWidget(uiBinder.createAndBindUi(this));
        new AllButtonPresenterImpl(panel , clientFactory.getPlaceController());
        new FirstButtonPresenterImpl(panel , clientFactory.getPlaceController());
        new SecondButtonPresenterImpl(panel , clientFactory.getPlaceController());
        new DesertButtonPresenterImpl(panel , clientFactory.getPlaceController());
        new AddNewButtonPresenterImpl(panel , clientFactory.getPlaceController());
    }
}
