package com.example.android.retrofitexample3.activtiy;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.android.retrofitexample3.R;
import com.example.android.retrofitexample3.recycler.RecyclerAdapter;
import com.example.android.retrofitexample3.model.RetroPhoto;
import com.example.android.retrofitexample3.network.ApiClientInterface;
import com.example.android.retrofitexample3.network.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating a Progress Dialog to come in front on the main UI thread till the network request is taking place
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading....");//setting message on the progress dialog
        progressDialog.show();

        //handling the network request here and starting the retrofit network request here
        ApiClientInterface apiClientInterface = DataService.createService().create(ApiClientInterface.class);

        Call<List<RetroPhoto>> call  =apiClientInterface.getAllPhotos();
        //getting the result in a call object

        call.enqueue(new Callback<List<RetroPhoto>>() {
            //these two methods execute on the main thread
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                progressDialog.dismiss();
                generateData(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this,
                        "Something went wrong... Please try again later!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateData(List<RetroPhoto> body) {

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager linearLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerAdapter(this, (ArrayList<RetroPhoto>) body);
        recyclerView.setAdapter(adapter);
    }


}
