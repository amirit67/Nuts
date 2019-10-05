package com.example.nuts;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.nuts.eventBus.ShowNavigationEvent;
import com.example.nuts.eventBus.ShowToolbarEvent;
import com.example.nuts.fragments.ProfileFragment;
import com.example.nuts.utils.navigation.C1769a;
import com.example.nuts.utils.navigation.C1770b;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements C1770b {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentStack stack = new FragmentStack(MainActivity.this, getSupportFragmentManager(), R.id.container);
                stack.replace(new ProfileFragment());
            }
        }, 100);

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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowToolbarEvent(ShowToolbarEvent showToolbarEvent) {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawer, showToolbarEvent.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                //findViewById(R.id.coordinatorLayout).setTranslationX(-(slideOffset * drawerView.getWidth()));
                drawer.bringChildToFront(drawerView);
                drawer.requestLayout();
            }
        };
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowNavigationEvent(ShowNavigationEvent showNavigationEvent) {
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
            //HSH.getInstance().hide(ActivityMain.this, navigationView);
        } else {
            drawer.openDrawer(Gravity.RIGHT);
            // HSH.getInstance().display(ActivityMain.this, navigationView);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
