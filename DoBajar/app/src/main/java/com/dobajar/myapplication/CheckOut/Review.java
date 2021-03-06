package com.dobajar.myapplication.CheckOut;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dobajar.myapplication.R;

public class Review extends AppCompatActivity {
    private Button deliveryConfirm;
    private TextView txtReviewName, txtReviewPhone, txtReviewAddress;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        deliveryConfirm= findViewById(R.id.btn_delivery_confirm);
        txtReviewName= findViewById(R.id.txt_review_delivery_name);
        txtReviewPhone= findViewById(R.id.txt_review_delivery_phone);
        txtReviewAddress= findViewById(R.id.txt_review_delivery_address);

        SharedPreferences receiveProductDetailsData = getSharedPreferences("STORE_DELIVERY_ADDRESS_DATA", Context.MODE_PRIVATE);
        txtReviewName.setText(receiveProductDetailsData.getString("_delivery_address_name","default"));
        txtReviewPhone.setText(receiveProductDetailsData.getString("_delivery_address_phone","default"));
        txtReviewAddress.setText(receiveProductDetailsData.getString("_delivery_address","default"));

        deliveryConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Review.this, Checkout.class));
            }
        });
    }
}
