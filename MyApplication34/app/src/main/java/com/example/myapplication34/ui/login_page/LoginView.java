package com.example.myapplication34.ui.login_page;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface LoginView extends MvpView {
    void setButtonInputText(String s);
    void setSystemMassage(String s);
    void checkLoginAndPass();
    void blockButtonReset();

//--view page control---------
    void goInUserListPage();
}
