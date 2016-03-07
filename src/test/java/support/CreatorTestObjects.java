package support;

import shared.entity.AppDish;
import shared.entity.Dish;
import shared.entity.Ingredients;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by cotletkaman on 03.02.16.
 */
public class CreatorTestObjects {
    public static AppDish getAppDish(){
        AppDish appDish = new AppDish();
        appDish.setCountLike(0L);
        appDish.setCountView(0L);
        appDish.setCreateDate(new Date());

        Dish dish = new Dish();

        appDish.setDish(dish);
        appDish.getDish().setCount(1);
        appDish.getDish().setImage(null);
        appDish.getDish().setName("FooObject");
        appDish.getDish().setTime(null);

        HashMap<Ingredients , Integer> map = new HashMap<Ingredients, Integer>();
        map.put(Ingredients.CARROT , 1);
        map.put(Ingredients.TOMATO , 2);

        ArrayList<String> recipe = new ArrayList<String>();
        recipe.add("first row");
        recipe.add("second row");

        appDish.getDish().setIngredients(map);
        appDish.getDish().setRecipe(recipe);

        return appDish;
    }
}
