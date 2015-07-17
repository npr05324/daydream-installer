package com.daydream.daydreaminstaller.gapps;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daydream.daydreaminstaller.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benjaema on 2015-07-17.
 */
public class Gappsadapter extends RecyclerView.Adapter<Gappsviewholder> {

    private List<Gappsitem> items;

    public Gappsadapter() {
        super();
        items = new ArrayList<>();
        items.add(new Gappsitem("TK Gapps"));
    }

    @Override
    public Gappsviewholder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gapps_item, parent, false);
        return new Gappsviewholder(view);
    }

    @Override
    public void onBindViewHolder(Gappsviewholder holder, int position) {
        final Gappsitem item = items.get(position);
        holder.mGapps.setText(item.getmGapps());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
