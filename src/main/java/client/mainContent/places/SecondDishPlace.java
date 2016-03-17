package client.mainContent.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class SecondDishPlace extends Place {
    public SecondDishPlace(){}

    public static class Tokenizer implements PlaceTokenizer<SecondDishPlace>{
        public SecondDishPlace getPlace(String token) {
            return new SecondDishPlace();
        }

        public String getToken(SecondDishPlace place) {
            return null;
        }
    }
}
