package com.example.nuts.adapter;


import android.media.Image;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nuts.DummyContent;
import com.example.nuts.R;

import java.util.List;


public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_DEPOSITE = 1;
    private final int VIEW_TYPE_REMOVAL = 2;
    private final int VIEW_TYPE_LOADING = 3;
    private final List<DummyContent.DummyItem> mValues;

    public ChatAdapter(List<DummyContent.DummyItem> mValues) {
        this.mValues = mValues;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        if (i == 0) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product, null);
            return new ProductHolder(v);
        }
        else if (i == VIEW_TYPE_DEPOSITE) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_msg_buyer, null);
            return new ChatHolder(v);
        } else if (i == VIEW_TYPE_REMOVAL) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_msg_seller, null);
            return new ChatHolder(view);
        }

        return null;

    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return 0;
        else if (mValues.get(position) == null)
            return VIEW_TYPE_LOADING;
        else if (position % 2 == 0)
            return VIEW_TYPE_DEPOSITE;
        else
            return VIEW_TYPE_REMOVAL;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int i) {

        LinearLayout.LayoutParams paramsMsg = new LinearLayout.
                LayoutParams(android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
        if (i%2 == 0){
            paramsMsg.gravity = Gravity.START;
        } else {
            paramsMsg.gravity = Gravity.END;
        }


        if(i == 0)
        {
            ProductHolder Holder = (ProductHolder) holder;
        }
        else if (holder instanceof ChatHolder) {
            ChatHolder Holder = (ChatHolder) holder;
            Holder.txtMsg.setText(mValues.get(i).details);
            Holder.txtDate.setText(mValues.get(i).content);
        }
    }

    @Override
    public int getItemCount() {
        return (null != mValues ? mValues.size() : 0);
    }


    public class ChatHolder extends RecyclerView.ViewHolder {
        public TextView txtMsg, txtDate;

        public ChatHolder(View view) {
            super(view);
            this.txtMsg = view.findViewById(R.id.txt_msg);
            this.txtDate = view.findViewById(R.id.txt_date);
        }
    }

    public class ProductHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle,txtPrice, txtAddToBasket;
        public ImageView imgProduct;

        public ProductHolder(View view) {
            super(view);
            this.imgProduct = view.findViewById(R.id.img_product);
            this.txtTitle = view.findViewById(R.id.txt_title);
            this.txtPrice = view.findViewById(R.id.txt_price);
            this.txtAddToBasket = view.findViewById(R.id.txt_add_to_basket);
        }
    }

}