package com.work.ggr.springbootstart.defineInterface;

import java.lang.annotation.*;

/**
 * @author : gr
 * @date : 2020/10/23 9:25
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Info {
    String value() default  "tom";
    boolean isDelete();
}

