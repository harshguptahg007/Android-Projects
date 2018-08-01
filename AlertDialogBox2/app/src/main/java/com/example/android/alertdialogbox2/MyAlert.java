package com.example.android.alertdialogbox2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MyAlert extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("My Dialog");
        builder.setItems(R.array.days, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Item was selected "+which,Toast.LENGTH_SHORT).show();
            }
        });
        //the above line is used to make a list of items in the dialog box
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Negative Button was clicked",Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Positive Button was clicked",Toast.LENGTH_SHORT).show();
            }
        });
        //this negative button and positive button are very special type of buttons that belong to dialog only so they
        // don't respond to View.OnClickListener instead they trigger their events to DialogInterface.OnClickListener
        Dialog dialog=builder.create();

        return dialog;//we are returning the dialog because the system is going to display the dialog after it has been returned.
    }
}
