package client.mainContent.views.uiBinder;

import client.mainContent.presenters.AddNewPresenter;
import client.mainContent.views.AddNewView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import shared.entity.Dish;
import shared.entity.Ingredients;
import shared.entity.TypeDishes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class AddNewViewImpl extends Composite implements AddNewView{
    private static AddNewViewImplUiBinder uiBinder = GWT.create(AddNewViewImplUiBinder.class);
    interface AddNewViewImplUiBinder extends UiBinder<Widget, AddNewViewImpl> {}

    private AddNewPresenter presenter;

    @UiField
    TextBox name;

    @UiField
    ListBox type;

    @UiField
    TextBox recipe;

    @UiField
    Button sendButton;

    @UiField
    ListBox ingredient;

    @UiField
    TextBox count;

    public AddNewViewImpl(){
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setPresenter(AddNewPresenter presenter){
        this.presenter = presenter;
    }

    @UiHandler("sendButton")
    public void send(ClickEvent event){
        Dish dish = new Dish();
        List<String> recipeList = new ArrayList<String>();
        Map<Ingredients, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredients.valueOf(ingredient.getSelectedItemText()) , Integer.parseInt(count.getText()));
        recipeList.add(recipe.getText());
        dish.setName(name.getText());
        dish.setTypeDishes(TypeDishes.valueOf(type.getSelectedItemText()));
        dish.setRecipe(recipeList);
        dish.setIngredients(ingredients);
        presenter.addNewDish(dish);
    }
}
