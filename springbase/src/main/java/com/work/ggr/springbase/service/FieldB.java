package com.work.ggr.springbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : gr
 * @date : 2020/9/10 21:42
 */
@Component
public class FieldB {
    @Autowired
    private FieldA a;

    public void outb() {
        System.out.println("this is a method -- b");
    }

    @Override
    public String toString() {
        return "FieldB{" +
                "a=" + a +
                '}';
    }
}
