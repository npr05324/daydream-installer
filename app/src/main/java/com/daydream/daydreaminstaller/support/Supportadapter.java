package com.daydream.daydreaminstaller.support;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daydream.daydreaminstaller.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calibur on 2015-07-11.
 */
public class Supportadapter extends RecyclerView.Adapter<Supportviewholder> {

    String mGoogle, mLG, mSamsung, mSony;

    public List<Supportitem> items;

    public Supportadapter() {
        super();

        mGoogle = "#4caf50";
        mSamsung = "#2196f3";
        mLG = "#f44336";
        mSony ="#9c27b0";

        items = new ArrayList<>();

        // Google
        items.add(new Supportitem("Google", "Nexus 6\n"+
                "Nexus 5\n" +
                "Nexus 4\n" +
                "Nexus 7 2013 (Wi-Fi)\n" +
                "Nexus 7 (Wi-Fi)\n" +
                "Galaxy Nexus",
                Color.parseColor(mGoogle),
                Color.parseColor(mGoogle)));

        // LG
        items.add(new Supportitem("LG", "G3\n" +
                "G2\n" +
                "Optimus G Pro\n" +
                "Optimus GK\n" +
                "Optimus G",
                Color.parseColor(mLG),
                Color.parseColor(mLG)));


        // Samsung
        items.add(new Supportitem("Samsung", "Galaxy S3 LTE\n" +
                "Galaxy S2\n" +
                "Galaxy Note 2\n" +
                "Galaxy Pop",
                Color.parseColor(mSamsung),
                Color.parseColor(mSamsung)));

        // Sony
        items.add(new Supportitem("Sony", "Xperia Tablet Z (Wi-Fi)",
                Color.parseColor(mSony),
                Color.parseColor(mSony)));
    }

    @Override
    public Supportviewholder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new Supportviewholder(view);
    }

    @Override
    public void onBindViewHolder(Supportviewholder holder, int position) {
        final Supportitem Supportitem = items.get(position);
        holder.mBrand.setText(Supportitem.getTex1());
        holder.mDevices.setText(Supportitem.getTex2());
        holder.mBrand.setTextColor(Supportitem.getColor());
        holder.mSun.setBackgroundColor(Supportitem.getBackgound());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
