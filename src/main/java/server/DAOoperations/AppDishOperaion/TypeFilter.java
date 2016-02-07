package server.DAOoperations.AppDishOperaion;

import shared.entity.AppDish;
import shared.entity.TypeDishes;

import java.util.Iterator;
import java.util.List;

/**
 * Created by cotletkaman on 05.02.16.
 */
class TypeFilter extends Filter{
    private TypeDishes typeDishes;

    TypeFilter(TypeDishes typeDishes){
        this.typeDishes = typeDishes;
    }

    public List<AppDish> perform(){
        List<AppDish> list = filter.perform();
        if(typeDishes == null)
            return list;
        Iterator<AppDish> iterator = list.iterator();
        while(iterator.hasNext()){
            if(!iterator.next().getDish().getTypeDishes().equals(typeDishes))
                iterator.remove();
        }
        return list;
    }

}
