package com.daydream.daydreaminstaller.device;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.daydream.daydreaminstaller.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Calibur on 2015-07-07.
 */
public class Deviceviewholder extends RecyclerView.ViewHolder {

    TextView mDevice, mAndroid, mCPU, mBrand, mDeviceName;
    SimpleDraweeView mDeviceImage;

    public Deviceviewholder(View itemView) {
        super(itemView);
        mBrand = (TextView) itemView.findViewById(R.id.brand);
        mDevice = (TextView) itemView.findViewById(R.id.device);
        mCPU = (TextView) itemView.findViewById(R.id.cpu);
        mAndroid = (TextView) itemView.findViewById(R.id.andver);
        mDeviceImage = (SimpleDraweeView) itemView.findViewById(R.id.deviceimage);
        mDeviceName = (TextView) itemView.findViewById(R.id.devicename);
    }
}
