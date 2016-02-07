package server.DAOoperations.AppDishOperaion;

import shared.entity.AppDish;
import shared.entity.TypeDishes;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cotletkaman on 04.02.16.
 */
public interface ExtendAppDishOperation {
    List<AppDish> filter(HashMap<String , Object> attr);
    List<AppDish> getType(TypeDishes typeDishes);
}
