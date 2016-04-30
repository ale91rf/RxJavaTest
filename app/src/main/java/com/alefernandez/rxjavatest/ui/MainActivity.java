package com.alefernandez.rxjavatest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alefernandez.rxjavatest.R;
import com.alefernandez.rxjavatest.model.Post;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity implements MainView{

    @Bind(R.id.btnStart)
    Button mBtnStart;

    @Bind(R.id.pBarDownloading)
    ProgressBar mProgress;

    @Bind(R.id.lblTitle)
    TextView mLblTitle;

    @Bind(R.id.lblBody)
    TextView mLblBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showProgressBar() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setEnabledButton(boolean aEnabled) {
        mBtnStart.setEnabled(aEnabled);
    }

    @Override
    public void displayPost(Post aPost) {
        mLblTitle.setText(aPost.getTitle());
        mLblBody.setText(aPost.getBody());
    }

    @Override
    public void showMessage(String aMessage) {
        Toast.makeText(getApplicationContext(), aMessage, Toast.LENGTH_LONG).show();
    }
}
