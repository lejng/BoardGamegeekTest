package gamegeek.portal.pages;

import base.BaseComponent;
import gamegeek.portal.components.HeaderComponent;
import gamegeek.portal.modals.LoginModalDialog;

public abstract class BoardGamegeekBasePage extends BaseComponent {

    public HeaderComponent getHeaderComponent(){
        return new HeaderComponent();
    }

    public LoginModalDialog getLoginModalDialog(){
        return new LoginModalDialog();
    }
}
