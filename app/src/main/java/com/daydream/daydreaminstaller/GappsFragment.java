package com.daydream.daydreaminstaller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daydream.daydreaminstaller.gapps.Gappsadapter;

import static com.daydream.daydreaminstaller.R.layout.gapps;

/**
 * Created by Calibur on 2015-07-15.
 */
public class GappsFragment extends Fragment {

    public Gappsadapter gappsadapter;
    public View view;
    // public String romurl = "http://123.143.18.210:82/";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(gapps, null);

        gappsadapter = new Gappsadapter();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.gapps_recycler);
        recyclerView.setAdapter(gappsadapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }
}
