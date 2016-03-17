package client.mainContent.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class BasicPlace extends Place {
    public BasicPlace(){}

    public static class Tokenizer implements PlaceTokenizer<BasicPlace>{
        public BasicPlace getPlace(String token) {
            return new BasicPlace();
        }

        public String getToken(BasicPlace place) {
            return null;
        }
    }
}
