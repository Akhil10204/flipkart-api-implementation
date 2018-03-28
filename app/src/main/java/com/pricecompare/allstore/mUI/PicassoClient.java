package com.pricecompare.allstore.mUI;

import android.content.Context;
import android.widget.ImageView;

import com.pricecompare.allstore.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Acer on 26-08-2017.
 */

public class PicassoClient {


        public static void downloadimage(Context ctx, String imageurl, ImageView img) {


            if(imageurl.length()>0 ){

                Picasso.with(ctx).load(imageurl).into(img);

            }
            else if (imageurl==null){

                Picasso.with(ctx).load(R.drawable.close_icon).into(img);

            }
            else
            {
                Picasso.with(ctx).load(R.drawable.p7).into(img);
            }



        }
}
