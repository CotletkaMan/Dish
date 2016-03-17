package client.mainContent.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class DishPlace extends Place {
    private String id;

    public DishPlace(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public static class Tokenizer implements PlaceTokenizer<DishPlace>{
        public DishPlace getPlace(String token) {
            return new DishPlace(token);
        }

        public String getToken(DishPlace place) {
            return place.getId();
        }
    }
}
