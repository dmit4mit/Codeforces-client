package com.example.codeforcesclient.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.codeforcesclient.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,
        HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNavigation();
        if (null == savedInstanceState) {
            ContestFragment fragment = new ContestFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem aMenuItem) {
        switch (aMenuItem.getItemId()) {
        case R.id.action_contest:
            showFragment(new ContestFragment());
            break;
        case R.id.action_problemset:
            Toast.makeText(MainActivity.this, "Problemsets", Toast.LENGTH_SHORT).show();
            break;
        case R.id.action_rating:
            Toast.makeText(MainActivity.this, "Rating", Toast.LENGTH_SHORT).show();
            break;
        case R.id.action_gym:
            Toast.makeText(MainActivity.this, "Gym", Toast.LENGTH_SHORT).show();
            break;
        case R.id.action_menu:
            Toast.makeText(MainActivity.this, "Menu", Toast.LENGTH_SHORT).show();
            break;
        }
        return true;
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    private void showFragment(Fragment aFragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, aFragment, null).commit();
    }

    private void setupBottomNavigation() {
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }
}
