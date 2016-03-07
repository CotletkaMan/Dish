package server.DAOoperations;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by cotletkaman on 03.02.16.
 */
public interface BasicCollectionOperations<T>{
    List<T> findAll();
    List<T> findLast(int count);
}
