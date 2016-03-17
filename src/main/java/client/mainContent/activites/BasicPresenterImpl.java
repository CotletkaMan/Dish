package client.mainContent.activites;

import client.mainContent.ClientFactory;
import client.mainContent.presenters.BasicPresenter;
import client.mainContent.views.BasicView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class BasicPresenterImpl extends AbstractActivity implements  BasicPresenter{
    private ClientFactory clientFactory;
    private BasicView basicView;

    public BasicPresenterImpl(Place place , ClientFactory factory){
        this.clientFactory = factory;
    }

    public void start(AcceptsOneWidget panel, com.google.gwt.event.shared.EventBus eventBus) {
        basicView = clientFactory.getBasicView();
        panel.setWidget(basicView.asWidget());
    }
}
