package server.DAOoperations.AppDishOperaion;

import shared.entity.AppDish;

import java.util.List;

/**
 * Created by cotletkaman on 05.02.16.
 */
abstract class Filter {
    protected Filter filter;
    public Filter setFilter(Filter filter){
        this.filter = filter;
        return this;
    }

    public Filter getFilter(){
        return filter;
    }

    public abstract List<AppDish> perform();
}
