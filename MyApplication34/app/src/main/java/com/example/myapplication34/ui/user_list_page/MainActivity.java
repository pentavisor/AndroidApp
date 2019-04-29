package com.example.myapplication34.ui.user_list_page;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.myapplication34.R;
import com.example.myapplication34.app.App;
import com.example.myapplication34.data.UserDataModel;

import java.util.concurrent.TimeUnit;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    TextView status;
    Button button;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);
        status = findViewById(R.id.text1);
        button = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        //button.setOnClickListener(x->{setStatus("asdasda");});
        button.setOnClickListener(x->{mainPresenter.onGo();});
        button2.setOnClickListener(x->{mainPresenter.onGo2();});



    }

    @Override
    public void setStatus(String s) {
        status.setText(s);
    }

}
