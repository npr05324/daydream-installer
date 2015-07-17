package com.daydream.daydreaminstaller.gapps;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daydream.daydreaminstaller.R;

/**
 * Created by benjaema on 2015-07-17.
 */
public class Gappsviewholder extends RecyclerView.ViewHolder {

    TextView mGapps;
    Button mGappsbtn;

    public Gappsviewholder(final View itemview) {
        super(itemview);
        mGapps = (TextView) itemview.findViewById(R.id.gapps);
        mGappsbtn = (Button) itemview.findViewById(R.id.gapps_btn);

        mGappsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(itemview.getContext(), "구현 예정", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
