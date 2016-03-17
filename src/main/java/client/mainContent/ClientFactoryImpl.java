package client.mainContent;

import client.mainContent.views.*;
import client.mainContent.views.uiBinder.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import shared.RemoteAccess;


public class ClientFactoryImpl implements ClientFactory{

	private static EventBus eventBus;
	private static PlaceController placeController;
	private static AddNewView addNewView;
	private static BasicView basicView;
	private static DishView dishView;
	private static RemoteAccess remoteAccess;

	
	public EventBus getEventBus() {
		if (eventBus == null) eventBus = new SimpleEventBus();
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		if (placeController == null) placeController = new PlaceController(getEventBus());
		return placeController;
	}

	public BasicView getBasicView(){
		if(basicView == null)
			basicView = new BasicViewImpl();
		return basicView;
	}

	public DishesUnitView getDishesUnitView(){
		return new DishesUnitViewImpl();
	}

	public AddNewView getAddNewView(){
		if(addNewView == null)
			addNewView = new AddNewViewImpl();
		return addNewView;
	}

	public DishesView getDishesView(){
		return new DishesViewImpl();
	}

	public DishView getDishView(){
		if(dishView == null)
			dishView = new DishViewImpl();
		return dishView;
	}

	public RemoteAccess getRemoteAccess(){
		if(remoteAccess == null)
			remoteAccess = GWT.create(RemoteAccess.class);
		return remoteAccess;
	}

}