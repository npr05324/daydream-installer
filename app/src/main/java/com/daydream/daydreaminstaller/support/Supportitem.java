package com.daydream.daydreaminstaller.support;

/**
 * Created by Calibur on 2015-07-11.
 */
public class Supportitem {

    public String tex1, tex2;
    public int Color, Backgound;

    public Supportitem(String parm1, String parm2, int Color, int Backgound) {
        this.tex1 = parm1;
        this.tex2 = parm2;
        this.Color= Color;
        this.Backgound = Backgound;
    }

    public String getTex1() {
        return this.tex1;
    }

    public String getTex2() {
        return this.tex2;
    }

    public int getColor() {
        return this.Color;
    }

    public int getBackgound() {
        return this.Backgound;
    }

}
