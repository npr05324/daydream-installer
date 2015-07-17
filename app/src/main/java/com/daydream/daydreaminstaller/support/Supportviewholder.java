package com.daydream.daydreaminstaller.support;

import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daydream.daydreaminstaller.R;

/**
 * Created by Calibur on 2015-07-11.
 */
public class Supportviewholder extends RecyclerView.ViewHolder {

    TextView mBrand, mDevices;
    ImageView mSun;

    public Supportviewholder(View itemView) {
        super(itemView);
        mBrand = (TextView) itemView.findViewById(R.id.brand1);
        mDevices = (TextView) itemView.findViewById(R.id.devices);
        mDevices.setGravity(Gravity.CENTER);
        mSun = (ImageView) itemView.findViewById(R.id.sun);
    }
}
