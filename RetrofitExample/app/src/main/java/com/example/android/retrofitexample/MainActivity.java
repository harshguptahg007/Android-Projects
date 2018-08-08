package com.example.android.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);


        //now we need an instance of the github client
        GitHubClient client = ServiceGenerator.createService(GitHubClient.class);
        Call<List<GitHubRepo>> call = client.reposForUser("fs-opensource");

        call.enqueue(new Callback<List<GitHubRepo>>() {
            //the callback will be executed once we get the response back from the server back
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                //called when you actually got a repsonse from the server
                List<GitHubRepo> repos = response.body();
                //body is the reponse of the network query

                listView.setAdapter(new GitHubRepoAdapter(MainActivity.this,repos));
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                //called if there is a network failure, like no internet.

                Toast.makeText(MainActivity.this,"error loading data",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
