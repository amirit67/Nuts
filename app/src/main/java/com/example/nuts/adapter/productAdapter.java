package com.example.nuts.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nuts.DummyContent;
import com.example.nuts.R;
import com.example.nuts.utils.roundedimageview.RoundedImageView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


public class productAdapter extends RecyclerView.Adapter<productAdapter.ViewHolder> {

    private final List<DummyContent.DummyItem> mValues;


    public productAdapter(List<DummyContent.DummyItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_top_sale, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.bindTo(holder.mItem);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public DummyContent.DummyItem mItem;
        RoundedImageView imgProduct;
        TextView txtTitle;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            imgProduct = view.findViewById(R.id.img_product);
            txtTitle = view.findViewById(R.id.txt_title);
        }

        void bindTo(DummyContent.DummyItem dummyItem) {
            txtTitle.setText(dummyItem.content);
//
        }


//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
    }
}