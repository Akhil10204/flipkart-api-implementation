package com.pricecompare.allstore.m_TopTen_Api; /***
 * The main class to execute.
 * Please refer to the instructions.txt
 *
 * @author vijay.v@flipkart.com
 * @version 1.0
 * Copyright (c) Flipkart India Pvt. Ltd.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.pricecompare.allstore.mUI.TopListAdapter;

import java.util.Iterator;
import java.util.List;

public class APIFeeds extends AsyncTask<String, String, Void> {

    private DataParser parser;
    Context ctx;
    ListView lv;
    public ProgressDialog pd;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(ctx);
        pd.setCancelable(true);
        pd.setTitle("Loading...");
        pd.setMessage("please wait");
        pd.show();

    }

    public APIFeeds(String affiliateId, String affiliateToken, String downloadType) {
        if(downloadType.equals("XML")) {
//            parser = new XMLDataParser(affiliateId, affiliateToken);
            System.out.println("Usage: APIFeeds <Affiliate ID> <Affiliate Token> <JSON>");

        }
        else {
            parser = new JSONDataParser(affiliateId, affiliateToken);
        }
    }

    public DataParser getParser() {
        return parser;
    }

    public void setContext(Context ctx, ListView lv){
        this.ctx=ctx;
        this.lv=lv;
    }

    public static void main(String args[]) {

        /**
         * Usage: APIFeeds <AffiliateID> <AffiliateToken> <XML/JSON>
         */

    }
    public List<ProductInfo> plist;
    @Override
    protected Void doInBackground(String... params) {
        Log.d("LOGTAG","It comes here");
        if(params.length < 3) {
            System.out.println(); System.out.println();
            System.out.println("Usage: APIFeeds <Affiliate ID> <Affiliate Token> <JSON>");
            System.out.println(); System.out.println();

        }

        try {
            if (params[2].equals("XML")) {
                //            parser = new XMLDataParser(affiliateId, affiliateToken);
                System.out.println("Usage: APIFeeds <Affiliate ID> <Affiliate Token> <JSON>");

            }
            APIFeeds feeds = new APIFeeds(params[0], params[1], params[2]);

            // Query the API service to get the list of categories and the corresponding URLs and store it
            // locally in productDirectory Map.
            if(feeds.getParser().initializeProductDirectory()) {

                Log.d("LOGTAG","Choose one of the categories:");
                // Get the list of categories from the locally stored productDirectory Map.
                Iterator<String> category_iterator = feeds.getParser().getProductDirectory().keySet().iterator();

                while(category_iterator.hasNext()) { Log.d("LOGTAG",category_iterator.next()); }
                Log.d("Urls::::",feeds.getParser().getProductDirectory().toString());
                Log.d("LOGTAG","Enter a category (or type 'q' to quit): ");
                //Scanner s = new Scanner(System.in);
                String category = params[3];
                plist=feeds.getParser().getProductList(category);
               // for (Map.Entry<String, String> outer : feeds.getParser().getProductDirectory().entrySet()) {
                    //category = outer.getKey();
                    if (category.equalsIgnoreCase("q")) {
                    }

                    if (!feeds.getParser().getProductDirectory().keySet().contains(category)) {
                        System.out.print("Enter a valid category (or type 'q' to quit): ");
                    }
                    //int count = 0;
                    // Get a list of products for the given category.
                    /*Iterator<ProductInfo> products_iterator = feeds.getParser().getProductList(category).listIterator();
                    while (products_iterator.hasNext()) {
                        ProductInfo product = products_iterator.next();
                        if (product.isInStock()) {
                            // Some of the fields are printed.

                            System.out.println("Title: " + product.getTitle());
                            System.out.println("URL: " + product.getProductUrl());
                            System.out.println("Price: " + product.getMrp() + "\n\n");
                            count++;
                        }
                    }*/

                    //System.out.println("Found " + count + " products in " + category + " category.\n\n");
                }
            //}
            else {
                System.out.println("Unable to contact the Flipkart Affiliate API service.");
            }
        }
        catch(AffiliateAPIException e) {
            System.out.println("API Exception raised: " + e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if(pd.isShowing()){
            Log.d("LOGTAG","Yes PD was Showing");
            pd.dismiss();
        }
        if(!isCancelled()){
            TopListAdapter adapter=new TopListAdapter(ctx,plist);
            lv.setAdapter(adapter);
        }
        super.onPostExecute(aVoid);
    }
}

