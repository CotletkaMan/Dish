package client.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
public class LoginDialogBox extends PopupPanel {
    interface MyBinder extends UiBinder<Widget, LoginDialogBox>{}
    private static MyBinder uiBinder = GWT.create(MyBinder.class);

    @UiField Button btnLogin;
    @UiField TextBox txtEmail;
    @UiField SpanElement eEmailErrorText;
    @UiField SpanElement ePassErrorText;
    @UiField Element eEmailError;
    @UiField Element ePassError;
    @UiField(provided = true) TextBox txtPassword;

    public LoginDialogBox() {
        setStyleName("");
        txtPassword = new PasswordTextBox();
        add(uiBinder.createAndBindUi(this));
    }
}