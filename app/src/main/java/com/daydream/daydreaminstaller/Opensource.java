package com.daydream.daydreaminstaller;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by Calibur on 2015-07-08.
 */
public class Opensource extends PreferenceActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_open);

        LinearLayout linearLayout = (LinearLayout) findViewById(android.R.id.list).getParent().getParent().getParent();
        Toolbar toolbar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.pref_open_toolbar, linearLayout, false);
        linearLayout.addView(toolbar, 0);

        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#2ea7e6"));

        getPreferenceManager().findPreference("roottools")
                .setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://github.com/Stericson/RootTools"));
                        startActivity(intent);
                        return true;
                    }
                });

        getPreferenceManager().findPreference("apache")
                .setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://www.apache.org/licenses/LICENSE-2.0"));
                        startActivity(intent);
                        return true;
                    }
                });

        getPreferenceManager().findPreference("fresco")
                .setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://frescolib.org/index.html"));
                        startActivity(intent);
                        return true;
                    }
                });

        getPreferenceManager().findPreference("tint")
                .setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://github.com/jgilfelt/SystemBarTint"));
                        startActivity(intent);
                        return true;
                    }
                });
    }
}
