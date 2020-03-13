package com.work.ggr.h2.controller;

import com.work.ggr.h2.dao.LocationRepository;
import com.work.ggr.h2.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : gr
 * @date : 2020/3/11 0:07
 */
@Controller
public class LocationController {

	@Autowired
	LocationRepository locationRepository;

	@ResponseBody
	@RequestMapping("/findAll")
	public List<Location> hello() {
		return locationRepository.findAll();
	}

	@ResponseBody
	@RequestMapping("/save")
	public String save() {
		Location t = new Location();
		t.setLatitude(12345);
		t.setType("测试");
		t.setLongtitude(54321);
		locationRepository.save(t);
		return "save";
	}

	@ResponseBody
	@RequestMapping("/type")
	public List locationByType() {
		List list=locationRepository.getLocationsByType("测试");
		return list;
	}

}
