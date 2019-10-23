package com.example.nuts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nuts.DummyContent;
import com.example.nuts.R;

import java.util.List;


public class FilterCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_ITEM = 1;
    private List<DummyContent.DummyItem> feedItemList;
    // private Context mContext;
    //private int position;

    public FilterCategoryAdapter(/*Context context, */List<DummyContent.DummyItem> feedItemList/*, int pos*/) {
        this.feedItemList = feedItemList;
        //this.mContext = context;
        //position = pos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category, null);
        return new CategoryHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE_ITEM;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int i) {

       /* position = i;
        for (int j = 0; j < feedItemList.get(i).getSecLevelChildIds().split(",").length; j++) {

        }*/

        if (holder instanceof CategoryHolder) {
            final CategoryHolder Holder = (CategoryHolder) holder;
            Holder.setIsRecyclable(false);
            Holder.category.setText(feedItemList.get(i).content);
            //Holder.txtTitle.setText(feedItemList.get(i).getSecLevelChildNames().split(",")[j]);
            //imageLoader.displayImage(feedItemList.get(i).getSecLevelChildImages().split(",")[j], Holder.pic, options);
            //startAct((CategoryHolder) holder, i, j) ;
            /*for (int j = feedItemList.get(position).getSecLevelChildIds().split(",").length - 1; j >= 0; j--) {
                String id = feedItemList.get(position).getSecLevelChildIds().split(",")[j];
                String title = feedItemList.get(position).getSecLevelChildNames().split(",")[j];
                String picUrl = BuildConfig.BASEURL + feedItemList.get(position).getSecLevelChildImages().split(",")[j];

                SubCategoryAmazing product = new SubCategoryAmazing(mContext);
                product.id = id;
                product.title.setText(title);
                product.TitleLevel = title;
                //imageLoader.displayImage(picUrl, product.pic, options);
                Holder.category.addView(product);
            }*/
        }
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    /*public void addItem(ParentModel post) {
        this.feedItemList.add(post);
        notifyItemInserted(this.feedItemList.size() - 1);
    }*/

    public class CategoryHolder extends RecyclerView.ViewHolder {
        //public ImageView pic;
        //public TextView txtTitle;
        public TextView category;

        public CategoryHolder(View view) {
            super(view);
            //this.pic = view.findViewById(R.id.rowChildCategories_icon);
            //this.txtTitle = view.findViewById(R.id.rowChildCategories_title);
            this.category = view.findViewById(R.id.txt_title);
        }
    }
}