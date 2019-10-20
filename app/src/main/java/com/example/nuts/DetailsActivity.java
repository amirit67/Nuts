package com.example.nuts;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nuts.adapter.SliderAdapter;
import com.example.nuts.adapter.productAdapter;
import com.example.nuts.utils.ExpandableTextView;
import com.example.nuts.utils.navigation.C1769a;
import com.example.nuts.utils.navigation.C1770b;
import com.example.nuts.utils.reviewratings.BarLabels;
import com.example.nuts.utils.reviewratings.RatingReviews;
import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DetailsActivity extends AppCompatActivity implements C1770b, View.OnClickListener {

    public TextView txtMore, txt_bargain, txt_major_shopping;
    public ExpandableTextView txtDesc;

    public TabLayout tabLayout;
    public LinearLayout csProperties;
    public LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        csProperties = findViewById(R.id.cs_properties);
        tabLayout = findViewById(R.id.tablayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                csProperties.removeAllViews();

                if (tab.getPosition() == 0) {
                    View view = inflater.inflate(R.layout.content_comment_product, null);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    layoutParams.weight = 5f;
                    layoutParams.gravity = Gravity.CENTER_VERTICAL;
                    view.setLayoutParams(layoutParams);
                    csProperties.addView(view);

                    RatingReviews ratingReviews = view.findViewById(R.id.rating_reviews);
                    int colors[] = new int[]{
                            Color.parseColor("#0e9d58"),
                            Color.parseColor("#bfd047"),
                            Color.parseColor("#ffc105"),
                            Color.parseColor("#ef7e14"),
                            Color.parseColor("#d36259")};

                    int raters[] = new int[]{
                            new Random().nextInt(100),
                            new Random().nextInt(100),
                            new Random().nextInt(100),
                            new Random().nextInt(100),
                            new Random().nextInt(100)
                    };
                    ratingReviews.createRatingBars(100, BarLabels.STYPE1, colors, raters);

                    LinearLayout vComments = view.findViewById(R.id.ll_comments);
                    for (int i = 0; i < 2; i++)
                    {
                        view = inflater.inflate(R.layout.item_comment, null);
                        layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        layoutParams.weight = 5f;
                        layoutParams.gravity = Gravity.CENTER_VERTICAL;
                        layoutParams.bottomMargin = 20;
                        view.setLayoutParams(layoutParams);
                        vComments.addView(view);
                    }
                } else if (tab.getPosition() == 1) {
                    View view = inflater.inflate(R.layout.content_detail_product, null);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    layoutParams.weight = 5f;
                    layoutParams.gravity = Gravity.CENTER_VERTICAL;
                    view.setLayoutParams(layoutParams);
                    csProperties.addView(view);

                    LinearLayout vSpecifications = view.findViewById(R.id.ll_specifications);
                    LinearLayout vDescription = view.findViewById(R.id.ll_description);

                    for (int i = 0; i < 2; i++)
                    {
                        view = inflater.inflate(R.layout.item_detail_product, null);
                        vSpecifications.addView(view);
                    }
                    for (int i = 0; i < 2; i++)
                    {
                        view = inflater.inflate(R.layout.item_detail_product, null);
                        vDescription.addView(view);
                    }


                } else if (tab.getPosition() == 2) {
                    View view = inflater.inflate(R.layout.content_description_product, null);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    layoutParams.weight = 5f;
                    layoutParams.gravity = Gravity.CENTER_VERTICAL;
                    view.setLayoutParams(layoutParams);
                    csProperties.addView(view);

                    txtDesc = view.findViewById(R.id.showDesc);
                    txtMore = view.findViewById(R.id.txtMore);
                    txtMore.setOnClickListener(DetailsActivity.this);

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        TabLayout.Tab tab = tabLayout.getTabAt(2);
        tab.select();

        SliderView sliderView = findViewById(R.id.imageSlider);
        SliderAdapter adapter = new SliderAdapter(this);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        RecyclerView recyclerView2 = findViewById(R.id.rv_similar_product);
        recyclerView2.setLayoutManager(new /*RTL*/LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(new productAdapter(DummyContent.ITEMS));



        txt_bargain = findViewById(R.id.txt_bargain);
        txt_bargain.setOnClickListener(this);

        txt_major_shopping = findViewById(R.id.txt_major_shopping);
        txt_major_shopping.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_search, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        item.setChecked(false);
        int id = item.getItemId();
        if (id == R.id.action_search) {
            Toast.makeText(this, "جستجو", 5000).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void mo2351a(C1769a c1769a) {
        Toast.makeText(this, "نویگیشن", 5000).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.txt_bargain)
        {
            Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.dialog_bargain);

            TextView isAccept = dialog.findViewById(R.id.txt_is_accept);
            isAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialog = new Dialog(DetailsActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.setCancelable(true);
                    dialog.setContentView(R.layout.dialog_bargain_accept);
                    dialog.show();
                }
            });

            dialog.show();
        }

        if(v.getId() == R.id.txt_major_shopping)
        {
            Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.dialog_major_shopping);

            dialog.show();
        }
        if (txtMore.getText().equals("ادامه مطلب")) {
            try {
                txtDesc.expand();
                txtMore.setText("بستن");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            txtDesc.collapse();
            txtMore.setText("ادامه مطلب");
        }
    }
}
