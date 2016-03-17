package client.mainContent;

import client.mainContent.places.BasicPlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class MainPanel extends Composite{
    interface UiBinderImpl extends UiBinder<Widget, MainPanel> {}
    private static UiBinderImpl uiBinder = GWT.create(UiBinderImpl.class);

    EventBus eventBus;
    ClientFactory clientFactory = GWT.create(ClientFactory.class);
    BasicPlace basicPlace = new BasicPlace();

    @UiField
    ScrollPanel content;

    public MainPanel(){
        initWidget(uiBinder.createAndBindUi(this));
        eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(content);

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlacesHistoryMapper historyMapper= GWT.create(AppPlacesHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, basicPlace);

        // Goes to the place represented on URL else default place
        historyHandler.handleCurrentHistory();
    }
}
