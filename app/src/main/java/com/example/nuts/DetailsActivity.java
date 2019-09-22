package com.example.nuts;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.nuts.fragments.Login1Fragment;
import com.example.nuts.utils.navigation.C1769a;
import com.example.nuts.utils.navigation.C1770b;

public class DetailsActivity extends AppCompatActivity implements C1770b {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentStack stack = new FragmentStack(this, getSupportFragmentManager(), R.id.container);
        stack.replace(new Login1Fragment());
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
