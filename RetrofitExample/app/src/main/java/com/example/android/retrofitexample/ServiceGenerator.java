package com.example.android.retrofitexample;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static String apiBaseUrl = "https://api.github.com";
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .addConverterFactory(GsonConverterFactory.create());
    //in order to configure retrofit easily, we create a Retrofit builder object.

    //1st is the base url, we have relative urls specified in the interface which has an
    // advantage that we need to change the base url only and not the endpoints

    //next we have a converter, we need "gson" to convert between java objects and json

    private static Retrofit retrofit = builder.build();
    //we make both the objects as static beacuse we want to have only one instance in the entire class

    private ServiceGenerator(){

    }

    //this method will change that particular apiBaseUrl variable. It also creates a new version
    // of the Retrofit.Builder instance builder. This is important because we're re-using the builder
    // for requests. If we don't create a new instance all requests still would have gone against
    // the original apiBaseUrl value.
    public static void changeApiBaseUrl(String newApiBaseUrl){

        apiBaseUrl = newApiBaseUrl;

        builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(apiBaseUrl);
    }

    //For logging, you will need a OkHttp interceptor which intercepts every request and then logs it
    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

    //to make this method more dynamic you use generics type here
    //by using generics we have made a more dynamic method in which different activities which use
    // different APIs can use this method to make their network request
    public static <S> S createService(Class<S> serviceClass){

        if (!httpClientBuilder.interceptors().contains(loggingInterceptor)){

            httpClientBuilder.addInterceptor(loggingInterceptor);
            builder = builder.client(httpClientBuilder.build());
            retrofit = builder.build();

        }


        return retrofit.create(serviceClass);
    }
}
