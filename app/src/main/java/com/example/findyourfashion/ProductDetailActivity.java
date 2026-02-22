package com.example.findyourfashion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.HashSet;
import java.util.Set;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView detailProductImage, wishlistIcon;
    TextView detailProductName, detailProductPrice, detailProductDesc;
    Button addToCartButton, buyNowButton;

    private boolean isWishlisted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Product Detail");
        }

        detailProductImage = findViewById(R.id.detailProductImage);
        detailProductName = findViewById(R.id.detailProductName);
        detailProductPrice = findViewById(R.id.detailProductPrice);
        detailProductDesc = findViewById(R.id.detailProductDesc);
        addToCartButton = findViewById(R.id.addToCartButton);
        buyNowButton = findViewById(R.id.buyNowButton);
        wishlistIcon = findViewById(R.id.wishlistIcon);

        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        int imageResId = getIntent().getIntExtra("image", R.drawable.placeholder);
        String desc = "This " + name + " is crafted with care and style. Comfortable, durable, and on trend.";

        detailProductName.setText(name);
        detailProductPrice.setText(price);
        detailProductImage.setImageResource(imageResId);
        detailProductDesc.setText(desc);

        addToCartButton.setOnClickListener(v -> {
            Product product = new Product(name, imageResId, price, desc);
            CartManager.getInstance().addToCart(product);
            Toast.makeText(this, name + " added to cart!", Toast.LENGTH_SHORT).show();
        });

        buyNowButton.setOnClickListener(v -> {
            CartManager.getInstance().clearCart();

            Product product = new Product(name, imageResId, price, desc);
            CartManager.getInstance().addToCart(product);

            Intent intent = new Intent(ProductDetailActivity.this, PlaceOrderActivity.class);
            startActivity(intent);
        });


        wishlistIcon.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);
            Set<String> wishlist = prefs.getStringSet("wishlist_items", new HashSet<>());
            Set<String> updatedWishlist = new HashSet<>(wishlist);

            if (updatedWishlist.contains(name)) {
                updatedWishlist.remove(name);
                wishlistIcon.setImageResource(R.drawable.ic_heart_outline);
                Toast.makeText(this, "Removed from wishlist", Toast.LENGTH_SHORT).show();
                isWishlisted = false;
            } else {
                updatedWishlist.add(name);
                wishlistIcon.setImageResource(R.drawable.ic_heart_filled);
                Toast.makeText(this, "Added to wishlist", Toast.LENGTH_SHORT).show();
                isWishlisted = true;
            }

            prefs.edit().putStringSet("wishlist_items", updatedWishlist).apply();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        } else if (id == R.id.action_cart) {
            startActivity(new Intent(this, CartActivity.class));
            return true;
        } else if (id == R.id.action_wishlist) {
            startActivity(new Intent(this, WishlistActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
