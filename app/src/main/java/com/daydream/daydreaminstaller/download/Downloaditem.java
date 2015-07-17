package com.daydream.daydreaminstaller.download;

/**
 * Created by Calibur on 2015-07-15.
 */
public class Downloaditem {

    String title, andver, build_date, md5;

    Downloaditem (String title, String andver, String build_date, String md5) {
        this.title = title;
        this.andver = andver;
        this.build_date = build_date;
        this.md5 = md5;
    }

    public String getTitle() {
        return title;
    }

    public String getAndver() {
        return andver;
    }

    public String getBuild_date() {
        return build_date;
    }

    public String getMd5() {
        return md5;
    }
}
