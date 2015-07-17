package com.daydream.daydreaminstaller.download;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daydream.daydreaminstaller.R;

/**
 * Created by Calibur on 2015-07-15.
 */
public class Downloadviewholder extends RecyclerView.ViewHolder {

    TextView title, andver, build, md5;
    Button button;

    public Downloadviewholder(View itemview) {
        super(itemview);
        title = (TextView) itemview.findViewById(R.id.title);
        andver = (TextView) itemview.findViewById(R.id.rom_andver);
        build = (TextView) itemview.findViewById(R.id.build_date);
        md5 = (TextView) itemview.findViewById(R.id.md5);
        button = (Button) itemview.findViewById(R.id.btn);
    }
}
