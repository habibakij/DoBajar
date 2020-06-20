package com.dobajar.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dobajar.myapplication.Card.Cart_activity;
import com.dobajar.myapplication.R;

public class SuperShop extends AppCompatActivity {

    private ImageView gotoMeenaShop, gotoShowpnoShop, gotoUnimartShop, gotoAugoraShop, gotoPrinceShop, gotoDailyShop;
    private TextView cartText;
    private MenuItem menuItem;
    private ImageView cardImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_shop);

        FindAllView();


        gotoMeenaShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuperShop.this, AllCategories.class));
            }
        });

        gotoShowpnoShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuperShop.this, AllCategories.class));
            }
        });

        gotoUnimartShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuperShop.this, AllCategories.class));
            }
        });

        gotoAugoraShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuperShop.this, AllCategories.class));
            }
        });

        gotoPrinceShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuperShop.this, AllCategories.class));
            }
        });

        gotoDailyShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuperShop.this, AllCategories.class));
            }
        });
    }

    public void FindAllView(){
        gotoMeenaShop= findViewById(R.id.goto_meenabazar);
        gotoShowpnoShop= findViewById(R.id.goto_showpno);
        gotoUnimartShop= findViewById(R.id.goto_unimart);
        gotoAugoraShop= findViewById(R.id.goto_augora);
        gotoPrinceShop= findViewById(R.id.goto_princebajar);
        gotoDailyShop= findViewById(R.id.goto_dailyshop);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        menuItem= menu.findItem(R.id.add_to_card_toolbar);
        View actionView= menuItem.getActionView();
        if (actionView!= null) {
            cartText= actionView.findViewById(R.id.toolbarText);
            cardImage= actionView.findViewById(R.id.toolberCard);
            cartText.setVisibility(View.GONE);
        }
        cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SuperShop.this, "Card item", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SuperShop.this, Cart_activity.class));
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
