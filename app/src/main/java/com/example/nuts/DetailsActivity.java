package com.example.nuts;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nuts.adapter.SliderAdapter;
import com.example.nuts.adapter.priceAdapter;
import com.example.nuts.adapter.productAdapter;
import com.example.nuts.utils.ExpandableTextView;
import com.example.nuts.utils.navigation.C1769a;
import com.example.nuts.utils.navigation.C1770b;
import com.example.nuts.utils.reviewratings.BarLabels;
import com.example.nuts.utils.reviewratings.RatingReviews;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DetailsActivity extends AppCompatActivity implements C1770b, View.OnClickListener {

    public TextView txtMore;
    public ExpandableTextView txtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtDesc = findViewById(R.id.showDesc);
        txtMore = findViewById(R.id.txtMore);
        txtMore.setOnClickListener(this);

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

        RecyclerView recyclerView3 = findViewById(R.id.rv_price);
        recyclerView3.setLayoutManager(new /*RTL*/LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setAdapter(new priceAdapter(this, DummyContent.ITEMS));

        RatingReviews ratingReviews = findViewById(R.id.rating_reviews);

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
