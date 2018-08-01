package com.example.android.githubreposearch.utilities;

import android.net.Uri;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class NetworkUtils {

    final static String GITHUB_BASE_URL =
            "https://api.github.com/search/repositories";

    final static String PARAM_QUERY = "q";


    final static String PARAM_SORT = "sort";
    final static String sortBy = "stars";

    public static URL buildUrl(String githubSearchQuery)
    {
        //building the Uri which using the search query which returns an Android Uri
        Uri builtUri=Uri.parse(GITHUB_BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERY, githubSearchQuery)
                .appendQueryParameter(PARAM_SORT, sortBy).
                        build();

        //the Android Uri is converted into the URl
        URL url=null;
        try {
            url=new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url)throws Exception {

        HttpsURLConnection urlConnection= (HttpsURLConnection) url.openConnection();

        try {
            InputStream in=urlConnection.getInputStream();//InputStream is used to read the input from the connection

            Scanner scanner=new Scanner(in);
            scanner.useDelimiter("\\A");
            //by setting the delimiter to '\A', beginning of the stream, we force the scanner to
            // read the entire contents of the stream into the next token stream

            boolean hasInput=scanner.hasNext();
            if (hasInput){
                return scanner.next();
            }else{
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }

    }

}
