package server.rest;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import server.DAOoperations.AppDishCRUDImpl;
import server.DAOoperations.AppDishCollectionImpl;

/**
 * Created by cotletkaman on 03.03.16.
 */
public class CDIbinder extends AbstractBinder {
    @Override
    public void configure(){
        bind(AppDishCRUDImpl.class).to(AppDishCRUDImpl.class);
        bind(AppDishCollectionImpl.class).to(AppDishCollectionImpl.class);
    }
}
