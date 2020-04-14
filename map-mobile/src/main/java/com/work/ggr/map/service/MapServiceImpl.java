package com.work.ggr.map.service;

import com.work.ggr.map.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : gr
 * @date : 2020/3/31 16:03
 */
@Service
public class MapServiceImpl implements MapService {

    @Autowired

    private PersonRepository repository;
    @Override
    public String readExcel(String path) {
        return null;
    }

    @Override
    public List getPersonByElementName(String elementName) {
        return repository.getPersonsByElementName(elementName);
    }
}
