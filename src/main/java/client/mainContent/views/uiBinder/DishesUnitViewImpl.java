package client.mainContent.views.uiBinder;

import client.mainContent.presenters.DishesUnitPresenter;
import client.mainContent.views.DishesUnitView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import shared.entity.ShortDish;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class DishesUnitViewImpl extends Composite implements DishesUnitView {
    private static UiBinderImpl uiBinder = GWT.create(UiBinderImpl.class);
    interface UiBinderImpl extends UiBinder<Widget, DishesUnitViewImpl> {}

    private DishesUnitPresenter presenter;

    @UiField
    Label field;

    public DishesUnitViewImpl(){
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setPresenter(DishesUnitPresenter presenter){
        this.presenter = presenter;
    }

    public void setDish(ShortDish dish){
        field.setText(dish.getName());

    }

    @UiHandler("field")
    public void click(ClickEvent event){
        presenter.lookDish();
    }
}
