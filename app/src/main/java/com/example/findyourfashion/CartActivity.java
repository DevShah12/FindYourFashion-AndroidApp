package com.example.findyourfashion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findyourfashion.CartAdapter;
import com.example.findyourfashion.Product;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private ArrayList<Product> cartItems;
    private CartAdapter cartAdapter;
    private TextView subtotalText;
    private Button buyNowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // toolbar
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Your Cart");
        }

        cartItems = CartManager.getInstance().getCart();
        subtotalText = findViewById(R.id.subtotalTextView);
        buyNowButton = findViewById(R.id.buyNowButton);

        RecyclerView recyclerView = findViewById(R.id.cartRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(this, cartItems, this::removeItemFromCart);
        recyclerView.setAdapter(cartAdapter);

        updateSubtotal();

        buyNowButton.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, PlaceOrderActivity.class);
            startActivity(intent);
        });
    }

    private void removeItemFromCart(int position) {
        cartItems.remove(position);
        cartAdapter.notifyItemRemoved(position);
        updateSubtotal();
    }

    private void updateSubtotal() {
        double total = 0;
        for (Product item : cartItems) {
            try {
                String price = item.getPrice().replace("$", "").trim();
                total += Double.parseDouble(price);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        subtotalText.setText("Subtotal: $" + String.format("%.2f", total));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
