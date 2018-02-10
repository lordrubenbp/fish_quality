package com.team3.fish_quality;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by ruben on 10/02/2018.
 */

public class Screen1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.screen1_activity, container, false);

        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.screen1RadioGroup);
        final RadioButton extensiveRButton=(RadioButton)rootView.findViewById(R.id.extensiveRadioButton);
        extensiveRButton.setChecked(true);
        DataSet.kindExplotation="extensiva";
        final RadioButton intensiveRButton=(RadioButton)rootView.findViewById(R.id.intensiveRadioButton);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(extensiveRButton.isChecked())
                {
                    DataSet.kindExplotation="extensiva";

                }else if (intensiveRButton.isChecked())
                {
                    DataSet.kindExplotation="intensiva";
                }
            }
        });


        return rootView;
    }



}
