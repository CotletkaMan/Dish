package client.mainContent.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class FirstDishPlace extends Place {
    public FirstDishPlace(){}

    public static class Tokenizer implements PlaceTokenizer<FirstDishPlace>{
        public FirstDishPlace getPlace(String token) {
            return new FirstDishPlace();
        }

        public String getToken(FirstDishPlace place) {
            return null;
        }
    }
}
