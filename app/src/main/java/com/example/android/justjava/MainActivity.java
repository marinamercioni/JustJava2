package com.example.android.justjava;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void incrementOrder(View view)
    {
        quantity=quantity+1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price=calculatePrice();
        String priceMessage=createOrderSummary(price);
        displayMessage(priceMessage);

    }



    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }


    /**
     * Create summary of the order.
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(int price){
        String priceMessage="Name: Kaptain Kunal";
        priceMessage+= "\nQuanity: " +quantity;
        priceMessage+="\nTotal: $"+ price;
        priceMessage+= "\nThank you!";
        return priceMessage;

    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrementOrder(View view)
    {
        quantity=quantity-1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number){
        TextView orderSummaryTextView=(TextView)findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
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
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}