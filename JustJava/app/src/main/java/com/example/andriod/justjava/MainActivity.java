package com.example.andriod.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}

int coffee=1;
boolean hasWhippedCream=false;
    boolean hasChocolate=false;

public void increment(View view)
{
    if(coffee==100) {
     // Show an error message as a Toast
        Toast.makeText(this,"You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
        //Exit the method early because there is nothing to do
        return;
    }
    coffee++;
    displayQuantity(coffee);
}

public void decrement(View view)
{
    if(coffee==1){
        // Show an error message as a Toast
        Toast.makeText(this,"You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
        //Exit the method early because there is nothing to do
        return;
    }
    coffee--;
    displayQuantity(coffee);
}
    /**
     * This method is called when the order button
     * is clicked.
     */
public void submitOrder(View view)
{
    CheckBox whippedCreamCheckbox=(CheckBox)findViewById(R.id.whipped_cream_checkbox);
    hasWhippedCream=whippedCreamCheckbox.isChecked();
    CheckBox chocolateCheckbox=(CheckBox)findViewById(R.id.chocolate_checkbox);
    hasChocolate=chocolateCheckbox.isChecked();
    EditText text=(EditText)findViewById(R.id.name);
    String value=text.getText().toString();
    int price= calculatePrice();
    String message=createOrderSummary(price,hasWhippedCream,hasChocolate,value);

    Intent intent = new Intent(Intent.ACTION_SENDTO);
    intent.setData(Uri.parse("mailto:")); // only email apps should handle this
    intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + value);
    intent.putExtra(Intent.EXTRA_TEXT, message);
    if (intent.resolveActivity(getPackageManager()) != null)
        startActivity(intent);
    displayMessage(message);

}
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
/**
 * This method displays the given quantity value on the screen.
 */
private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
        R.id.quantity_text_view);
        quantityTextView.setText("" + number);
        }
    /**
     * Calculates the price of the order.
     * @return returns price of the coffee.
     */
    private int calculatePrice() {
        int rate=5;
        if(hasWhippedCream)
            rate+=1;
        if(hasChocolate)
            rate+=2;
        return (coffee * rate);
    }

    /**
     * Creates the summary of the order
     * @param rate to take the price from the submitOrder method
     * @return the txt summary
     */

    private String createOrderSummary(int rate,boolean whipped, boolean chocolate,String name)
    {
        String priceMessage="";
            priceMessage="Name : "+name;
            if(whipped)
                priceMessage+="\nWhipped Cream Added\n";
            if(chocolate)
                priceMessage+="Chocolate Added\n";
            priceMessage+="Quantity : "+coffee;
            priceMessage+="\nTotal : $"+rate;
            priceMessage=priceMessage+"\nThank You!";
        return priceMessage;
    }
}
