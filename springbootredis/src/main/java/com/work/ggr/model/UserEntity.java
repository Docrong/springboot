package com.work.ggr.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : gr
 * @date : 2019/9/26 17:08
 */
@Getter
@Setter
public class UserEntity implements Serializable {
    private String  id;
    private String guid;
    private String name;
    private String age;
    private Date createTime;


}
