package com.example.android.githubreposearch;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.githubreposearch.utilities.NetworkUtils;

import java.net.URL;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    EditText mSearchBoxEditText;
    TextView mUrlDisplayTextView;
    TextView mSearchResultsTextView;
    TextView mErrorDisplayMessage;
    ProgressBar mLoadingIndicator;

    private static final String SEARCH_QUERY_URL_EXTRA = "query";

    private static final String SEARCH_RESULTS_RAW_JSON = "results";

    private static final int GITHUB_SEARCH_LOADER = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchBoxEditText = (EditText) findViewById(R.id.et_search_box);
        mUrlDisplayTextView = (TextView) findViewById(R.id.tv_url_display);
        mSearchResultsTextView = (TextView) findViewById(R.id.tv_github_search_results_json);

        mErrorDisplayMessage = findViewById(R.id.tv_error_message_display);
        mLoadingIndicator = findViewById(R.id.pb_loading_indicator);

        if(savedInstanceState!=null){

            //savedInstanceState value is not null when the activity is being recreated.
            String queryUrl = savedInstanceState.getString(SEARCH_QUERY_URL_EXTRA);
            mUrlDisplayTextView.setText(queryUrl);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String queryUrl = mUrlDisplayTextView.getText().toString();
        outState.putString(SEARCH_QUERY_URL_EXTRA,queryUrl);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;//true is returned to display the menu
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_search) {
            makeGithubSearchQuery();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void makeGithubSearchQuery() {
        String githubQuery = mSearchBoxEditText.getText().toString();
        URL githubSearchUrl = NetworkUtils.buildUrl(githubQuery);
        mUrlDisplayTextView.setText(githubSearchUrl.toString());

        Bundle queryBundle = new Bundle();
        //Loaders take Android Bundle as an argument.
        queryBundle.putString(SEARCH_QUERY_URL_EXTRA,githubSearchUrl.toString());

        LoaderManager loaderManager = getSupportLoaderManager();
        Loader<String> githubSearchLoader = loaderManager.getLoader(GITHUB_SEARCH_LOADER);

        if(githubSearchLoader==null){
            loaderManager.initLoader(GITHUB_SEARCH_LOADER,queryBundle,this);
        } else {
            loaderManager.restartLoader(GITHUB_SEARCH_LOADER,queryBundle,this);
        }

    }


    @Override
    public Loader<String> onCreateLoader(int id, final Bundle args) {
        //we set the Bundle argument as final so that we can access the variable from inner class.
        return new AsyncTaskLoader<String>(this)
        {
            String mGithubJson;

            @Override
            protected void onStartLoading() {
                super.onStartLoading();
                if (args == null){
                    return;
                }
                mLoadingIndicator.setVisibility(View.VISIBLE);

                if (mGithubJson!=null){
                    deliverResult(mGithubJson);
                } else {
                    forceLoad();
                }
            }

            @Override
            public String loadInBackground() {

                String searchQueryUrlString = args.getString(SEARCH_QUERY_URL_EXTRA);
                if (searchQueryUrlString == null || TextUtils.isEmpty(searchQueryUrlString)) {
                    return null;
                }

                try {
                    URL githubUrl = new URL(searchQueryUrlString);//creating a new URL from our string
                    return NetworkUtils.getResponseFromHttpUrl(githubUrl);

                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            public void deliverResult(String githubJson) {
                mGithubJson=githubJson;
                super.deliverResult(githubJson);
            }
        };
    }

    @Override
    public void onLoadFinished( Loader<String> loader, String data) {
        if (data != null && !data.equals("")) {
            showJsonDataView();
            mSearchResultsTextView.setText(data);
        }else{
            showErrorMessage();
        }
        mLoadingIndicator.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onLoaderReset( Loader<String> loader) {

    }

    public class GithubQueryTask extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(URL... urls) {

            URL searchUrl = urls[0];
            String githubSearchResults = null;

            try {
                githubSearchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return githubSearchResults;
        }

        @Override
        protected void onPostExecute(String s) {

            if (s != null && !s.equals("")) {
                showJsonDataView();
                mSearchResultsTextView.setText(s);
            }else{
                showErrorMessage();
            }
            mLoadingIndicator.setVisibility(View.INVISIBLE);
        }
    }

    private void showJsonDataView()
    {
        mErrorDisplayMessage.setVisibility(View.INVISIBLE);
        mSearchResultsTextView.setVisibility(View.VISIBLE);
    }

    public void showErrorMessage(){
        mErrorDisplayMessage.setVisibility(View.VISIBLE);
        mSearchResultsTextView.setVisibility(View.INVISIBLE);
    }
}
