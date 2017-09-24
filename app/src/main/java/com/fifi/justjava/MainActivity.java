package com.fifi.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
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

    int quantity = 2;
    int price = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage = "应付金额：" + quantity + "美元";
        priceMessage += " " + quantity + "杯咖啡是" + price * quantity + "美元";
        priceMessage += "\n Thanks very much!";
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        int price = 5;
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number * price));
    }

    public void increment(View view) {
        quantity += 1;

        displayQuantity(quantity);
    }

    public void decrement(View view) {

        if(quantity==0)
            return;

        quantity -= 1;

        displayQuantity(quantity);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}
