package com.alefernandez.rxjavatest.networking;

import com.alefernandez.rxjavatest.model.Post;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by alejandro on 30/4/16.
 */
public interface RestAPI {

    String API_ENDPOINT = "http://jsonplaceholder.typicode.com";

    @GET("/posts/{id}")
    Observable<Post> getPost(@Path("id") int id);

}
