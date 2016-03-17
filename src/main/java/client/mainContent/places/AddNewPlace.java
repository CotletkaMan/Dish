package client.mainContent.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class AddNewPlace extends Place {
    public AddNewPlace(){

    }

    public static class Tokenizer implements PlaceTokenizer<AddNewPlace>{
        public AddNewPlace getPlace(String token) {
            return new AddNewPlace();
        }

        public String getToken(AddNewPlace place) {
            return null;
        }
    }
}
