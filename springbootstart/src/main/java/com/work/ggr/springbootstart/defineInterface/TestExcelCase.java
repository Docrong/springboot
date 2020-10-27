package com.work.ggr.springbootstart.defineInterface;

import java.lang.reflect.Method;

/**
 * @author : gr
 * @date : 2020/10/23 15:48
 */
public class TestExcelCase {
    public static void main(String[] args) throws NoSuchMethodException {
        ConsumerExcel consumerExcel = new ConsumerExcel();

        Method exportExcel1 = ConsumerExcel.class.getDeclaredMethod("exportExcel1", null);
        Method exportExcel2 = ConsumerExcel.class.getDeclaredMethod("exportExcel2", null);
        Excel excel1Annotation = exportExcel1.getAnnotation(Excel.class);
        Excel excel2Annotation = exportExcel2.getAnnotation(Excel.class);
        System.out.println("sheetName:" + excel1Annotation.sheetName() + ",dateFormat:" + excel1Annotation.dateFormat() + ",order:" + excel1Annotation.order());
        System.out.println("sheetName:" + excel2Annotation.sheetName() + ",dateFormat:" + excel2Annotation.dateFormat() + ",order:" + excel2Annotation.order());
    }
}
