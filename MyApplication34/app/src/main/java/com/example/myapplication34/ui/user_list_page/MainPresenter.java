package com.example.myapplication34.ui.user_list_page;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myapplication34.app.App;
import com.example.myapplication34.data.UserDataModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {


   public void  onGo2(){

       Completable.fromAction(()->{
           UserDataModel userDataModel = new UserDataModel();
               userDataModel.birthday ="11/12/2342";
               userDataModel.features="123456789";
               userDataModel.firstName="ghjghj";
               userDataModel.lastName = "ghjghj";
               App.getInstance().getDatabase().userDao().insertAll(userDataModel);
       }).subscribeOn(Schedulers.single()).subscribe();

   }

   public void  onGo(){

       App.getInstance().getDatabase().userDao().findByNameAsin("ghjghj")
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new DisposableMaybeObserver<UserDataModel>() {
                   @Override
                   public void onSuccess(UserDataModel userDataModel1) {
                       getViewState().setStatus(userDataModel1.features);
                   }

                   @Override
                   public void onError(Throwable e) {
                       // ...
                   }

                   @Override
                   public void onComplete() {
                       // ...
                   }
               });
   }

}
