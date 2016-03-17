package client.mainContent.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class AllDishPlace extends Place {
    public AllDishPlace(){}

    public static class Tokenizer implements PlaceTokenizer<AllDishPlace>{
        public AllDishPlace getPlace(String token) {
            return new AllDishPlace();
        }

        public String getToken(AllDishPlace place) {
            return null;
        }
    }
}
