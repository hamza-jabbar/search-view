package com.hjabb.androidprojects.searchview;

/**
 * Created by hjabb on 19/03/2017.
 */

public class Hall {
    private String name;
    private int hallImg;

    public Hall(String name, int hallImg) {
        this.setName(name);
        this.setHallImg(hallImg);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHallImg() {
        return hallImg;
    }

    public void setHallImg(int hallImg) {
        this.hallImg = hallImg;
    }
}
