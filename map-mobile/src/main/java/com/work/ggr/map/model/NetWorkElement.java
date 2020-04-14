package com.work.ggr.map.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 网元
 * @author : gr
 * @date : 2020/3/31 9:59
 */
@Entity
@Setter
@Getter
@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
@Table(name = "mobile_networkelement")
public class NetWorkElement {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id", unique = true)
    private String id;
    @Column(name = "name")
    //分光器名称
    private String name;
    @Column(name = "longitute")
    //经度
    private String Longitude;
    @Column(name = "latitude")
    //维度
    private String Latitude;
}
