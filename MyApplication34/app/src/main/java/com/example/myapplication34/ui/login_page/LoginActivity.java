package com.example.myapplication34.ui.login_page;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.myapplication34.R;
import com.example.myapplication34.app.App;
import com.example.myapplication34.ui.user_list_page.MainActivity;

public class LoginActivity extends MvpAppCompatActivity implements LoginView {

    @InjectPresenter
    LoginPresenter loginPresenter;

    TextView loginTextBox;
    TextView PasswordTextBox;
    TextView SysMess;
    Button buttonInput;
    Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        PasswordTextBox = findViewById(R.id.Password);
        loginTextBox = findViewById(R.id.Login);
        buttonInput = findViewById(R.id.buttonInput);
        buttonReset = findViewById(R.id.buttonReset);
        ///buttonReset.setClickable();
        SysMess = findViewById(R.id.SysMess);
        buttonInput.setOnClickListener(x-> { loginPresenter.btnSet(); });
        buttonReset.setOnClickListener(x->{loginPresenter.btnReset();});
    }
    @Override
    public void setButtonInputText(String s) {
        buttonInput.setText(s);
    }
    @Override
    public  void setSystemMassage(String s){
        SysMess.setText(s);
    }
    @Override
    public void checkLoginAndPass(){loginPresenter.loginInit(loginTextBox.getText().toString(),PasswordTextBox.getText().toString()); }
    @Override
    public void blockButtonReset(){ buttonReset.setClickable(false);}
    @Override
    public void goInUserListPage() {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
    }

}

