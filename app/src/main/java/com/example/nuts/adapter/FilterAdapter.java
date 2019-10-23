package com.example.nuts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nuts.DummyContent;
import com.example.nuts.R;

import java.util.List;


public class FilterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final List<DummyContent.DummyItem> mValues;


    public FilterAdapter(List<DummyContent.DummyItem> items) {
        mValues = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category, null);
        return new CategoryHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int i) {

        if (holder instanceof CategoryHolder) {
            ((CategoryHolder) holder).mItem = mValues.get(i);
            ((CategoryHolder) holder).bindTo(((CategoryHolder) holder).mItem);
        }
    }

    @Override
    public int getItemCount() {
        try {
            return mValues.size();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public DummyContent.DummyItem mItem;

        public TextView txtTitlle;
        public ImageView img;

        public CategoryHolder(View view) {
            super(view);
            mView = view;

            this.txtTitlle = view.findViewById(R.id.txt_title);
            this.img = view.findViewById(R.id.img_category);
        }

        void bindTo(DummyContent.DummyItem dummyItem) {
            txtTitlle.setText(dummyItem.content);
//
        }

    }
}