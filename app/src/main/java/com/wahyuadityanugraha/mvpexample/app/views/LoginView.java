package com.wahyuadityanugraha.mvpexample.app.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.wahyuadityanugraha.mvpexample.app.finditems.FeedActivity;
import com.wahyuadityanugraha.mvpexample.app.login.LoginFunction;
import com.wahyuadityanugraha.mvpexample.app.R;
import com.wahyuadityanugraha.mvpexample.app.login.LoginPresenter;
import com.wahyuadityanugraha.mvpexample.app.login.LoginPresenterImpl;

/**
 * Created by wahyuadityanugraha on 8/19/14.
 */
public class LoginView extends LinearLayout implements LoginFunction, View.OnClickListener{

    private EditText username;
    private EditText password;
    private Button button;
    private ProgressBar progress;
    private LoginPresenter presenter;

    public LoginView(Context context) {
        super(context);
        init();
    }

    public LoginView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoginView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.login_view, this, true);
        presenter = new LoginPresenterImpl(this);
        findViews();
    }


    private void findViews() {
        username = (EditText)findViewById( R.id.username );
        password = (EditText)findViewById( R.id.password );
        button = (Button)findViewById( R.id.button );
        progress = (ProgressBar)findViewById( R.id.progress );
        button.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        if ( v == button ) {
            presenter.validateCredentials(username.getText().toString(), password.getText().toString());
        }
    }

    @Override public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override public void setUsernameError() {
        username.setError(getContext().getString(R.string.username_error));
    }

    @Override public void setPasswordError() {
        password.setError(getContext().getString(R.string.password_error));
    }

    @Override public void navigateToHome() {
        getContext().startActivity(new Intent(getContext(), FeedActivity.class));
        ((Activity)getContext()).finish();
    }


}
