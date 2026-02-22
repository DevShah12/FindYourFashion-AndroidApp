package com.example.findyourfashion;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.findyourfashion.Product;
import com.example.findyourfashion.ProductAdapter;

public class CategoryActivity extends AppCompatActivity {

    TextView categoryTitle;
    RecyclerView productRecyclerView;
    ArrayList<Product> products;
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        //  Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // back arrow
            getSupportActionBar().setTitle("Category");
        }

        categoryTitle = findViewById(R.id.categoryTitle);
        productRecyclerView = findViewById(R.id.productRecyclerView);

        String category = getIntent().getStringExtra("category");
        categoryTitle.setText(category);

        products = ProductData.getProductsByCategory(category);

        productRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new ProductAdapter(this, products);
        productRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_detail_menu, menu); // Ensure this menu XML exists
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed(); // handle back arrow
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
