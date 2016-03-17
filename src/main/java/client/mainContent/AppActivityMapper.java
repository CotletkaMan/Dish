package client.mainContent;

import client.mainContent.activites.*;
import client.mainContent.places.*;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

    private ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

	public Activity getActivity(Place place) {
        if (place instanceof AddNewPlace)
            return new AddNewPresenterImpl(place, clientFactory);
        else if (place instanceof AllDishPlace)
            return new AllDishesPresenterImpl(place, clientFactory);
        else if (place instanceof BasicPlace)
            return new BasicPresenterImpl(place, clientFactory);
        else if (place instanceof DesertDishPlace)
            return new DesertDishesPresenterImpl(place, clientFactory);
        else if (place instanceof DishPlace)
            return new DishPresenterImpl((DishPlace)place , clientFactory);
        else if (place instanceof FirstDishPlace)
            return new FirstDishesPresenterImpl(place , clientFactory);
        else if (place instanceof SecondDishPlace)
            return new SecondDishesPresenterImpl(place , clientFactory);
        return null;
	}

}
