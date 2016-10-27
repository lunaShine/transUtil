package com.yco.test;

/**
 * Created by yuekexin on 2016/10/26.
 */
public class Idcard {
    public int id;
    public String address;

    public Idcard() {
    }

    public Idcard(int id, String address) {
        this.id = id;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Idcard{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
