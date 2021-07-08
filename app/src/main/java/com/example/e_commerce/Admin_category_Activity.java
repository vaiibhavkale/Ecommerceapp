package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Admin_category_Activity extends AppCompatActivity {

    private ImageView tshirts, sportsTshirts, femaledresses, sweat_shirts;
    private ImageView glasses, hats_caps, wallet_bags_purses, shoes;
    private ImageView headphones, Laptops, watches, mobilePhones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        tshirts = (ImageView) findViewById(R.id.t_shirts);
        sportsTshirts = (ImageView) findViewById(R.id.sports_t_shirts);
        femaledresses = (ImageView) findViewById(R.id.female_dresses);
        sweat_shirts = (ImageView) findViewById(R.id.sweat_shirts);

        glasses = (ImageView) findViewById(R.id.glasses);
        hats_caps = (ImageView) findViewById(R.id.hats_caps);
        wallet_bags_purses = (ImageView) findViewById(R.id.purses_bags_wallets);
        shoes = (ImageView) findViewById(R.id.shoes);

        headphones = (ImageView) findViewById(R.id.headphones_handfree);
        Laptops = (ImageView) findViewById(R.id.laptop_pc);
        watches = (ImageView) findViewById(R.id.watches);
        mobilePhones = (ImageView) findViewById(R.id.mobilephones);

        tshirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_category_Activity.this, AdminPanel_addnewproduct_Activity.class);
                intent.putExtra("category", "tShirts");
                startActivity(intent);
            }
        });
        sportsTshirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_category_Activity.this, AdminPanel_addnewproduct_Activity.class);
                intent.putExtra("category", "Sports Tshirts");
                startActivity(intent);
            }
        });
        femaledresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_category_Activity.this, AdminPanel_addnewproduct_Activity.class);
                intent.putExtra("category", "Female Dresses");
                startActivity(intent);
            }
        });
        sweat_shirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_category_Activity.this, AdminPanel_addnewproduct_Activity.class);
                intent.putExtra("category", "Sweat_shirts");
                startActivity(intent);
            }
        });
        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_category_Activity.this, AdminPanel_addnewproduct_Activity.class);
                intent.putExtra("category", "Glasses");
                startActivity(intent);
            }
        });
        hats_caps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_category_Activity.this, AdminPanel_addnewproduct_Activity.class);
                intent.putExtra("category", "Hats Caps");
                startActivity(intent);
            }
        });

        wallet_bags_purses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_category_Activity.this, AdminPanel_addnewproduct_Activity.class);
                intent.putExtra("category", "Wallets Bags and Purses");
                startActivity(intent);
            }
        });
        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_category_Activity.this, AdminPanel_addnewproduct_Activity.class);
                intent.putExtra("category", "Shoes");
                startActivity(intent);
            }
        });
        headphones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_category_Activity.this, AdminPanel_addnewproduct_Activity.class);
                intent.putExtra("category", "Headphones");
                startActivity(intent);
            }
        });
        Laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_category_Activity.this, AdminPanel_addnewproduct_Activity.class);
                intent.putExtra("category", "Laptops");
                startActivity(intent);
            }
        });
        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_category_Activity.this, AdminPanel_addnewproduct_Activity.class);
                intent.putExtra("category", "Watches");
                startActivity(intent);
            }
        });
        mobilePhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_category_Activity.this, AdminPanel_addnewproduct_Activity.class);
                intent.putExtra("category", "MobilePhones");
                startActivity(intent);
            }
        });

    }
}




















