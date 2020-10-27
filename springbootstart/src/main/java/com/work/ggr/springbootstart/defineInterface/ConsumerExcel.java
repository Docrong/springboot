package com.work.ggr.springbootstart.defineInterface;

/**
 * @author : gr
 * @date : 2020/10/23 15:42
 */
public class ConsumerExcel {

    @Excel(dateFormat = "yyyy MM dd", order = 1, sheetName = "导出表1")
    public String exportExcel1() {
        return "export Excel 1";
    }

    @Excel
    public String exportExcel2() {
        return "export Excel 2";
    }

}
