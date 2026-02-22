package com.example.findyourfashion;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.findyourfashion.Product;
import com.example.findyourfashion.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final Context context;
    private final ArrayList<Product> cartItems;
    private final OnRemoveClickListener removeClickListener;

    public interface OnRemoveClickListener {
        void onRemove(int position);
    }

    public CartAdapter(Context context, ArrayList<Product> cartItems, OnRemoveClickListener listener) {
        this.context = context;
        this.cartItems = cartItems;
        this.removeClickListener = listener;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        Product item = cartItems.get(position);

        holder.name.setText(item.getName());
        holder.price.setText(item.getPrice());
        holder.image.setImageResource(item.getImageResId());

        holder.removeIcon.setOnClickListener(v -> {
            removeClickListener.onRemove(position);
            Toast.makeText(context, item.getName() + " removed from cart", Toast.LENGTH_SHORT).show();
        });
    }


    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView image, removeIcon;
        TextView name, price;

        public CartViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.cart_item_image);
            name = itemView.findViewById(R.id.cart_item_name);
            price = itemView.findViewById(R.id.cart_item_price);
            removeIcon = itemView.findViewById(R.id.cart_item_remove);
        }

    }
}
