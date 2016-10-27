package com.yco.test;

import util.EntryGetter;
import util.KeyGetter;
import com.yco.util.TransUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yuekexin on 2016/10/26.
 */
public class Test {
    public static void main(String[] args) {
        List<People> list = new ArrayList<People>();

        list.add(new People("Y", 1, new Idcard(111, "BJ")));
        list.add(new People("Z", 2, new ChinaIdCard(222, "SH", "B")));
        list.add(new Son("S", 3, new ChinaIdCard(333, "HRB", "C"), "School"));

        /*Set<Idcard> set = TransUtil.transToSet(list, new KeyGetter<People, Idcard>() {
            public Idcard getKey(People p) {
                return p.idcard;
            }
        });*/
        
        Map<String, Integer> map = TransUtil.extractTransToMap(list, new EntryGetter<People, String, Integer>() {
            public String getKey(People entry) {
                return entry.name;
            }

            public Integer getValue(People entry) {
                return entry.age;
            }
        });

        System.out.println(map);
    }
}
