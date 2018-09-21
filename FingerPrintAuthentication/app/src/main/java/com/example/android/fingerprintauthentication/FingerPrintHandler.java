package com.example.android.fingerprintauthentication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.media.Image;
import android.os.Build;
import android.os.CancellationSignal;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.M)
public class FingerPrintHandler extends FingerprintManager.AuthenticationCallback{

    Context context;

    public FingerPrintHandler(Context ctx){
        this.context=ctx;
    }

    public void startAuth(FingerprintManager fingerprintManager,FingerprintManager.CryptoObject cryptoObject){

        /*
        *  the only use of a CrpytoObject in the case of a Fingerprint Authentication is to know if
        *  a new fingerprint was added since last time the user authenticated via fingerprint.
        */

        CancellationSignal cancellationSignal = new CancellationSignal();

        fingerprintManager.authenticate(cryptoObject,cancellationSignal,0,this,null);

    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        this.update("There was an Auth Error. " + errString,false);
    }

    @Override
    public void onAuthenticationFailed() {
        this.update("Auth Failed",false);
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        this.update("Error : " + helpString,false);
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        this.update("You can now access the app",true);
    }

    private void update(String s, boolean b) {

        TextView paraLabel = (TextView) ((Activity)context).findViewById(R.id.paraLabel);
        ImageView imageView = ((Activity)context).findViewById(R.id.fingerprintImage);

        paraLabel.setText(s);

        if (b==false){
            paraLabel.setTextColor(ContextCompat.getColor(context,R.color.colorAccent));
        } else {
            paraLabel.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
            imageView.setImageResource(R.mipmap.action_done);

        }

    }
}
