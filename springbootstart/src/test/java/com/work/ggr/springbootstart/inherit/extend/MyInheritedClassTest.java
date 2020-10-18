package com.work.ggr.springbootstart.inherit.extend;

import com.work.ggr.springbootstart.inherit.IsInheritedAnnotation;
import com.work.ggr.springbootstart.inherit.IsNotInheritedAnnotation;
import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : gr
 * @date : 2020/10/17 16:58
 */
class MyInheritedClassTest {

    @Test
    public void testInherited() {
        Annotation[] annotations = MyInheritedClass.class.getAnnotations();
        assertTrue(Arrays.stream(annotations).anyMatch(l -> l.annotationType().equals(IsInheritedAnnotation.class)), "");
        assertTrue(Arrays.stream(annotations).noneMatch(l -> l.annotationType().equals(IsNotInheritedAnnotation.class)), "");

    }
}