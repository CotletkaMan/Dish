package server.rest;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import server.DAOoperations.AppDishCRUDImpl;
import server.DAOoperations.AppDishCollectionImpl;

/**
 * Created by cotletkaman on 17.03.16.
 */
public class CDIBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(AppDishCollectionImpl.class).to(AppDishCollectionImpl.class);
        bind(AppDishCRUDImpl.class).to(AppDishCRUDImpl.class);

    }


}
