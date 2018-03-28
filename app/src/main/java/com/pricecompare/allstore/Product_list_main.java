package com.pricecompare.allstore;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.pricecompare.allstore.mUI.CategoryGridAdapter;

public class Product_list_main extends AppCompatActivity {
    GridView category_grid;
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_main);
        category_grid= (GridView) findViewById(R.id.shopping_category_grid);
        String[] categories={"air_conditioners", "luggage_travel", "watches", "automotive", "kids_clothing", "food_nutrition", "computer_peripherals", "video_players", "sunglasses", "televisions", "home_furnishing", "furniture", "home_decor_and_festive_needs", "camera_accessories", "toys", "stationery_office_supplies", "home_and_kitchen_needs", "wearable_smart_devices", "laptop_accessories", "computer_components", "kitchen_appliances", "tablets", "cameras", "desktops", "jewellery", "audio_players", "tv_video_accessories", "refrigerator", "womens_footwear", "kids_footwear", "computer_storage", "tablet_accessories", "air_coolers", "sports_fitness", "laptops", "fragrances", "mobile_accessories", "grooming_beauty_wellness", "home_improvement_tools", "household_supplies", "microwave_ovens", "e_learning", "software", "home_appliances", "washing_machine", "home_entertainment", "gaming", "womens_clothing","mobiles", "mens_footwear", "network_components", "mens_clothing", "pet_supplies", "baby_care", "eyewear", "bags_wallets_belts", "music_movies_posters", "landline_phones"};
        String[] category_name={"Air Conditioners", "Luggage Travel", "Watches", "Automotive", "Kids Clothing", "Food Nutrition", "Computer Peripherals", "Video Players", "Sunglasses", "Televisions", "Home Furnishing", "Furniture", "Home Decor", "Camera Accessories", "Toys", "Stationery Office Supplies", "Home & Kitchen", "Wearable Smart Devices", "Laptop Accessories", "Computer Components", "Kitchen Appliances", "Tablets", "Cameras", "Desktops", "Jewellery", "Audio Players", "Tv Video Accessories", "Refrigerator", "Womens Footwear", "Kids Footwear", "Computer Storage", "Tablet Accessories", "Air Coolers", "Sports Fitness", "Laptops", "Fragrances", "Mobile Accessories", "Grooming Beauty Wellness", "Home Improvement", "Household Supplies", "Microwave Ovens", "E-Learning", "Software", "Home Appliances", "Washing Machine", "Home Entertainment", "Gaming", "Womens Clothing","Mobiles", "Mens Footwear", "Network Components", "Mens Clothing", "Pet Supplies", "Baby Care", "Eyewear", "Bags Wallets Belts", "Music Movies Posters", "Landline Phones"};
        CategoryGridAdapter adapter=new CategoryGridAdapter(this,category_name,categories);
        category_grid.setAdapter(adapter);

    }
}
