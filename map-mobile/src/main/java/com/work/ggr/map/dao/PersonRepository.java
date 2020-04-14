package com.work.ggr.map.dao;

import com.work.ggr.map.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : gr
 * @date : 2020/3/31 19:13
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {


    /**通过elementName获取person
    */
    public List getPersonsByElementName(String elementName);

}
