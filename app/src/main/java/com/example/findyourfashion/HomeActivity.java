package com.example.findyourfashion;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {

    RecyclerView categoryRecyclerView;
    String[] categories = {"Men", "Women", "Shoes", "Accessories"};

    int[] categoryImages = {
            R.drawable.men,
            R.drawable.women,
            R.drawable.shoes,
            R.drawable.accessories
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("FindYourFashion");

        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);

        CategoryRecyclerAdapter adapter = new CategoryRecyclerAdapter(this, categories, categoryImages, category -> {
            Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
            intent.putExtra("category", category);
            startActivity(intent);
        });

        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_cart) {
            startActivity(new Intent(this, CartActivity.class));
            return true;
        } else if (id == R.id.action_wishlist) {
            startActivity(new Intent(this, WishlistActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
