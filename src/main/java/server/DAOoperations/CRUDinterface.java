package server.DAOoperations;

import javax.ejb.Local;

/**
 * Created by cotletkaman on 03.02.16.
 */
public interface CRUDinterface<T> {
    T create(T object);
    T delete(T object);
    T update(T object);
    T findById(Long object);
}
