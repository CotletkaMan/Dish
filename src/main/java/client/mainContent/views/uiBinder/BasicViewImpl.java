package client.mainContent.views.uiBinder;

import client.mainContent.views.BasicView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by cotletkaman on 14.03.16.
 */
public class BasicViewImpl extends Composite implements BasicView {
    private static BasicViewImplUiBinder uiBinder = GWT.create(BasicViewImplUiBinder.class);
    interface BasicViewImplUiBinder extends UiBinder<Widget, BasicViewImpl> {}

    public BasicViewImpl(){
        initWidget(uiBinder.createAndBindUi(this));
    }

}
