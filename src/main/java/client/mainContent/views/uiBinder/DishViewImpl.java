package client.mainContent.views.uiBinder;

import client.mainContent.presenters.DishPresenter;
import client.mainContent.views.DishView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import shared.entity.AppDish;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class DishViewImpl extends Composite implements DishView {
    private static UiBinderImpl uiBinder = GWT.create(UiBinderImpl.class);
    interface UiBinderImpl extends UiBinder<Widget, DishViewImpl> {}

    private DishPresenter presenter;

    @UiField
    TextBox name;

    @UiField
    TextBox type;

    @UiField
    TextBox recipe;

    @UiField
    Button backButton;

    public DishViewImpl(){
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setPresenter(DishPresenter presenter){
        this.presenter = presenter;
    }

    @UiHandler("backButton")
    public void back(ClickEvent event){
        presenter.back();
    }

    public void setDish(AppDish dish){
        name.setText(dish.getDish().getName());
        type.setText(dish.getDish().getTypeDishes().toString());
        recipe.setText(dish.getDish().getRecipe().get(0));
    }
}
