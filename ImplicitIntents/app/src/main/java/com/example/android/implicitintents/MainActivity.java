package com.example.android.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickOpenWebpageButton(View view)
    {
        String urlAsString = "https:www.udacity.com";
        openWebPage(urlAsString);
    }

    public void onClickOpenAddressButton(View view)
    {
        String addressString = "1600 Amphitheatre Parkway, CA";

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("geo").path("0,0")
                .query(addressString);

        Uri addressUri = builder.build();

        showMap(addressUri);
    }

    public void onClickShareTextButton(View view)
    {
        String textThatYouWantToShare = "Sharing the coolest thing I've learned so far. You should " +
                "check out Udacity and Google's Android Nanodegree!";

        shareText(textThatYouWantToShare);
    }

    public void createYourOwn(View v) {
        Toast.makeText(this,
                "TODO: Create Your Own Implicit Intent",
                Toast.LENGTH_SHORT)
                .show();
    }

    private void openWebPage(String url)
    {
        Uri webPage=Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,webPage);
        //Intent.ACTION_VIEW tells the Android System that we want to view content.

        if (intent.resolveActivity(getPackageManager())!=null)
        {
            //this if condition here asks the Android System if there's an app that can handle our request.
            //if we didn't include this check, the request would probably work with most users, but would
            // crash if a device doesn't have an app installed that can handle our request.
            startActivity(intent);
        }
    }

    private void showMap(Uri geoLocation){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

    private void shareText(String textToShare){

        /*
         * You can think of MIME types similarly to file extensions. They aren't the exact same,
         * but MIME types help a computer determine which applications can open which content. For
         * example, if you double click on a .pdf file, you will be presented with a list of
         * programs that can open PDFs. Specifying the MIME type as text/plain has a similar affect
         * on our implicit Intent. With text/plain specified, all apps that can handle text content
         * in some way will be offered when we call startActivity on this particular Intent.
         */
        String mimeType = "text/plain";

        /* This is just the title of the window that will pop up when we call startActivity */
        String title = "Learning How to Share";

        ShareCompat.IntentBuilder
                /* The from method specifies the Context from which this share is coming from */
                .from(this)
                .setType(mimeType)
                .setChooserTitle(title)
                .setText(textToShare)
                .startChooser();
    }
}
