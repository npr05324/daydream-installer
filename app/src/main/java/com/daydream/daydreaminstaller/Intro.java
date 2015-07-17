package com.daydream.daydreaminstaller;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.stericson.RootTools.RootTools;

import java.io.File;

public class Intro extends AppCompatActivity {

    private Handler mHandler;
    private ProgressDialog mProgressDialog, progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        File mFile = new File(Environment.getExternalStorageDirectory().getPath() + "/DayDreamInstaller");
        if (!mFile.exists()) mFile.mkdirs();

        final String KEY_SU = getResources().getString(R.string.check_su);
        final String KEY_WARNING = getResources().getString(R.string.intro_choose);
        final String KEY_OK = getResources().getString(R.string.ok);
        final String KEY_BUSYBOX = getResources().getString(R.string.check_busybox);
        final String KEY_EXIT = getResources().getString(R.string.shutdown);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(KEY_WARNING)
                .setIcon(R.drawable.ic_warning_black)
                .setCancelable(false)
                .setMessage("본 앱을 사용함으로써, 생기는 모든 문제는 본인에게 있습니다. 원치 않으면 어플 종료를 누르세요.")
                .setPositiveButton(KEY_OK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mHandler = new Handler();
                        mProgressDialog = ProgressDialog.show(Intro.this, "", KEY_SU, true);
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    if (RootTools.isRootAvailable()) {
                                        mProgressDialog.dismiss();
                                        mHandler = new Handler();
                                        progressDialog = ProgressDialog.show(Intro.this, "", KEY_BUSYBOX, true);
                                        mHandler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                try {
                                                    if (RootTools.isBusyboxAvailable()) {
                                                        progressDialog.dismiss();
                                                        finish();
                                                        Intent intent = new Intent(Intro.this, Recycler.class);
                                                        startActivity(intent);
                                                    } else {
                                                        AlertDialog.Builder builder1 = new AlertDialog.Builder(Intro.this);
                                                        builder1.setMessage("BusyBox가 설치되어 있지 않습니다. 플레이 스토어로 이동합니다.")
                                                                .setTitle(KEY_WARNING)
                                                                .setIcon(R.drawable.ic_warning_black)
                                                                .setCancelable(false)
                                                                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                        finish();
                                                                        Intent intent = new Intent(Intent.ACTION_VIEW);
                                                                        intent.setData(Uri.parse("market://details?id=stericson.busybox"));
                                                                        startActivity(intent);
                                                                    }
                                                                });
                                                        AlertDialog alertDialog = builder1.create();
                                                        alertDialog.show();
                                                    }
                                                } catch (Exception e) {
                                                }
                                            }
                                        }, 1000);
                                    } else {
                                        mProgressDialog.dismiss();
                                        AlertDialog.Builder builder2 = new AlertDialog.Builder(Intro.this);
                                        builder2.setMessage("su 바이너리가 확인되지 않아 어플을 종료합니다.")
                                                .setCancelable(false)
                                                .setPositiveButton(KEY_OK, new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        finish();
                                                        android.os.Process.killProcess(android.os.Process.myPid());
                                                    }
                                                });
                                        AlertDialog alertDialog = builder2.create();
                                        alertDialog.show();
                                    }
                                } catch (Exception e) {
                                }
                            }
                        }, 1000);
                    }
                })
                .setNegativeButton(KEY_EXIT, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
