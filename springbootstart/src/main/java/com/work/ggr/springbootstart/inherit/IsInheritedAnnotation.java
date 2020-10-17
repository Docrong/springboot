package com.work.ggr.springbootstart.inherit;

import java.lang.annotation.*;

/**
 * @author : gr
 * @date : 2020/10/17 16:41
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface IsInheritedAnnotation {
}
