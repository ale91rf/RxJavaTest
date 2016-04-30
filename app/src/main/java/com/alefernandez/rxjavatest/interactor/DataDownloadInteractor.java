package com.alefernandez.rxjavatest.interactor;

import com.alefernandez.rxjavatest.interactor.callback.DownloadDataCallback;
import com.alefernandez.rxjavatest.model.Post;
import com.alefernandez.rxjavatest.networking.NetworkRequest;
import com.alefernandez.rxjavatest.networking.RestAPI;

import rx.Subscription;

/**
 * Created by alejandro on 30/4/16.
 */
public class DataDownloadInteractor {

    private RestAPI mApi;

    private Subscription mGetPostSubscription;

    public DataDownloadInteractor(RestAPI aApi) {
        mApi = aApi;
    }

    public void downloadData(final DownloadDataCallback aCallback) {
        mGetPostSubscription = NetworkRequest.performAsyncRequest(mApi.getPost(1), (data) -> {
            aCallback.dataDownloaded(data);
        }, (error) -> {
            aCallback.noDataToDownload(error.toString());
        });
    }
}
