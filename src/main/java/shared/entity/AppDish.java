package shared.entity;

import javax.persistence.*;

/**
 * Created by cotletkaman on 02.02.16.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AppDish extends Statistics{


    private Long id;

    private Dish dish;

    public AppDish(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_fk" , nullable = false)
    public Dish getDish(){
        return dish;
    }

    public void setDish(Dish dish){
        this.dish = dish;
    }

}
