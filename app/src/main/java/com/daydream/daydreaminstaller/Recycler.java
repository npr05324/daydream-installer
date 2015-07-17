package com.daydream.daydreaminstaller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.daydream.daydreaminstaller.device.Deviceadapter;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Calibur on 2015-07-07.
 */
public class Recycler extends AppCompatActivity {

    public static final String KEY_CPU = getProp("ro.board.platform");

    RecyclerView recyclerView;
    Deviceadapter deviceadapter;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_recycle);

        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#2ea7e6"));

        animation = AnimationUtils.loadAnimation(this, R.anim.alpha);

        recyclerView = (RecyclerView) findViewById(R.id.Recycle);
        deviceadapter = new Deviceadapter();
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(deviceadapter);
        recyclerView.setAnimation(animation);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager.getActiveNetworkInfo() != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            switch (networkInfo.getType()) {
                case ConnectivityManager.TYPE_WIFI:
                    Log.d("test", "WIFI");
                    break;
                case ConnectivityManager.TYPE_MOBILE:
                    Log.d("test", "Network");

                    AlertDialog.Builder builder = new AlertDialog.Builder(Recycler.this);
                    builder.setTitle("경고")
                            .setIcon(R.drawable.ic_warning_black)
                            .setMessage("데이터 연결이 확인되었습니다.\n계속하시겠습니까?")
                            .setCancelable(false)
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .setNegativeButton("종료", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                    break;
                case ConnectivityManager.TYPE_WIMAX:
                    Log.d("test", "WIMAX");
                    break;
            }
        } else {
            Log.d("test", "not network");

            AlertDialog.Builder builder = new AlertDialog.Builder(Recycler.this);
            builder.setTitle("네트워크 연결 오류")
                    .setIcon(R.drawable.ic_warning_black)
                    .setMessage("네트워크 연결을 확인 한 후 다시 실행해주세요.")
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
        }

        Button button = (Button) findViewById(R.id.prev);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Recycler.this);
                builder.setMessage("어플을 종료합니다.")
                        .setCancelable(false)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                android.os.Process.killProcess(android.os.Process.myPid());
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        Button btn1 = (Button) findViewById(R.id.next);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Recycler.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            finish();
            android.os.Process.killProcess(android.os.Process.myPid());
        }
        else if (id == R.id.share) {
            Intent msg = new Intent(Intent.ACTION_SEND);
            msg.addCategory(Intent.CATEGORY_DEFAULT);
            msg.putExtra(Intent.EXTRA_TEXT,
                    "My Device" +
                            "\n\nBrand : " + Build.BRAND +
                            "\nDevice : " + Build.MODEL + " (" + Build.DEVICE + ")" +
                            "\nCPU : " + KEY_CPU +
                            "\nAndroid Version : " + Build.VERSION.RELEASE +
                            "\n\nPost from DayDream Installer");
            msg.setType("text/plain");
            startActivity(Intent.createChooser(msg, "공유"));
        }
        return super.onOptionsItemSelected(item);
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
