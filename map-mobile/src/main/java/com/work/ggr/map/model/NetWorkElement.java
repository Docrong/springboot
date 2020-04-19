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
    //分光器名称
    @Column(name = "name")
    private String name;
    //经度
    @Column(name = "longitute")
    private String longitude;
    //维度
    @Column(name = "latitude")
    private String latitude;
}
