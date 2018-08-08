package com.example.android.retrofitexample3.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataService {

    //creating a sustainable client for the network requests throughout the app

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    //defining the base url for all the network request

    public static Retrofit createService ()
    {
        if (retrofit==null){

            //creating the Retrofit object
            Retrofit.Builder builder = new Retrofit.Builder().
                    baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create());

            retrofit = builder.build();
        }
        return retrofit;
    }

}
