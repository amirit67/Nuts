package com.example.nuts.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nuts.DummyContent;
import com.example.nuts.R;

import java.util.List;


public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {

    private final int VIEW_TYPE_DEPOSITE = 1;
    private final int VIEW_TYPE_REMOVAL = 2;
    private final int VIEW_TYPE_LOADING = 3;
    private final List<DummyContent.DummyItem> mValues;

    public ChatAdapter(List<DummyContent.DummyItem> mValues) {
        this.mValues = mValues;
    }

    @Override
    public ChatHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {

        if (i == VIEW_TYPE_DEPOSITE) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_msg_buyer, null);
            return new ChatHolder(v);
        }
        else if (i == VIEW_TYPE_REMOVAL) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_msg_seller, null);
            return new ChatHolder(view);
        }

        return null;

    }

    @Override
    public int getItemViewType(int position) {
        if (mValues.get(position) == null)
            return VIEW_TYPE_LOADING;
        else if (position%2 == 0)
            return VIEW_TYPE_DEPOSITE;
        else
            return VIEW_TYPE_REMOVAL;
    }

    @Override
    public void onBindViewHolder(final ChatHolder holder, final int i) {

        if (holder instanceof ChatHolder) {
            holder.txtMsg.setText(mValues.get(i).details);
            holder.txtDate.setText(mValues.get(i).content);
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

}