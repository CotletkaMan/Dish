package client.mainContent;

import client.mainContent.views.*;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import shared.RemoteAccess;

public interface ClientFactory {
	EventBus getEventBus();
	AddNewView getAddNewView();
	BasicView getBasicView();
	DishesUnitView getDishesUnitView();
	DishesView getDishesView();
	DishView getDishView();
	PlaceController getPlaceController();
	RemoteAccess getRemoteAccess();
}
