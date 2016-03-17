package server.DAOoperations;


import shared.entity.AppDish;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by cotletkaman on 05.02.16.
 */
class NameFilter extends Filter {
    private String name;
    private EntityManager entityManager;

    NameFilter(String name , EntityManager entityManager){
        this.name = name;
        this.entityManager = entityManager;
    }

    public List<AppDish> perform(){
        if(name != null && !name.isEmpty())
            return entityManager.createQuery("SELECT appDish FROM AppDish appDish WHERE appDish.dish.name LIKE %:name%" , AppDish.class).setParameter("name" , name).getResultList();
        else
            return entityManager.createQuery("SELECT appDish FROM AppDish" , AppDish.class).getResultList();
    }
}
