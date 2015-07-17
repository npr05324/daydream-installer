package com.daydream.daydreaminstaller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.daydream.daydreaminstaller.support.Supportadapter;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by Calibur on 2015-07-07.
 */
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Supportadapter supportadapter;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#2ea7e6"));

        // hide action bar Shadow (Lollipop)
        getSupportActionBar().setElevation(0);

        animation = AnimationUtils.loadAnimation(this, R.anim.alpha);

        recyclerView = (RecyclerView) findViewById(R.id.main_recycle);
        supportadapter = new Supportadapter();
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(supportadapter);

        final Button btn1 = (Button) findViewById(R.id.prev_main);
        Button btn2 = (Button) findViewById(R.id.next_main);

        DayDreamDevice();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Recycler.class);
                startActivity(intent);
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getDevices().equals("null")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("해당 디바이스는 DayDream 미지원 기기입니다. 어플을 종료합니다.")
                            .setCancelable(false)
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else {
                    Intent intent = new Intent(MainActivity.this, Download.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    public String getDevices() {
        String mDevice;

        /* Google */
        /* Google Nexus 7 2013 (flo) */
        if (Build.MODEL.equals("Nexus 7")) {
            mDevice = "flo";
            return mDevice.toString();

            /* Google Neuxs 6 (shamu) */
        } else if (Build.MODEL.equals("Nexus 6")) {
            mDevice = "shamu";
            return mDevice.toString();

            /* Google Nexus 5 (hammerhead) */
        } else if (Build.MODEL.equals("Nexus 5")) {
            mDevice = "hammerhead";
            return mDevice.toString();

            /* Google Nexus 4 (mako) */
        } else if (Build.MODEL.equals("Nexus 4")) {
            mDevice = "mako";
            return mDevice.toString();

            /* Google Galaxy Nexus (maguro) */
        } else if (Build.MODEL.equals("Galaxy Nexus")) {
            mDevice = "maguro";
            return mDevice.toString();

            /* LG */
            /* LG G3 (f400) */
        } else if (Build.MODEL.equals("LG-F400S") ||
                Build.MODEL.equals("LG-F400K")) {
            mDevice = "f400";
            return mDevice.toString();

            /* LG G2 (f320) */
        } else if (Build.MODEL.equals("LG-F320S") ||
                Build.MODEL.equals("LG-F320K")) {
            mDevice = "f320";
            return mDevice.toString();

            /* LG Optimus GK (f220k) */
        } else if (Build.MODEL.equals("LG-F220K")) {
            mDevice = "f220k";
            return mDevice.toString();

            /* LG Optimus G Pro (geefhd) */
        } else if (Build.MODEL.equals("LG-F240S") ||
                Build.MODEL.equals("LG-F240K")) {
            mDevice = "geefhd";
            return mDevice.toString();

            /* LG Optimus G (gee) */
        } else if (Build.MODEL.equals("LG-F180S") ||
                Build.MODEL.equals("LG-F180K")) {
            mDevice = "gee";
            return mDevice.toString();

            /* Samsung Galaxy Note 4 (임시 테스트 용, 정식 릴리즈 때는 코드 삭제) */
        } else if (Build.MODEL.equals("SM-N910K")) {
            mDevice = "treltektt";
            return mDevice.toString();

            /* 위 지원기기에 없는 경우 */
        } else {
            return "null";
        }
    }

    public void DayDreamDevice() {

        TextView textView = (TextView) findViewById(R.id.checkmydevice);
        textView.setGravity(Gravity.CENTER);
        textView.setAnimation(animation);

        String mSupport = getResources().getString(R.string.support);
        String mNoSupport = getResources().getString(R.string.no_support);

        /* Google */
        /* Google Nexus 7 2013 (flo) */
        if (Build.MODEL.equals("Nexus 7")) {
            textView.setText(Build.MODEL + " " + mSupport);

            /* Google Nexus 5 (hammerhead) */
        } else if (Build.MODEL.equals("Nexus 5")) {
            textView.setText(Build.MODEL+" "+mSupport);

            /* Google Nexus 4 (mako) */
        } else if (Build.MODEL.equals("Nexus 4")) {
            textView.setText(Build.MODEL+" "+mSupport);

            /* Google Galaxy Nexus (maguro) */
        } else if (Build.MODEL.equals("Galaxy Nexus")) {
            textView.setText(Build.MODEL + " " + mSupport);

            /* LG */
            /* LG G3 (f400) */
        } else if (Build.MODEL.equals("LG-F400S") ||
                Build.MODEL.equals("LG-F400K")) {
            textView.setText(Build.MODEL + " " + mSupport);

            /* LG G2 (f320) */
        } else if (Build.MODEL.equals("LG-F320S") ||
                Build.MODEL.equals("LG-F320K")) {
            textView.setText(Build.MODEL + " " + mSupport);

            /* LG Optimus GK (f220k) */
        } else if (Build.MODEL.equals("LG-F220K")) {
            textView.setText(Build.MODEL + " " + mSupport);

            /* LG Optimus G Pro (geefhd) */
        } else if (Build.MODEL.equals("LG-F240S") ||
                Build.MODEL.equals("LG-F240K")) {
            textView.setText(Build.MODEL + " " + mSupport);

            /* LG Optimus G (gee) */
        } else if (Build.MODEL.equals("LG-F180S") ||
                Build.MODEL.equals("LG-F180K")) {
            textView.setText(Build.MODEL+" "+mSupport);

            /* 위 지원기기에 없는 경우 */
        } else {
            textView.setText(Build.MODEL+" "+mNoSupport);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                return true;
        }
        return super.onKeyDown(keyCode, event);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent Prefinformation = new Intent(this, Prefinformation.class);
            startActivity(Prefinformation);
        }
        else if (id == R.id.shutdown) {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
        return super.onOptionsItemSelected(item);
    }
}
