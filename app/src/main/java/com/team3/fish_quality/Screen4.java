package com.team3.fish_quality;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by ruben on 10/02/2018.
 */

public class Screen4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView= inflater.inflate(R.layout.screen4_activity, container, false);

        SeekBar distanciaProgresoProve=(SeekBar)rootView.findViewById(R.id.distanciaProgresoProve);
        SeekBar distanciaProgresoConsu=(SeekBar)rootView.findViewById(R.id.distanciaProgresoConsu);

        final TextView distanciaPorveText=(TextView)rootView.findViewById(R.id.distanciaProveedorText);
        final TextView distanciaConsuText=(TextView)rootView.findViewById(R.id.distanciaConsumidorText);


        distanciaProgresoProve.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                distanciaPorveText.setText(progress+" Km");

            }
        });
        distanciaProgresoConsu.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                distanciaConsuText.setText(progress+" Km");

            }
        });
        return rootView;
    }
}
