package server.DAOoperations.AppDishOperaion;

import shared.entity.ShortDish;
import shared.entity.TypeDishes;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cotletkaman on 04.02.16.
 */
public interface ExtendAppDishOperation {
    List<ShortDish> filter(HashMap<String , Object> attr);
    List<ShortDish> getType(TypeDishes typeDishes);
}
