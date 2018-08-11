package com.example.android.newsapp;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getName();

    private QueryUtils(){

    }

    public static List<News> fetchNewsData(String requestUrl){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Create URL object
        URL url = createUrl(requestUrl);

        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (Exception e){
            Log.e(LOG_TAG, "Error closing input stream", e);
        }

        // Extract relevant fields from the JSON response and create a News object
        List<News> news = extractFeatureFromJson(jsonResponse);

        //Return the news
        return news;
    }

    private static URL createUrl(String stringUrl){

        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException exception) {
            Log.e(LOG_TAG, "Error with creating URL", exception);
            return null;
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {

        String jsonResponse = "";

        if (url==null){
            return jsonResponse;
        }

        HttpsURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000/*Milliseconds*/);
            urlConnection.setConnectTimeout(15000/*Milliseconds*/);
            urlConnection.connect();

            if (urlConnection.getResponseCode()==200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG,"Error response code : "+urlConnection.getResponseCode());
            }

        } catch (IOException e) {
            Log.e(LOG_TAG,"Problem retrieving the earthquake JSON results.",e);
        } finally {
            if (urlConnection!=null){
                urlConnection.disconnect();
            }

            if (inputStream!=null){
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {

        StringBuilder output = new StringBuilder();
        if (inputStream!=null){

            //first we setup the Input Stream and Buffered Reader
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);

            //then we ask the buffered reader for a line of text
            String line = reader.readLine();
            while (line != null) {
                //while the line isn't null, we'll append that line to the string builder
                // and read another line
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private static List<News> extractFeatureFromJson(String newsJSON){

        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(newsJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding news to
        ArrayList<News> news = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            JSONObject baseJsonObject = new JSONObject(newsJSON);

            JSONArray articlesJsonArray = baseJsonObject.getJSONArray("articles");

            for (int i=0;i<articlesJsonArray.length();i++){
                JSONObject currentNews = articlesJsonArray.getJSONObject(i);

                String title = currentNews.getString("title");
                String description = currentNews.getString("description");
                String url = currentNews.getString("url");
                String urlImage = currentNews.getString("urlToImage");

                News exactNews = new News(title,description,url,urlImage);
                news.add(exactNews);
            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }
        return news;
    }
}
