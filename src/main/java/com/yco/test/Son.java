package com.yco.test;

/**
 * Created by yuekexin on 2016/10/26.
 */
public class Son extends People{
    public String school;

    public Son(String name, int age, Idcard idcard, String school) {
        super(name, age, idcard);
        this.school = school;
    }
}
