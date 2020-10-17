package com.work.ggr.springbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : gr
 * @date : 2020/9/10 22:14
 */
@Component
public class SetterA {
    private SetterB b;

    @Autowired
    public void setB(SetterB b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "SetterA{" +
                "b=" + b +
                '}';
    }
}
