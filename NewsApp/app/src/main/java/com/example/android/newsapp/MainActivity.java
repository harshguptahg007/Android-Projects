package com.example.android.newsapp;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<News>>
{

    private static final String LOG_TAG = MainActivity.class.getName();

    private static String NEWS_URL =
            "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=17a2c3a3efeb4e16b303722db9522c80";
    private static final  String API_KEY = "&apiKey=17a2c3a3efeb4e16b303722db9522c80";

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

        //getting the value of the category from the shared preference
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String chooseCategory = sharedPrefs.getString
                (getString(R.string.settings_choose_category_key),"Top Business News");

        switch(chooseCategory){
            case "Top Business Headlines" :

                NEWS_URL = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=17a2c3a3efeb4e16b303722db9522c80";
                break;

            case "BitCoin" :

                NEWS_URL = "https://newsapi.org/v2/everything?q=bitcoin&sortBy=publishedAt&apiKey=17a2c3a3efeb4e16b303722db9522c80";
                break;

            case "Top Headlines from TechCrunch" :

                NEWS_URL = "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=17a2c3a3efeb4e16b303722db9522c80";
                break;

            case "Topics Related Apple" :

                NEWS_URL = "https://newsapi.org/v2/everything?q=apple&from=2018-08-17&to=2018-08-17&sortBy=popularity&apiKey=17a2c3a3efeb4e16b303722db9522c80";
                break;

            case "Wall Street Journal" :

                NEWS_URL = "https://newsapi.org/v2/everything?domains=wsj.com&apiKey=17a2c3a3efeb4e16b303722db9522c80";
                break;
        }

        Uri baseUri = Uri.parse(NEWS_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        return new NewsLoader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, final List<News> data) {

        progressBar.setVisibility(View.GONE);

        adapter.clear();

        // If there is a valid list of News, then add them to the adapter's
        // data set. This will trigger the RecyclerView to update.
        if (data != null && !data.isEmpty()) {

            adapter = new CustomAdapter(this, data, new CustomItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {

                    News currentNews = data.get(position);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=  item.getItemId();

        if (id==R.id.choose_topic){
            Intent in = new Intent(this,SettingsActivity.class);
            startActivity(in);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
