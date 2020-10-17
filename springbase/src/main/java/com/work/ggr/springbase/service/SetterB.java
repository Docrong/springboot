package com.work.ggr.springbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : gr
 * @date : 2020/9/10 22:14
 */
@Component
public class SetterB {
    private SetterA a;

    @Autowired
    public void setA(SetterA a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "SetterB{" +
                "a=" + a +
                '}';
    }
}
