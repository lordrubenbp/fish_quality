package com.team3.fish_quality;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by ruben on 10/02/2018.
 */

public class Screen2 extends Fragment {

    int totalProgreso1=0;
    int totalProgreso2=0;
    int totalProgreso3=0;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView= inflater.inflate(R.layout.screen2_activity, container, false);

        final EditText especieEditText= (EditText)rootView.findViewById(R.id.especieEditText);
        final EditText produccionEditText= (EditText)rootView.findViewById(R.id.produccionEditText);

        SeekBar seekBar1 = (SeekBar) rootView.findViewById(R.id.seekBar1);
        final TextView progreso1=(TextView)rootView.findViewById(R.id.porcentaje1);

        SeekBar seekBar2 = (SeekBar) rootView.findViewById(R.id.seekBar2);
        final TextView progreso2=(TextView)rootView.findViewById(R.id.porcentaje2);

        SeekBar seekBar3 = (SeekBar) rootView.findViewById(R.id.seekBar3);
        final TextView progreso3=(TextView)rootView.findViewById(R.id.porcentaje3);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                DataSet.feedPercentageCereals= totalProgreso1/100f;
                Log.v("PERCENTAGE",DataSet.feedPercentageCereals+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {


                progreso1.setText("%"+progress);
                totalProgreso1=progress;


            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                DataSet.feedPercentageFish= totalProgreso2/100f;
                Log.v("PERCENTAGE",DataSet.feedPercentageFish+"");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                progreso2.setText("%"+progress);
                totalProgreso2=progress;


            }
        });

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                DataSet.feedPercentageOthers= totalProgreso3/100f;
                Log.v("PERCENTAGE",DataSet.feedPercentageOthers+"");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                progreso3.setText("%"+progress);
                totalProgreso3=progress;


            }
        });


        especieEditText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                DataSet.kindSpecies=especieEditText.getText().toString().toLowerCase();

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        produccionEditText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                DataSet.production =Integer.parseInt(produccionEditText.getText().toString().toLowerCase());

                Log.v("PRODUCCION",DataSet.production+"");

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });


        return rootView;
    }
}
