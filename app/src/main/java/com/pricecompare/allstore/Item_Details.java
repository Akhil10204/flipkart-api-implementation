package com.pricecompare.allstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pricecompare.allstore.mUI.PicassoClient;

public class Item_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__details);
        Intent i = this.getIntent();
        String Nam = i.getExtras().getString("NAME");
        double Rat = i.getExtras().getDouble("RATE");
        String Img = i.getExtras().getString("IMAGE");
        String description=i.getExtras().getString("DES");
        Img = Img.replaceAll("\\\\", "");
        final String flipkart=i.getExtras().getString("url");
        TextView name= (TextView) findViewById(R.id.item_name);
        TextView rate= (TextView) findViewById(R.id.item_price);
        TextView desc= (TextView) findViewById(R.id.item_description);
        ImageView im= (ImageView) findViewById(R.id.detail_item_image);
        TextView title_desc= (TextView) findViewById(R.id.title_description);
        PicassoClient.downloadimage(this,Img,im);
        String srate= String.valueOf(Rat);
        name.setText(Nam);
        rate.setText("Rs. "+srate);
        if(description.equals("")){
            desc.setVisibility(View.GONE);
            title_desc.setVisibility(View.GONE);
        }
        else {
            desc.setText(description);
        }
    }
}
