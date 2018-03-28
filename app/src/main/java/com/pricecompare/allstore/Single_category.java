package com.pricecompare.allstore;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.pricecompare.allstore.m_TopTen_Api.APIFeeds;

import java.util.List;


public class Single_category extends AppCompatActivity {

    APIFeeds feeds;
    AsyncTask<String, String, List> l=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = this.getIntent();
        String category=i.getExtras().getString("CATEGORY");
        ListView lv = (ListView) findViewById(R.id.TopSellingList);
        feeds= new APIFeeds("akhil10204","5b32c771089b41c7a1f14d012403e2d2","JSON");
        feeds.setContext(this,lv);
        feeds.execute("akhil10204","5b32c771089b41c7a1f14d012403e2d2","JSON",category);

    }
}
