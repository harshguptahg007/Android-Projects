package com.example.android.retrofitexample;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface GitHubClient {

    //our goal is to implement an app to show a list of repositories from a user

    @GET("/users/{user}/repos")//here we also tell where the endpoint for the request is
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);
    //the curly bracket in the GET annotation is a path parameter. so if you have a API location
    // where one thing is dynamic. for dynamic keeping, what you do is you describe a variable with
    // curly brackets around them and the same variable will be described as apath parameter again as an annotation


    //now we describe what kind of HTTP method is and where actually goes to i.e. the URL basically
    @GET("/user/info")
    Call<UserInfo> getUserInfo();

    @PUT("user/info")
    Call<Void> updateUserInfo();

    @DELETE
    Call<ResponseBody> deleteUser();

    /*
    //one of the awesome things of retrofit is that you can actually provide a full URL here
    //this method will completely igmore the base url and would just use the URL specified here
    //we don't use this kind of method because in most cases you want to have a consistent design
    // and use the base URL because if the base URL changes you can just change it in one place
    // and don't have to go through every single thing
    @DELETE("http://futurestud.io/api/user")
    Call<ResponseBody> deleteUser();
    */

    //here we know that the url is dynamic so we remove the relative url in the annotaion and pass the url as a parameter
    @GET
    Call<ResponseBody> getProfilePhoto(
            @Url String url
    );

    class UserInfo {
    }


    //the function name that we specify here doesn't matter at all to retrofit. We use function
    // name to make clear to you what's this call is going to be
    //what does matter is that you want to describe what's the return object, what is the response
    // from the service, and you always do that in retrofit with the CALL method. So you return the
    // CALL object and the type of this call object describes the response.
    //You can use Void as a return type in CALL object

    //if you don't want to do any mapping and just say give me just the raw response of the request,
    // you can use ResponseBody. Response Body is a retrofit class which will take C Silver spawns
    // and make it accessible to you but not order any automatic mapping to Java objects or anything like that.

}
