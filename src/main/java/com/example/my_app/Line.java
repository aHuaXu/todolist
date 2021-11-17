package com.example.my_app;

public class Line {
    private String num;
    private String time;
    private boolean t_f;

    public Line(String num, String time, boolean t_f) {
        this.num = num;
        this.time = time;
        this.t_f = t_f;
    }


    public String getNum() {
        return num;
    }

    public String getTime() {
        return time;
    }

    public boolean isT_f() {
        return t_f;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setT_f(boolean t_f) {
        this.t_f = t_f;
    }
}
