package com.alefernandez.rxjavatest.presenter;

import com.alefernandez.rxjavatest.interactor.DataDownloadInteractor;
import com.alefernandez.rxjavatest.interactor.callback.DownloadDataCallback;
import com.alefernandez.rxjavatest.model.Post;
import com.alefernandez.rxjavatest.ui.MainView;

/**
 * Created by alejandro on 30/4/16.
 */
public class MainActivityPresenterImpl implements MainActivityPresenter, DownloadDataCallback{

    private MainView mMainView;
    private DataDownloadInteractor mDataDownloadInteractor;

    public MainActivityPresenterImpl(DataDownloadInteractor aDataDownloadInteractor, MainView aMainView) {
        this.mDataDownloadInteractor   = aDataDownloadInteractor;
        this.mMainView                 = aMainView;

    }

    @Override
    public void getDataFromAPI() {
        mMainView.setEnabledButton(false);
        mMainView.showProgressBar();
        mMainView.showMessage("Downloading data");

        mDataDownloadInteractor.downloadData(this);
    }

    @Override
    public void dataDownloaded(Post aPost) {
        mMainView.hideProgressBar();
        mMainView.setEnabledButton(true);
        mMainView.showMessage("Data Downloaded");
        mMainView.displayPost(aPost);
    }

    @Override
    public void noDataToDownload(String aMessage) {
        mMainView.hideProgressBar();
        mMainView.setEnabledButton(true);
        mMainView.showMessage(aMessage);
    }



}
