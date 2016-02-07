package server.DAOoperations.AppDishOperaion;

import shared.entity.AppDish;
import shared.entity.Ingredients;

import java.util.Iterator;
import java.util.List;

/**
 * Created by cotletkaman on 05.02.16.
 */
class IngredientFilter extends Filter {
    private List<Ingredients> ingredientsList;

    IngredientFilter(List<Ingredients> ingredientsList){
        this.ingredientsList = ingredientsList;
    }

    public List<AppDish> perform(){
        List<AppDish> list = filter.perform();
        if(ingredientsList == null)
            return list;
        Iterator<AppDish> iterator = list.iterator();
        while(iterator.hasNext()){
            if(!iterator.next().getDish().getIngredients().keySet().containsAll(ingredientsList))
                iterator.remove();
        }
        return list;
    }
}
