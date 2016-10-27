package com.yco.test;

/**
 * Created by yuekexin on 2016/10/26.
 */
public class ChinaIdCard extends Idcard{
    public String province;

    public ChinaIdCard() {
    }

    public ChinaIdCard(int id, String address, String province) {
        super(id, address);
        this.province = province;
    }

    @Override
    public String toString() {
        return "ChinaIdCard{" +
                "province='" + province + '\'' +
                '}';
    }
}
