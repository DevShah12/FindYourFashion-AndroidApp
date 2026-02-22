package com.example.findyourfashion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder> {

    private final Context context;
    private final String[] categoryNames;
    private final int[] categoryImages;
    private final OnCategoryClickListener listener;

    public interface OnCategoryClickListener {
        void onCategoryClick(String categoryName);
    }

    public CategoryRecyclerAdapter(Context context, String[] categoryNames, int[] categoryImages, OnCategoryClickListener listener) {
        this.context = context;
        this.categoryNames = categoryNames;
        this.categoryImages = categoryImages;
        this.listener = listener;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_card_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.categoryName.setText(categoryNames[position]);
        holder.categoryImage.setImageResource(categoryImages[position]);

        holder.itemView.setOnClickListener(v -> listener.onCategoryClick(categoryNames[position]));
    }

    @Override
    public int getItemCount() {
        return categoryNames.length;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImage;
        TextView categoryName;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.categoryImage);
            categoryName = itemView.findViewById(R.id.categoryName);
        }
    }
}
