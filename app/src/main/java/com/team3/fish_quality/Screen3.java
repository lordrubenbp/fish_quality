package com.team3.fish_quality;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ruben on 10/02/2018.
 */

public class Screen3 extends Fragment {

    public int state1=1;
    public int state2=1;
    public int state3=1;

    LinearLayout diagramaPaso2=null;
    LinearLayout diagramaPaso3=null;
    ImageView diagramaFlecha4=null;
    LinearLayout diagramaPorcentaje=null;
    ArrayList<TextView> listDiagramTexts=null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView=inflater.inflate(R.layout.screen3_activity, container, false);

        LinearLayout diagramaPaso1=(LinearLayout)rootView.findViewById(R.id.diagramaPaso1);
        diagramaPaso2=(LinearLayout)rootView.findViewById(R.id.diagramaPaso2);
        diagramaPaso3=(LinearLayout)rootView.findViewById(R.id.diagramaPaso3);

        diagramaPorcentaje=(LinearLayout)rootView.findViewById(R.id.diagramaRecirculacionLayout);

        listDiagramTexts= new ArrayList<TextView>();

        final TextView  diagramaText1=(TextView)rootView.findViewById(R.id.diagramaText1);
        final TextView  diagramaText2=(TextView)rootView.findViewById(R.id.diagramaText2);
        final TextView  diagramaText3=(TextView)rootView.findViewById(R.id.diagramaText3);

        listDiagramTexts.add(diagramaText1);
        listDiagramTexts.add(diagramaText2);
        listDiagramTexts.add(diagramaText3);

        final TextView  diagramaPorcentajeText=(TextView)rootView.findViewById(R.id.diagramaPorcentajeRecirculacion);
        final SeekBar diagramaRecirculacionProgress=(SeekBar)rootView.findViewById(R.id.diagramaRecirculacionProgress);


        final ImageView diagramaIMG1=(ImageView)rootView.findViewById(R.id.diagramaIMG1);
        final ImageView diagramaIMG2=(ImageView)rootView.findViewById(R.id.diagramaIMG2);
        final ImageView diagramaIMG3=(ImageView)rootView.findViewById(R.id.diagramaIMG3);


         diagramaFlecha4=(ImageView)rootView.findViewById(R.id.diagramaFlecha4);


        diagramaRecirculacionProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                diagramaPorcentajeText.setText("%"+progress);
                DataSet.recirculationPercent=progress/100f;


            }
        });
        diagramaPaso1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                state1=carrouselOption(diagramaIMG1,diagramaText1,1,state1);
                setDataSetParam();
            }
        });
        diagramaPaso2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                state2=carrouselOption(diagramaIMG2,diagramaText2,2,state2);
                setDataSetParam();
            }
        });
        diagramaPaso3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                state3=carrouselOption(diagramaIMG3,diagramaText3,3,state3);
                setDataSetParam();
            }
        });
        diagramaFlecha4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(diagramaFlecha4.getVisibility()==View.VISIBLE)
                {
                    diagramaFlecha4.setVisibility(View.INVISIBLE);
                }else
                    {
                        diagramaFlecha4.setVisibility(View.VISIBLE);
                    }
            }
        });




        return rootView;
    }
    public int carrouselOption(ImageView diagramaIMG, TextView diagramaText, int origin,int state)
    {

        if(origin==1)
        {
            diagramaPaso2.setVisibility(View.VISIBLE);

        }else if(origin==2)
        {
            diagramaPaso3.setVisibility(View.VISIBLE);

        }else if(origin==3)
        {
            diagramaFlecha4.setVisibility(View.VISIBLE);
            diagramaPorcentaje.setVisibility(View.VISIBLE);
        }

        if(state==1)
        {
            diagramaIMG.setImageResource(R.drawable.rototamiz);
            diagramaText.setText(R.string.rototamiz);
            return ++state;
        }else if(state==2)
        {
            diagramaIMG.setImageResource(R.drawable.hrap);
            diagramaText.setText(R.string.hrap);
            return ++state;
        }else if(state==3)
        {
            diagramaIMG.setImageResource(R.drawable.lechobacteriano);
            diagramaText.setText(R.string.lechobac);
            return ++state;
        }else if(state==4)
        {
            diagramaIMG.setImageResource(R.drawable.sodis);
            diagramaText.setText(R.string.sodis);
            return ++state;
        }
        else if (state==5)
        {
            diagramaIMG.setImageResource(R.drawable.uv);
            diagramaText.setText(R.string.uv);
            return ++state;
        }else
            {
                diagramaIMG.setImageResource(R.drawable.empty);
                diagramaText.setText("");
                if(origin==1)
                {
                    diagramaPaso2.setVisibility(View.GONE);

                }else if(origin==2)
                {
                    diagramaPaso3.setVisibility(View.GONE);
                }else if(origin==3)
                {
                    diagramaFlecha4.setVisibility(View.GONE);
                    diagramaPorcentaje.setVisibility(View.INVISIBLE);
                }
                return 1;
            }



    }

    public void setDataSetParam()
    {
        DataSet.hasHRAP=false;
        DataSet.hasLecho=false;
        DataSet.hasRototamiz=false;
        DataSet.hasUV=false;
        DataSet.hasSODIS=false;
        for (int i = 0; i < listDiagramTexts.size(); i++) {

            TextView textView=listDiagramTexts.get(i);

            String salida=textView.getText().toString();

            Log.v("SALIDA",textView.getText().toString());

            if(salida.equals("HRAP"))
            {
                DataSet.hasHRAP=true;

            }else if(salida.equals("SODIS")){

                DataSet.hasSODIS=true;
            }else if(salida.equals("Ultravioleta")){

                DataSet.hasUV=true;

            }else if(salida.equals("L.Bacteriano")){

                DataSet.hasLecho=true;

            }else if(salida.equals("Rototamiz")){

                DataSet.hasRototamiz=true;

                }
        }
        Log.v("HRAP",DataSet.hasHRAP+"");
        Log.v("LECHO",DataSet.hasLecho+"");
        Log.v("ROTOTAMIZ",DataSet.hasRototamiz+"");
        Log.v("UV",DataSet.hasUV+"");
        Log.v("SODIS",DataSet.hasSODIS+"");
    }
}