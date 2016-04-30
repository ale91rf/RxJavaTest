package com.alefernandez.rxjavatest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alefernandez.rxjavatest.R;
import com.alefernandez.rxjavatest.model.Post;

public class MainActivity extends AppCompatActivity implements MainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void setEnabledButton(boolean aEnabled) {

    }

    @Override
    public void displayPost(Post aPost) {

    }

    @Override
    public void showMessage(String aMessage) {

    }
}
