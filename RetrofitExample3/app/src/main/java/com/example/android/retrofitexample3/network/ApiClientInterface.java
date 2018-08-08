package com.example.android.retrofitexample3.network;

import com.example.android.retrofitexample3.model.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiClientInterface {

    //defining the end points for the network requests for each method
    @GET("photos")
    Call<List<RetroPhoto>> getAllPhotos();
}
