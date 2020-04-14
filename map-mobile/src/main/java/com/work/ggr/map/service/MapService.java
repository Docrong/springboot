package com.work.ggr.map.service;

import java.util.List;

/**
 * @author : gr
 * @date : 2020/3/31 16:00
 */
public interface MapService {

    public String readExcel(String path);

    public List getPersonByElementName(String elementName);
}
