package com.work.ggr.service;

import org.springframework.stereotype.Service;

/**
 * @author : gr
 * @date : 2019/12/6 16:09
 */
@Service
public class AopService {

	public String getPersonInfo(String str){
		System.out.println("Enter"+getClass().getName()+"-getPersonInfo()");
		return str;
	}
}
