package com.team3.fish_quality;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by ruben on 10/02/2018.
 */

public class Screen1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.screen1_activity, container, false);

        LinearLayout extensiva=(LinearLayout)rootView.findViewById(R.id.extensivaIMG);
        LinearLayout intensiva=(LinearLayout)rootView.findViewById(R.id.intensivaIMG);
        final ImageView intensivaIMG=(ImageView)rootView.findViewById(R.id.intensivaChange);


        extensiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSet.kindExplotation="extensiva";
            }
        });

        intensiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSet.kindExplotation="intensiva";
                intensivaIMG.setImageResource(R.drawable.intensivon);

            }
        });
        return rootView;
    }



}
