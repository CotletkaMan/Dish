package client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import org.fusesource.restygwt.client.Defaults;
import shared.DecodeJSONAppDish;
import shared.entity.AppDish;

/**
 * Created by cotletkaman on 11.03.16.
 */
public class MainClient implements EntryPoint {
    public void onModuleLoad(){
        Defaults.setDateFormat(null);
        RootLayoutPanel.get().add(new WelcomePage());
    }
}
