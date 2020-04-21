package com.work.ggr.map.dao.impl;/**
 * @author : gr
 * @date : 2020/4/15 20:36
 */

import com.work.ggr.map.dao.NetWorkElementDao;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

/**
 * @date: 2020/4/15 20:36
 * @author: gr
 */
@Repository
public class NetWorkElementDaoImpl implements NetWorkElementDao {

    @PersistenceContext
    EntityManager entityManager;

    public Map findNetWorkElementsByCondition(Map maptj, Pageable pageable) {

        StringBuffer countSelectSql = new StringBuffer();
        countSelectSql.append("select count(*) from NetWorkElement t where 1=1");
        StringBuffer selectSql=new StringBuffer();
        selectSql.append("from NetworkElement t where 1=1");

        StringBuffer whereSql = new StringBuffer();
        String countSql = new StringBuilder().append(countSelectSql).append(whereSql).toString();
        Query countQuery = this.entityManager.createQuery(countSql,Long.class);
        

        Map map = new HashMap();
        return map;
    }
}
