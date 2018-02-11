package com.team3.fish_quality;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by ruben on 10/02/2018.
 */

public class FormActivityAdapter extends FragmentPagerAdapter {

    private final Context mContext;

    public FormActivityAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

                //creo el objeto del fragment a mostrar
                Screen1 screen1 = new Screen1();

                return screen1;

            case 1:
                Screen2 screen2 = new Screen2();

                return screen2;

            case 2:
                Screen3 screen3 = new Screen3();

                return screen3;
            default:
                Screen4 screen4 = new Screen4();

                return screen4;




        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //dependiendo de en que pantalla me mueva se muestra un nombre de pantalla u otro
        switch (position) {
            case 0:
                return mContext.getString(R.string.screen1);

            case 1:
                return mContext.getString(R.string.screen2);

            case 2:
                return mContext.getString(R.string.screen3);
            default:
                return mContext.getString(R.string.screen4);



        }


    }


}
