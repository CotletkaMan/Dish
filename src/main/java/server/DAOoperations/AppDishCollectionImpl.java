package server.DAOoperations;

import shared.entity.AppDish;
import shared.entity.Ingredients;
import shared.entity.ShortDish;
import shared.entity.TypeDishes;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cotletkaman on 03.02.16.
 */
@Stateless
@LocalBean
public class AppDishCollectionImpl implements BasicCollectionOperations<ShortDish> , ExtendAppDishOperation{
    @PersistenceContext(unitName = "PersistJPA")
    private EntityManager entityManager;

    public List<ShortDish> findAll(){
        List<AppDish> appDishList = entityManager.createQuery("SELECT dish FROM AppDish dish" , AppDish.class).getResultList();
        List<ShortDish> shortDishList = new LinkedList<ShortDish>();
        for(AppDish dish : appDishList)
            shortDishList.add(new ShortDish(dish));
        System.out.println(shortDishList.size());
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
        Filter filter = new IngredientFilter((List<Ingredients>)attr.get("ingredient")).setFilter(new NameFilter((String)attr.get("name"),entityManager));
        List<AppDish> appDishList = filter.perform();
        List<ShortDish> shortDishList = new LinkedList<ShortDish>();
        for(AppDish dish : appDishList)
            shortDishList.add(new ShortDish(dish));
        return shortDishList;
    }

    public List<ShortDish> getType(TypeDishes typeDishes){
        if(typeDishes == TypeDishes.ALL)
            return findAll();
        List<AppDish> appDishList =  entityManager.createQuery("SELECT appDish FROM AppDish appDish WHERE appDish.dish.typeDishes = :typeDish" , AppDish.class).setParameter("typeDish" , typeDishes).getResultList();
        List<ShortDish> shortDishList = new LinkedList<ShortDish>();
        for(AppDish dish : appDishList)
            shortDishList.add(new ShortDish(dish));
        return shortDishList;
    }

    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }
}
