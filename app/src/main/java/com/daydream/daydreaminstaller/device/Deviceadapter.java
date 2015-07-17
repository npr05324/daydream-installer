package com.daydream.daydreaminstaller.device;

import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daydream.daydreaminstaller.R;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calibur on 2015-07-07.
 */
public class Deviceadapter extends RecyclerView.Adapter<Deviceviewholder> {

    public Uri getDeviceImage;
    public String getDeviceName;
    public String getImageURL = "http://bje0716.dothome.co.kr/";

    public static final String KEY_DEVICE = getProp("ro.product.model");
    public static final String KEY_CPU = getProp("ro.board.platform");

    public List<Deviceitem> items;

    public Deviceadapter() {
        super();
        CheckDevice();
        items = new ArrayList<>();
        items.add(new Deviceitem("Brand : "+ Build.BRAND,
                "Device : "+Build.MODEL+" ("+Build.DEVICE+")",
                "CPU : "+KEY_CPU,
                "Android Version : "+Build.VERSION.RELEASE,
                getDeviceName,
                getDeviceImage));
    }

    @Override
    public Deviceviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        Fresco.initialize(parent.getContext());
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_recycle_item, parent, false);
        return new Deviceviewholder(view);
    }

    @Override
    public void onBindViewHolder(Deviceviewholder holder, int position) {
        final Deviceitem Deviceitem = items.get(position);
        holder.mBrand.setText(Deviceitem.getTex1());
        holder.mDevice.setText(Deviceitem.getTex2());
        holder.mCPU.setText(Deviceitem.getTex3());
        holder.mAndroid.setText(Deviceitem.getTex4());
        holder.mDeviceImage.setImageURI(Deviceitem.getResid());
        holder.mDeviceName.setText(Deviceitem.getTex5());
    }

    // device_recycle_item.xml 빌드프롬 체크해서 보여줌
    public void CheckDevice() {

        /* Samsung Galaxy Note 4 (2560 x 1440) */
        if (Build.MODEL.equals("SM-N910K") ||
                Build.MODEL.equals("SM-N910S") ||
                Build.MODEL.equals("SM-N910L")) {
            getDeviceImage = Uri.parse(getImageURL + "note4.png");
            getDeviceName = "Samsung Galaxy Note 4";

            /* Google Nexus 6 (2560 x 1440) */
        } else if (Build.MODEL.equals("Nexus 6")) {
            getDeviceImage = Uri.parse(getImageURL+"nexus6.png");
            getDeviceName = "Google Nexus 6";

            /* Google Nexus 7 (1920 x 1200) */
        } else if (Build.MODEL.equals("Nexus 7")) {
            getDeviceImage = Uri.parse(getImageURL+"nexus7_2013.png");
            getDeviceName = "Google Nexus 7";

            /* Google Nexus 5 (1920 x 1080) */
        } else if (Build.MODEL.equals("Nexus 5")) {
            getDeviceImage = Uri.parse(getImageURL+"nexus5.png");
            getDeviceName = "Google Nexus 5";

            /* Samsung Galaxy S3 LTE (1280 x 720) */
        } else if (Build.MODEL.equals("SHV-E210S") ||
                Build.MODEL.equals("SHV-E210K") ||
                Build.MODEL.equals("SHV-E210L")) {
            getDeviceImage = Uri.parse(getImageURL+"s3lte.jpg" +
                    "");
            getDeviceName = "Samsung Galaxy S3 LTE";

            /* LG G2 (1920 x 1080) */
        } else if (Build.MODEL.equals("LG-F320S") ||
                Build.MODEL.equals("LG-F320K") ||
                Build.MODEL.equals("LG-F320L")) {
            getDeviceImage = Uri.parse(getImageURL+"g2.png");
            getDeviceName = "LG G2";

            /* Google Nexus 4 (1280 x 768) */
        } else if (Build.MODEL.equals("Nexus 4")) {
            getDeviceImage = Uri.parse(getImageURL+"nexus4.jpg");
            getDeviceName = "Google Nexus 4";

            /* Optimus G (1280 x 768) */
        } else if (Build.MODEL.equals("LG-F180S") ||
                Build.MODEL.equals("LG-F180K") ||
                Build.MODEL.equals("LG-F180L")) {
            getDeviceImage = Uri.parse(getImageURL+"gee.png");
            getDeviceName = "LG Optimus G";

            /* LG Optimus G Pro (1920 x 1080) */
        } else if (Build.MODEL.equals("LG-F240S") ||
                Build.MODEL.equals("LG-F240K") ||
                Build.MODEL.equals("LG-F240L")) {
            getDeviceImage = Uri.parse(getImageURL+"geefhd.jpg");
            getDeviceName = "LG Optimus G Pro";

            /* VEGA Racer (480 x 800) */
        } else if (Build.MODEL.equals("IM-A760S") ||
                Build.MODEL.equals("IM-A770K") ||
                Build.MODEL.equals("IM-A780L")) {
            getDeviceImage = Uri.parse(getImageURL+"vr.png");
            getDeviceName = "VEGA Racer";

            /* LG G Pro 2 (1920 x 1080) */
        } else if (Build.MODEL.equals("LG-F350S") ||
                Build.MODEL.equals("LG-F350K") ||
                Build.MODEL.equals("LG-F350L")) {
            getDeviceImage = Uri.parse(getImageURL+"gpro2.png");
            getDeviceName = "LG G Pro 2";

            /* LG Optimus GK (1920 x 1080) */
        } else if (Build.MODEL.equals("LG-F220K")) {
            getDeviceImage = Uri.parse(getImageURL+"gk.jpg");
            getDeviceName = "LG Optimus GK";

            /* LG Optimus LTE 3 (1280 x 720) */
        } else if (Build.MODEL.equals("LG-F260S")) {
            getDeviceImage = Uri.parse(getImageURL + "lte3.png");
            getDeviceName = "LG Optimus LTE 3";

            /* LG G3 Beat (1280 x 720) */
        } else if (Build.MODEL.equals("LG-F470S") ||
                Build.MODEL.equals("LG-F470K") ||
                Build.MODEL.equals("LG-F470L")) {
            getDeviceImage = Uri.parse(getImageURL + "g3beat.png");
            getDeviceName = "LG G3 Beat";

            /* VEGA Secret Up (1920 x 1080) */
        } else if (Build.MODEL.equals("IM-A900S") ||
                Build.MODEL.equals("IM-A900K") ||
                Build.MODEL.equals("IM-A900L")) {
            getDeviceImage = Uri.parse(getImageURL + "vsp.jpg");
            getDeviceName = "VEGA Secret Up";

            /* LG AKA (1280 x 720) */
        } else if (Build.MODEL.equals("LG-F520S") ||
                Build.MODEL.equals("LG-F520K") ||
                Build.MODEL.equals("LG-F520L")) {
            getDeviceImage = Uri.parse(getImageURL + "aka.png");
            getDeviceName = "LG AKA";

            /* 위 기기에 없을 경우 */
        } else if (Build.MODEL.equals(KEY_DEVICE)) {
            getDeviceName = "Unknown";
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static String getProp(String prop) {
        try {
            Process process = Runtime.getRuntime().exec("getprop " + prop);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));
            StringBuilder log = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }
            return log.toString();
        } catch (IOException e) {
            // Runtime error
        }
        return null;
    }

}
