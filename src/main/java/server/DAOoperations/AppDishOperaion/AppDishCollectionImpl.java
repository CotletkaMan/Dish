package server.DAOoperations.AppDishOperaion;

import server.DAOoperations.BasicCollectionOperations;
import shared.entity.AppDish;
import shared.entity.Ingredients;
import shared.entity.ShortDish;
import shared.entity.TypeDishes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cotletkaman on 03.02.16.
 */
@Stateless
public class AppDishCollectionImpl implements BasicCollectionOperations<ShortDish> , ExtendAppDishOperation{
    @PersistenceContext(unitName = "PersistJPA")
    private EntityManager entityManager;

    @EJB
    private AppDishState appDishState;

    public List<ShortDish> findAll(){
        appDishState.setTypeDishes(null);
        List<AppDish> appDishList = entityManager.createQuery("SELECT dish FROM AppDish dish" , AppDish.class).getResultList();
        List<ShortDish> shortDishList = new LinkedList<ShortDish>();
        for(AppDish dish : appDishList)
            shortDishList.add(new ShortDish(dish));
        return shortDishList;

    }

    public List<ShortDish> findLast(int count){
        List<AppDish> appDishList = entityManager.createQuery("SELECT dish FROM AppDish dish ORDER BY dish.id DESC" , AppDish.class).setMaxResults(count).getResultList();
        List<ShortDish> shortDishList = new LinkedList<ShortDish>();
        for(AppDish dish : appDishList)
            shortDishList.add(new ShortDish(dish));
        return shortDishList;
    }

    public List<ShortDish> filter(HashMap<String , Object> attr){
        Filter filter = new IngredientFilter((List<Ingredients>)attr.get("ingredient")).setFilter(new TypeFilter(appDishState.getTypeDishes()).setFilter(new NameFilter((String)attr.get("name"),entityManager)));
        List<AppDish> appDishList = filter.perform();
        List<ShortDish> shortDishList = new LinkedList<ShortDish>();
        for(AppDish dish : appDishList)
            shortDishList.add(new ShortDish(dish));
        return shortDishList;
    }

    public List<ShortDish> getType(TypeDishes typeDishes){
        appDishState.setTypeDishes(typeDishes);
        List<AppDish> appDishList =  entityManager.createQuery("SELECT appDish FROM AppDish appDish WHERE appDish.dish.typeDishes = :typeDish" , AppDish.class).setParameter("typeDish" , typeDishes).getResultList();
        List<ShortDish> shortDishList = new LinkedList<ShortDish>();
        for(AppDish dish : appDishList)
            shortDishList.add(new ShortDish(dish));
        return shortDishList;
    }
}
