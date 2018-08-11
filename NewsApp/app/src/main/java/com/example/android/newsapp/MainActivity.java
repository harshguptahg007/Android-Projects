package com.example.android.newsapp;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<News>>
{

    private static final String LOG_TAG = MainActivity.class.getName();

    private static final String NEWS_URL =
            "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=17a2c3a3efeb4e16b303722db9522c80";

    private CustomAdapter adapter;

    private static final int NEWS_LOADER_ID = 1;

    private TextView mEmptyStateTextView;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        mEmptyStateTextView = findViewById(R.id.empty_view);
        progressBar = findViewById(R.id.loading_indicator);

        adapter = new CustomAdapter(this, new ArrayList<News>(), new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //leave it blank
            }
        });

        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        //Get details on the currently active default data network
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        //if there is a network connection, fetch data
        if (networkInfo!=null && networkInfo.isConnected()){

            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(NEWS_LOADER_ID,null,this);

        } else {
            progressBar.setVisibility(View.GONE);

            mEmptyStateTextView.setText("No Internet Connection");
            recyclerView.setVisibility(View.GONE);

        }

        mEmptyStateTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {

        Uri baseUri = Uri.parse(NEWS_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        //uriBuilder.appendQueryParameter("format", "geojson");
        uriBuilder.appendQueryParameter("limit", "10");

        return new NewsLoader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, final List<News> data) {

        progressBar.setVisibility(View.GONE);

        adapter.clear();

        // If there is a valid list of Earthquakes, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {

            //Log.i("VIVZ",data.size()+"");
            adapter = new CustomAdapter(this, data, new CustomItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {
                    //Log.d(LOG_TAG,"clicked position : " + position);
                    News currentNews = data.get(position);

//                    Intent in = new Intent(getApplicationContext(), NewsDetailView.class);
//                    in.putExtra("URL", currentNews.getUrl());
//                    startActivity(in);

                    // Convert the String URL into a URI object (to pass into the Intent constructor)
                    Uri earthquakeUri = Uri.parse(currentNews.getUrl());

                    // Create a new intent to view the earthquake URI
                    Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                    // Send the intent to launch a new activity
                    startActivity(websiteIntent);
                }
            });

            recyclerView.setAdapter(adapter);

        } else {

            mEmptyStateTextView.setText("No News Found");
            mEmptyStateTextView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {

        adapter.clear();
    }
}
