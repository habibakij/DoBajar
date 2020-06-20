package com.dobajar.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.dobajar.myapplication.Card.Cart_activity;
import com.dobajar.myapplication.R;

public class AllCategories extends AppCompatActivity {

    private ImageButton babarageImgBtn, bakeryImgBtn, dairyImgBtn, producsImgBtn, meatImgBtn, fishImgBtn,
            papergoodsImgBtn, personalcareImgBtn;
    private MenuItem menuItem;
    private TextView cartText;
    private ImageButton cardImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);

        InitialView();

        babarageImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllCategories.this, Babarege.class));
            }
        });

        /*bakeryImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllCategories.this, Bakery.class));
            }
        });

        dairyImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllCategories.this, Dairy.class));
            }
        });

        producsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllCategories.this, Products.class));
            }
        });

        meatImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllCategories.this, Meats.class));
            }
        });

        fishImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllCategories.this, Fish.class));
            }
        });

        papergoodsImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllCategories.this, PaperGoods.class));
            }
        });

        personalcareImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllCategories.this, PersonalCare.class));
            }
        });*/

    }

    public void InitialView(){
        babarageImgBtn= findViewById(R.id.categories_beverages);
        bakeryImgBtn= findViewById(R.id.categories_bakery);
        dairyImgBtn= findViewById(R.id.categories_dairy);
        producsImgBtn= findViewById(R.id.categories_produce);
        meatImgBtn= findViewById(R.id.categories_meat);
        fishImgBtn= findViewById(R.id.categories_fish);
        papergoodsImgBtn= findViewById(R.id.categories_paper_goods);
        personalcareImgBtn= findViewById(R.id.categories_personal_care);
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
                Toast.makeText(AllCategories.this, "Card item", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AllCategories.this, Cart_activity.class));
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
