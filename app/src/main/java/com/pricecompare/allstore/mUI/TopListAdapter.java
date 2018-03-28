package com.pricecompare.allstore.mUI;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pricecompare.allstore.Item_Details;
import com.pricecompare.allstore.R;
import com.pricecompare.allstore.m_TopTen_Api.ProductInfo;

import java.util.List;

/**
 * Created by Acer on 25-08-2017.
 */

public class TopListAdapter extends BaseAdapter {

    Context ctx;
    List<ProductInfo> productInfos;
    LayoutInflater inflater;

    public TopListAdapter(Context ctx, List<ProductInfo> productInfos ){

        this.productInfos=productInfos;
        this.ctx=ctx;
        inflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d("LOGTAG", String.valueOf(productInfos));
    }

    @Override
    public int getCount() {
        return productInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return productInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView=inflater.inflate(R.layout.toptenmodel, parent, false);
        }
            ImageView tt_img= (ImageView) convertView.findViewById(R.id.topten_image);
            TextView tt_rate= (TextView) convertView.findViewById(R.id.topten_rate);
            TextView tt_name= (TextView) convertView.findViewById(R.id.topten_name);
            final ProductInfo productInfo = productInfos.get(position);

            String imurl=productInfo.getImgurl();
            imurl = imurl.replaceAll("\\\\", "");
            Log.d("LOGTAG", "ok we are reciving values here too");
            double sp = productInfo.getSellingPrice();
            PicassoClient.downloadimage(ctx,imurl,tt_img);
            tt_rate.setText(" "+sp);
            tt_name.setText(productInfo.getTitle());
            Log.d("LOGTAG", "ImageUrls: " + imurl + " Offers :" + productInfo.getOffers() + " Title:" + productInfo.getTitle());
        convertView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                openitemdetail(productInfo.getTitle(),productInfo.getSellingPrice(),productInfo.getImgurl(),productInfo.getProductUrl(),productInfo.getDescription());


            }
        });
            return convertView;
    }


    private void openitemdetail(String name,double rate,String imageurl,String url,String description){

        Intent i=new Intent(ctx, Item_Details.class);

        i.putExtra("NAME",name);
        i.putExtra("RATE",rate);
        i.putExtra("IMAGE",imageurl);
        i.putExtra("url",url);
        i.putExtra("DES",description);

        ctx.startActivity(i);
    }
}
