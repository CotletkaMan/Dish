package server.DAOoperations;

import shared.entity.AppDish;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by cotletkaman on 03.02.16.
 */
@Stateless
@LocalBean
public class AppDishCRUDImpl implements CRUDinterface<AppDish> {

    @PersistenceContext(unitName = "PersistJPA")
    private EntityManager entityManager;

    public AppDish create(AppDish dish){
        entityManager.persist(dish);
        return dish;
    }

    public AppDish delete(AppDish dish){
        entityManager.remove(dish);
        return dish;
    }

    public AppDish update(AppDish dish){
        entityManager.merge(dish);
        return dish;
    }

    public AppDish findById(Long id){
        return entityManager.find(AppDish.class , id);
    }
}
