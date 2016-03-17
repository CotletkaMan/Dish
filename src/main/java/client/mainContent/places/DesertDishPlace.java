package client.mainContent.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class DesertDishPlace extends Place {
    public DesertDishPlace(){}

    public static class Tokenizer implements PlaceTokenizer<DesertDishPlace>{
        public DesertDishPlace getPlace(String token) {
            return new DesertDishPlace();
        }

        public String getToken(DesertDishPlace place) {
            return null;
        }
    }
}
