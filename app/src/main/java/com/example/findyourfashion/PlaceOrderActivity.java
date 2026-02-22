package com.example.findyourfashion;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class PlaceOrderActivity extends AppCompatActivity {

    TextView orderSummary, userDetails;
    Button confirmOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Place Order");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        orderSummary = findViewById(R.id.orderSummaryText);
        userDetails = findViewById(R.id.userDetailsText);
        confirmOrderBtn = findViewById(R.id.confirmOrderBtn);

        List<Product> cartItems = CartManager.getInstance().getCart();
        StringBuilder productList = new StringBuilder("Products:\n");
        for (Product p : cartItems) {
            productList.append("- ").append(p.getName()).append(" (").append(p.getPrice()).append(")\n");
        }
        orderSummary.setText(productList.toString());

        // Fetching user email & address from SharedPreferences
        SharedPreferences prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String email = prefs.getString("email", "not set");
        String address = prefs.getString("address", "not set");

        userDetails.setText("Deliver To:\n" + address + "\n\nContact: " + email);

        confirmOrderBtn.setOnClickListener(v -> {
            Toast.makeText(this, "Order Placed 😁!!! Just Joking!!!", Toast.LENGTH_LONG).show();
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
