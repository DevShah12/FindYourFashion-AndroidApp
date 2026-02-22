package com.example.findyourfashion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryAdapter extends BaseAdapter {

    Context context;
    String[] categoryNames;
    int[] categoryImages;
    LayoutInflater inflater;

    public CategoryAdapter(Context context, String[] names, int[] images) {
        this.context = context;
        this.categoryNames = names;
        this.categoryImages = images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return categoryNames.length;
    }

    @Override
    public Object getItem(int i) {
        return categoryNames[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.category_card_item, null);

        ImageView icon = view.findViewById(R.id.categoryImage);
        TextView name = view.findViewById(R.id.categoryName);

        icon.setImageResource(categoryImages[position]);
        name.setText(categoryNames[position]);

        return view;
    }
}
