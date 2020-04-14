package com.work.ggr.map.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 用户表
 * @author : gr
 * @date : 2020/3/31 9:43
 */
@Entity
@Getter
@Setter
@Table(name = "mobile_person")
@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
public class Person {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id", unique = true)
    private String id;
    @Column(name = "username")
    private String username;
    @Column(name = "userid")
    private String userid;
    @Column(name = "ipaddress")
    private String ipAddress;
    @Column(name = "ipaddresscn")
    private String ipAddressCn;

    //分光器名称
    @Column(name = "elementname")
    private String elementName;

    @Column(name = "createtime")
    private String createTime;
}
