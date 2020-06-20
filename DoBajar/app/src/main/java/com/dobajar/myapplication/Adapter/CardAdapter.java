package com.dobajar.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dobajar.myapplication.R;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    //private List<CardItem> cardItemList;

    private Context context;
    private List<Integer> cardImage1;
    private List<String> cardQuantity;
    private List<String> cardPrize1;
    private List<String> cardProductName;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void OnItemClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        mListener = onItemClickListener;
    }

    public CardAdapter(Context context, List<Integer> cardImage1, List<String> cardQuantity, List<String> cardPrize1, List<String> cardProductName) {
        this.context = context;
        this.cardImage1 = cardImage1;
        this.cardQuantity = cardQuantity;
        this.cardPrize1 = cardPrize1;
        this.cardProductName = cardProductName;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_item_smpl, null);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {

        /*CardItem cardItem= cardItemList.get(i);
        Picasso.with(context)
                .load(cardItem.getProductImage())
                .into(cardViewHolder.imageView);
        cardViewHolder.name.setText(cardItem.getProductName());
        cardViewHolder.prize.setText(cardItem.getProductPrize());
        cardViewHolder.quantity.setText(cardItem.getProductNumber());*/

        cardViewHolder.name.setText(cardProductName.get(i));
        cardViewHolder.prize.setText(cardPrize1.get(i));
        cardViewHolder.quantity.setText(cardQuantity.get(i));
        cardViewHolder.imageView.setImageResource(cardImage1.get(i));

        /*cardViewHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return cardQuantity.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        View mView;
        ImageView imageView;
        TextView name, prize, quantity;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            mView= itemView;
            imageView= itemView.findViewById(R.id.card_product_image);
            name= itemView.findViewById(R.id.card_product_name);
            prize= itemView.findViewById(R.id.card_product_prize);
            quantity= itemView.findViewById(R.id.card_product_quantity);
            //fab= itemView.findViewById(R.id.fab_card_product_remove);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener!= null){
                        int position= getAdapterPosition();
                        if (position!= RecyclerView.NO_POSITION){
                            mListener.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
