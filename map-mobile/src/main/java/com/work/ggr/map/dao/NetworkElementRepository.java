package com.work.ggr.map.dao;

import com.work.ggr.map.model.NetWorkElement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author : gr
 * @date : 2020/3/31 19:15
 */
public interface NetworkElementRepository extends JpaRepository<NetWorkElement,Integer> {


}
