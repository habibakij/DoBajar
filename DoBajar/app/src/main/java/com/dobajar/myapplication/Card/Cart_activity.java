package com.dobajar.myapplication.Card;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dobajar.myapplication.Adapter.CardAdapter;
import com.dobajar.myapplication.CheckOut.Checkout;
import com.dobajar.myapplication.CheckOut.DeliveryAddress;
import com.dobajar.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Cart_activity extends AppCompatActivity implements CardAdapter.OnItemClickListener {

    private List<Integer> cardImage= new ArrayList<>();
    private List<String> cardPrize= new ArrayList<>();
    private List<String> cardName= new ArrayList<>();

    private List<String> cardQuantity= new ArrayList<>();

    //private BottomNavigationView bottomNavigationView;

    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private TextView next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_activity);
        setTitle("Cart Item's");

        //floatingActionButton= findViewById(R.id.fab_card_product_remove);
        //bottomNavigationView= findViewById(R.id.bottom_navigation);
        recyclerView= findViewById(R.id.card_item_list);
        next= findViewById(R.id.goToCheckOut);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cart_activity.this, DeliveryAddress.class));
            }
        });

        /*bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        switch (menuItem.getItemId()) {
                            case R.id.goToCheckOut:
                                startActivity(new Intent(Cart_activity.this, Checkout.class));
                                break;
                        }
                        return false;
                    }
                });*/

        cardImage.add(R.drawable.cocacola);
        cardImage.add(R.drawable.pepsi);

        cardPrize.add("৳ 30");
        cardPrize.add("৳ 35");

        cardName.add("Coca Colo");
        cardName.add("Pepsi");

        cardQuantity.add("2");
        cardQuantity.add("3");

        cardAdapter= new CardAdapter(this, cardImage,cardQuantity, cardPrize, cardName);
        recyclerView.setAdapter(cardAdapter);
        cardAdapter.setOnItemClickListener(Cart_activity.this);

    }

    @Override
    public void OnItemClick(int position) {
        /*Intent intent= new Intent(this, CardProductDetails.class);
        startActivity(intent);*/
    }
}
