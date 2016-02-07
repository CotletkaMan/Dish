package server.DAOoperations.AppDishOperaion;

import server.DAOoperations.BasicCollectionOperations;
import shared.entity.AppDish;
import shared.entity.Ingredients;
import shared.entity.TypeDishes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cotletkaman on 03.02.16.
 */
@Stateless
public class AppDishCollectionImpl implements BasicCollectionOperations<AppDish> , ExtendAppDishOperation{
    @PersistenceContext(unitName = "PersistJPA")
    private EntityManager entityManager;

    @EJB
    private AppDishState appDishState;

    public List<AppDish> findAll(){
        appDishState.setTypeDishes(null);
        return entityManager.createQuery("SELECT dish FROM AppDish dish" , AppDish.class).getResultList();
    }

    public List<AppDish> findLast(int count){
        return entityManager.createQuery("SELECT dish FROM AppDish dish ORDER BY dish.id DESC" , AppDish.class).setMaxResults(count).getResultList();
    }

    public List<AppDish> filter(HashMap<String , Object> attr){
        Filter filter = new IngredientFilter((List<Ingredients>)attr.get("ingredient")).setFilter(new TypeFilter(appDishState.getTypeDishes()).setFilter(new NameFilter((String)attr.get("name"),entityManager)));
        return filter.perform();
    }

    public List<AppDish> getType(TypeDishes typeDishes){
        appDishState.setTypeDishes(typeDishes);
        return entityManager.createQuery("SELECT appDish FROM AppDish appDish WHERE appDish.dish.typeDishes = :typeDish" , AppDish.class).setParameter("typeDish" , typeDishes).getResultList();
    }
}
