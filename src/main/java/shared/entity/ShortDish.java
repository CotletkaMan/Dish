package shared.entity;

import java.util.Date;
import java.util.Map;

/**
 * Created by cotletkaman on 16.02.16.
 */
public class ShortDish {
    private String name;
    private byte[] image;
    private Map<Ingredients , Integer> ingredientsList;
    private Date timeCooking;
    private Integer count;

    public ShortDish(AppDish dish){
        this.name = dish.getDish().getName();
        this.image = dish.getDish().getImage();
        this.ingredientsList = dish.getDish().getIngredients();
        this.timeCooking = dish.getDish().getTime();
        this.count = dish.getDish().getCount();
    }

    public String getName(){
        return name;
    }

    public byte[] getImage(){
        return image;
    }

    public Map<Ingredients , Integer> getIngredientsList(){
        return ingredientsList;
    }

    public Date getTimeCooking(){
        return timeCooking;
    }

    public Integer getCount(){
        return count;
    }
}
