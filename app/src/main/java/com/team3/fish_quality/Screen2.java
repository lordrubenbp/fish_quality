package com.team3.fish_quality;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ruben on 10/02/2018.
 */

public class Screen2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.screen2_activity, container, false);

        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        Map mapFrag = new Map();
        childFragTrans.add(R.id.frame_container, mapFrag);
        childFragTrans.addToBackStack("B");
        childFragTrans.commit();

        return rootView;
    }
}
