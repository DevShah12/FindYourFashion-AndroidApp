package com.example.findyourfashion;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findyourfashion.ProductAdapter;
import com.example.findyourfashion.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WishlistActivity extends AppCompatActivity {

    RecyclerView wishlistRecycler;
    ProductAdapter adapter;
    List<Product> wishlistProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        Toolbar toolbar = findViewById(R.id.wishlistToolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        wishlistRecycler = findViewById(R.id.wishlistRecycler);
        wishlistRecycler.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);
        Set<String> wishlist = prefs.getStringSet("wishlist_items", new HashSet<>());

        wishlistProducts = new ArrayList<>();

        for (String name : wishlist) {
            List<Product> allProducts = ProductData.getAllProducts();
            for (Product p : allProducts) {
                if (p.getName().equalsIgnoreCase(name)) {
                    wishlistProducts.add(p);
                    break;
                }
            }
        }

        if (wishlistProducts.isEmpty()) {
            Toast.makeText(this, "Your wishlist is empty!", Toast.LENGTH_SHORT).show();
        }

        adapter = new ProductAdapter(this, new ArrayList<>(wishlistProducts));
        wishlistRecycler.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
