package com.example.nuts.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nuts.DummyContent;
import com.example.nuts.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.ViewHolder> {

    private final List<DummyContent.DummyItem> mValues;


    public categoryAdapter(List<DummyContent.DummyItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.bindTo(holder.mItem);


         /*if(position == 0) {
             ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) holder.itemView.getLayoutParams();
             params.rightMargin = -60;
         }*/
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public DummyContent.DummyItem mItem;
        ImageView imgCategory;
        TextView txtTitle;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            imgCategory = view.findViewById(R.id.img_category);
            txtTitle = view.findViewById(R.id.txt_category);
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