package com.work.ggr.springbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : gr
 * @date : 2020/9/10 21:42
 */
@Component
public class FieldA {
    @Autowired
    private FieldB b;


    public void outA() {
        System.out.println("this is a method -- a");
    }

    @Override
    public String toString() {
        return "FieldA{" +
                "b=" + b +
                '}';
    }
}
