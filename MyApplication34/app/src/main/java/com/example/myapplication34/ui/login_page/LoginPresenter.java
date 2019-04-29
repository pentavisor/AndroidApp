package com.example.myapplication34.ui.login_page;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myapplication34.app.App;
import com.example.myapplication34.data.LoginAndPassModel;
import com.example.myapplication34.data.UserDataModel;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;
@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {
    LoginAndPassModel firstQueryLoginAndPassModel;
    public LoginPresenter(){
        App.getInstance().getDatabase().loginAndPassDao().findFirstEntry()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableMaybeObserver<LoginAndPassModel>() {
                    @Override
                    public void onSuccess(LoginAndPassModel loginAndPassModel)
                    {
                        firstQueryLoginAndPassModel = new LoginAndPassModel(loginAndPassModel.login,loginAndPassModel.password);
                        setMessageInText(loginAndPassModel);
                        //открыть кнопку входа и резет
                    }

                    @Override
                    public void onError(Throwable e) {
                        // ...
                    }

                    @Override
                    public void onComplete() {
                        LoginAndPassModel loginAndPassModel = null;
                        setMessageInText(loginAndPassModel);
                        //открыть кнопку входа
                    }
                });
    }
    public void btnSet(){

        getViewState().checkLoginAndPass();
    }

    public void loginInit(String login,String pass){
       if((firstQueryLoginAndPassModel == null)&(!login.isEmpty()&!pass.isEmpty())){
               Completable.fromAction(()->{
                   LoginAndPassModel loginAndPassModel = new LoginAndPassModel(login,pass);
                   App.getInstance().getDatabase().loginAndPassDao().insertAll(loginAndPassModel);
               }).subscribeOn(Schedulers.single()).subscribe();

           getViewState().goInUserListPage();
       } else {
           if (login.isEmpty()|pass.isEmpty()){
               getViewState().setSystemMassage("вам нужно заполнить поля логин и пароль!");
           }else {
               if ( (firstQueryLoginAndPassModel.login.equals(login))&(firstQueryLoginAndPassModel.password.equals(pass))){
                   getViewState().goInUserListPage();
               }else{
                   getViewState().setSystemMassage("пароль или логин введен не правильно, введите корректный пароль или сбросте старый и после сброса введите новый логин и пароль затем нажмите войти");
               }
           }

       }
    }
    public void btnReset(){
        // тут нужно затирать логин и пароль, и активировать кнопку set + менять на ней надпись на "Сохранить и войти"
        Completable.fromAction(()->{
            App.getInstance().getDatabase().loginAndPassDao().deleteAll();
        }).subscribeOn(Schedulers.single()).subscribe();
        firstQueryLoginAndPassModel = null;
        getViewState().blockButtonReset();
        getViewState().setSystemMassage("сброс прошел успешно. Запись с логином и паролем не найдена, введите логин и пароль, где логин это российский номер сотового телефона, а пароль должен содержать 8 или больше символов а так же иметь одну или больше прописную и заглавную букву.");

    }
    public void setMessageInText(LoginAndPassModel loginAndPassModel){
        if (loginAndPassModel==null){
            getViewState().setSystemMassage("Запись с логином и паролем не найдена, введите логин и пароль, где логин это российский номер сотового телефона, а пароль должен содержать 8 или больше символов а так же иметь одну или больше прописную и заглавную букву.");
            getViewState().blockButtonReset();
        }else{
            getViewState().setSystemMassage("Запись с логином и паролем найдена. Введите логин и пароль хранящиеся в базе для входа или сбросте его и введите новый.");
        }
    }


}
