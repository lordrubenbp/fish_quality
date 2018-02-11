package com.team3.fish_quality;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FormActivity extends AppCompatActivity  {

    ViewPager viewPager=null;
    int fragmentNumber=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form_activity);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        FormActivityAdapter adapter = new FormActivityAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);
    }

    public void onClickNext(View view)
    {
        if(DataSet.kindExplotation.equals("extensiva"))
        {
            Intent intent= new Intent(getApplicationContext(),ResultActivity.class);
            startActivity(intent);
        }
        if(fragmentNumber<4) {
            fragmentNumber++;
        }else
            {
                fragmentNumber=0;
            }

        viewPager.setCurrentItem(fragmentNumber);

    }

    public void onClickEnd(View view)
    {
        Intent intent= new Intent(getApplicationContext(),ResultActivity.class);
        startActivity(intent);
    }

}

