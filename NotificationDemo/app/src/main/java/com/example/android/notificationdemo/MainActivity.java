package com.example.android.notificationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //when you display a notification, you need some components like you need icon for the
    // notification, you need a title for the notification and you need some content text for
    // the notification. these are the essential components of a notification and all others
    // settings and actions of the notification are optional, but you have to use atleast one
    // action with a notification.
    public void showNotification(View view){

        //by using this object you can set paramaters of the notification that you want to create
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        //setting the icon of the notification
        builder.setSmallIcon(R.drawable.ic_launcher_background);

        //setting the title of the notification
        builder.setContentTitle("My Notification");

        //setting the content text
        builder.setContentText("This is my first notification...");

        //whenever we click on the notification then the next activity should open so we create an object of intent
        Intent intent = new Intent(this,Second.class);

        //the main purpose of stack buider is, the stack buider object has an artificial back
        // stack mechanism. this will ensure that navigating back from your activity lead your
        // activity to exit to the home screen
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Second.class);//adding backstack for the intent
        stackBuilder.addNextIntent(intent);//adding the next intent which will be called on clicking the notification
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        //now we need to issue the notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());
    }
}
