package com.dobajar.myapplication.CheckOut;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dobajar.myapplication.Paypal.Payment;
import com.dobajar.myapplication.R;

public class PaymentSelect extends AppCompatActivity {
    private Button paymentConfirm;
    private LinearLayout cashOn, masterCard, visaCard, paypalCard, duchBangla, bkash;
    private int paymentSetColor=0;
    private CardView cardView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymen);

        paymentConfirm= findViewById(R.id.payment_confirm);
        cashOn= findViewById(R.id.cash_on);
        masterCard= findViewById(R.id.master_card);
        visaCard= findViewById(R.id.visa_card);
        paypalCard= findViewById(R.id.paypal_card);
        duchBangla= findViewById(R.id.duch_bangla);
        bkash= findViewById(R.id.bkash);
        cardView= findViewById(R.id.cardCashon);

        cashOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setCardBackgroundColor(getResources().getColor(R.color.low_black));
                //cashOn.setBackgroundColor(getResources().getColor(R.color.low_black));
                paymentSetColor=1;
            }
        });

        masterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                masterCard.setBackgroundColor(getResources().getColor(R.color.low_black));
                paymentSetColor=1;
            }
        });

        visaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visaCard.setBackgroundColor(getResources().getColor(R.color.low_black));
                paymentSetColor=1;
            }
        });

        paypalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paypalCard.setBackgroundColor(getResources().getColor(R.color.low_black));
                paymentSetColor=1;
            }
        });

        duchBangla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duchBangla.setBackgroundColor(getResources().getColor(R.color.low_black));
                paymentSetColor=1;
            }
        });

        bkash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bkash.setBackgroundColor(getResources().getColor(R.color.low_black));
                paymentSetColor=1;
            }
        });

        paymentConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paymentSetColor=0;
                startActivity(new Intent(PaymentSelect.this, Review.class));
            }
        });
    }
}
