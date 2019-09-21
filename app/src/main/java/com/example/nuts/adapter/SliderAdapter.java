package com.example.nuts.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nuts.R;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;


public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        viewHolder.textViewDescription.setText("خشکبار عمو آجیلی " + position);

        switch (position) {
            case 0:
                Picasso.get()
                        .load("https://naji-pistachiotrade.com/wp-content/uploads/2019/04/%D9%BE%D8%B3%D8%AA%D9%87-1.jpg")
                        .into(viewHolder.imageViewBackground);
                break;
            case 1:
                Picasso.get()
                        .load("https://faradoon.com/543-large_default/%D8%A2%D8%AC%D9%8A%D9%84-%D9%87%D9%81%D8%AA-%D9%85%D8%BA%D8%B2.jpg")
                        .into(viewHolder.imageViewBackground);
                break;
            case 2:
                Picasso.get()
                        .load("https://naji-pistachiotrade.com/wp-content/uploads/2019/04/%D9%BE%D8%B3%D8%AA%D9%87-1.jpg")
                        .into(viewHolder.imageViewBackground);
                break;
            default:
                Picasso.get()
                        .load("https://faradoon.com/543-large_default/%D8%A2%D8%AC%D9%8A%D9%84-%D9%87%D9%81%D8%AA-%D9%85%D8%BA%D8%B2.jpg")
                        .into(viewHolder.imageViewBackground);
                break;

        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return 4;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }
}