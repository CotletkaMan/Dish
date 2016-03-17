package client.mainContent.views.uiBinder;

import client.mainContent.views.DishesUnitView;
import client.mainContent.views.DishesView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import shared.entity.ShortDish;

import java.util.List;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class DishesViewImpl extends Composite implements DishesView {
    private static UiBinderImpl uiBinder = GWT.create(UiBinderImpl.class);
    interface UiBinderImpl extends UiBinder<Widget, DishesViewImpl> {}

    @UiField
    VerticalPanel content;

    @UiField
    Label header;

    public DishesViewImpl(){
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void addDish(DishesUnitView view){
        content.add(view);

    }

    public void setTitle(String text){
        header.setText(text + ":");
    }
}
