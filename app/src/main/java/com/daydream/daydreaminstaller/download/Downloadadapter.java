package com.daydream.daydreaminstaller.download;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daydream.daydreaminstaller.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calibur on 2015-07-15.
 */
public class Downloadadapter extends RecyclerView.Adapter<Downloadviewholder> {

    private List<Downloaditem> items;

    public Downloadadapter() {
        super();
        items = new ArrayList<>();
        items.add(new Downloaditem("DayDream Version : DreamPop",
                "Android Version : 5.1.1",
                "Build Date : 2015.07.16",
                "MD5 : 블라블라"));
    }

    @Override
    public Downloadviewholder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rom_item, parent, false);
        return new Downloadviewholder(view);
    }

    @Override
    public void onBindViewHolder (Downloadviewholder holder, int position) {
        final Downloaditem item = items.get(position);
        holder.title.setText(item.getTitle());
        holder.andver.setText(item.getAndver());
        holder.build.setText(item.getBuild_date());
        holder.md5.setText(item.getMd5());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
