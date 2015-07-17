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
import android.widget.TextView;

import com.daydream.daydreaminstaller.download.Downloadadapter;

import static com.daydream.daydreaminstaller.R.layout.rom;

/**
 * Created by Calibur on 2015-07-15.
 */
public class ROMFragment extends Fragment {

    public View view;
    public Downloadadapter downloadadapter;
    public TextView textView;
    public MainActivity device = new MainActivity();
    // public String romurl = "http://123.143.18.210:82/";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(rom, null);

        downloadadapter = new Downloadadapter();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_rom);
        recyclerView.setAdapter(downloadadapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        textView = (TextView) view.findViewById(R.id.recycle_device);
        textView.setText("Device : "+device.getDevices());

        return view;
    }
}
