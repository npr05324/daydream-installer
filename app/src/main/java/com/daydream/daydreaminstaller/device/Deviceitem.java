package com.daydream.daydreaminstaller.device;

import android.net.Uri;

/**
 * Created by Calibur on 2015-07-07.
 */
public class Deviceitem {

    public String tex1, tex2, tex3, tex4, tex5;
    public Uri resid;

    public Deviceitem(String parm1, String parm2, String parm3, String parm4, String parm5, Uri resid) {
        this.tex1 = parm1;
        this.tex2 = parm2;
        this.tex3 = parm3;
        this.tex4 = parm4;
        this.tex5 = parm5;
        this.resid = resid;
    }

    public String getTex1() {
        return this.tex1;
    }

    public String getTex2() {
        return this.tex2;
    }

    public String getTex3() {
        return this.tex3;
    }

    public String getTex4() {
        return this.tex4;
    }

    public String getTex5() {
        return this.tex5;
    }

    public Uri getResid() {
        return this.resid;
    }
}
