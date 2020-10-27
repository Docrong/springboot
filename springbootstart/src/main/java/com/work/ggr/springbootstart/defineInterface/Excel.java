package com.work.ggr.springbootstart.defineInterface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : gr
 * @date : 2020/10/23 15:14
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {
    public String sheetName() default "defaultSheetName";

    public int order() default 0;

    public String dateFormat() default "yyyy-MM-dd hh:mm:ss";

    public String exportType() default "String";
}
