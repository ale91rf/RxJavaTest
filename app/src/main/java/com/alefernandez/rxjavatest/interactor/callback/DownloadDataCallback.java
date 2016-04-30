package com.alefernandez.rxjavatest.interactor.callback;

import com.alefernandez.rxjavatest.model.Post;

/**
 * Created by alejandro on 30/4/16.
 */
public interface DownloadDataCallback {

    public void dataDownloaded(Post aPost);

    public void noDataToDownload(String mText);

}
