package com.alefernandez.rxjavatest.ui;

import android.content.Context;

import com.alefernandez.rxjavatest.model.Post;

/**
 * Created by alejandro on 30/4/16.
 */
public interface MainView {

    public void showProgressBar();

    public void hideProgressBar();

    public void setEnabledButton(boolean aEnabled);

    public void displayPost(Post aPost);

    public void showMessage(String aMessage);

}
