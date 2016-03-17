package client.mainContent;

import client.mainContent.places.*;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({AddNewPlace.Tokenizer.class, AllDishPlace.Tokenizer.class, BasicPlace.Tokenizer.class, DesertDishPlace.Tokenizer.class, DishPlace.Tokenizer.class , FirstDishPlace.Tokenizer.class , SecondDishPlace.Tokenizer.class})
public interface AppPlacesHistoryMapper extends PlaceHistoryMapper {
}
