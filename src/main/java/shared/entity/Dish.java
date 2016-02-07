package shared.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Основной класс блюд
 * Created by cotletkaman on 02.02.16.
 */
@Entity
public class Dish {

    private Long id;

    //Имя блюда
    private String name;

    //Картинка
    private byte[] image;

    //Список ингридиентов
    private Map<Ingredients , Integer> ingredients;

    //Последовательность приготовления
    private List<String> recipe;

    //Время приготовления
    private Date time;

    //Количество порций
    private int count;

    private TypeDishes typeDishes;


    public Dish(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Column(length = 100 , nullable = false)
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Lob
    public byte[] getImage(){
        return image;
    }

    public void setImage(byte[] image){
        this.image = image;
    }


    @ElementCollection
    @MapKeyEnumerated(value = EnumType.STRING)
    @MapKeyColumn(name = "Ingredient" , nullable = false)
    @Column(name = "Count" , nullable = false)
    public Map<Ingredients , Integer> getIngredients(){
        return ingredients;
    }

    public void setIngredients(Map<Ingredients , Integer> ingredients){
        this.ingredients = ingredients;
    }

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "Recipes")
    @Column(name = "Steps" , nullable = false)
    public List<String> getRecipe(){
        return recipe;
    }

    public void setRecipe(List<String> recipe){
        this.recipe = recipe;
    }

    @Temporal(TemporalType.TIME)
    public Date getTime(){
        return time;
    }

    public void setTime(Date time){
        this.time = time;
    }

    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    @Enumerated(value = EnumType.STRING)
    public TypeDishes getTypeDishes(){
        return typeDishes;
    }

    public void setTypeDishes(TypeDishes dishes){
        this.typeDishes = dishes;
    }
}
