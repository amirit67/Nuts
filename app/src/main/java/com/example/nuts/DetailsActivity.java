package com.example.nuts;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nuts.adapter.productAdapter;
import com.example.nuts.utils.navigation.C1769a;
import com.example.nuts.utils.navigation.C1770b;

public class DetailsActivity extends AppCompatActivity implements C1770b {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView2 = findViewById(R.id.rv_similar_product);
        recyclerView2.setLayoutManager(new /*RTL*/LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(new productAdapter(DummyContent.ITEMS));
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
}
