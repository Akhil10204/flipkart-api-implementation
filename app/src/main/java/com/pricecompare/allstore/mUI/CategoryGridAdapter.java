package com.pricecompare.allstore.mUI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pricecompare.allstore.R;
import com.pricecompare.allstore.Single_category;

/**
 * Created by Acer on 03-09-2017.
 */

public class CategoryGridAdapter extends BaseAdapter {
    LayoutInflater inflater;
    String[] category_n;
    String[] categories;
    Context ctx;
    public CategoryGridAdapter(Context ctx,String[] category_name,String[] categories) {
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.categories=categories;
        this.category_n=category_name;
        this.ctx=ctx;
    }

    @Override
    public int getCount() {
        return categories.length;
    }

    @Override
    public Object getItem(int position) {
        return categories[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView=inflater.inflate(R.layout.categorymodel, parent, false);
        }
        TextView category_name= (TextView) convertView.findViewById(R.id.category_name);
        for(int i=0;i<category_name.length();i++){
            final String category = category_n[position];
            category_name.setText(category);


            convertView.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v){

                    openExpanderActivity(categories[position]);


                }
            });
        }
        return convertView;
    }

    private void openExpanderActivity(String category){

        Intent i=new Intent(ctx, Single_category.class);
        i.putExtra("CATEGORY",category);

        ctx.startActivity(i);
    }

}
