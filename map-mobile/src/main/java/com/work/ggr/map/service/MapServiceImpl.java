package com.work.ggr.map.service;

import com.work.ggr.map.dao.NetworkElementRepository;
import com.work.ggr.map.dao.PersonRepository;
import com.work.ggr.map.model.NetWorkElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : gr
 * @date : 2020/3/31 16:03
 */
@Service
public class MapServiceImpl implements MapService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private NetworkElementRepository networkElementRepository;




}
