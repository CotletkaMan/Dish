package client.header.buttons.addNew;

import client.header.ButtonPresenter;
import client.header.ButtonView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class AddNewButtonViewImpl extends Composite implements ButtonView {
    interface ExamplePanelUiBinder extends UiBinder<Widget, AddNewButtonViewImpl> {}
    private static ExamplePanelUiBinder uiBinder = GWT.create(ExamplePanelUiBinder.class);
    private ButtonPresenter presenter;

    @UiField
    Button button;

    AddNewButtonViewImpl(){
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("button")
    public void setButtonAction(ClickEvent event){
        presenter.buttonAction();
    }

    public void setPresenter(ButtonPresenter presenter){
        this.presenter = presenter;
    }
}
