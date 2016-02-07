package server.DAOoperations.AppDishOperaion;

import shared.entity.TypeDishes;

import javax.ejb.Stateful;

/**
 * Created by cotletkaman on 05.02.16.
 */
@Stateful
public class AppDishState{
    private TypeDishes typeDishes;
    public AppDishState(){
        typeDishes = null;
    }

    public TypeDishes getTypeDishes(){
        return typeDishes;
    }

    public void setTypeDishes(TypeDishes dishes){
        this.typeDishes = dishes;
    }
}
