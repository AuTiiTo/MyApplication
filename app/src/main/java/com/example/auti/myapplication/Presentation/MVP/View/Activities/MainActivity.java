package com.example.auti.myapplication.Presentation.MVP.View.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.auti.myapplication.Presentation.MVP.View.Fragments.ProductFragment;
import com.example.auti.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private Fragment mFragent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mFragent = getSupportFragmentManager().findFragmentById(R.id.products_container);

        setUpToolbar();
        setUpFragment();
    }

    private void setUpFragment() {
        if (mFragent == null) {
            mFragent = ProductFragment.newInstance(null, null);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.products_container, mFragent)
                    .commit();
        }
    }

    private void setUpToolbar() {
        setSupportActionBar(mToolBar);
    }

}
