package com.work.ggr.map.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.work.ggr.map.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : gr
 * @date : 2020/3/31 8:42
 */
@Controller
public class MapController {

    @Resource
    private MapService service;

    @Value(value = "${user.path}")
    private String userPath;

    @RequestMapping("/demo")
    public String demo(HttpServletRequest request, HttpServletResponse response) {
        return "demo";
    }


    @RequestMapping("/demo2")
    public String demo2(HttpServletRequest request, HttpServletResponse response) {
        return "demo2";
    }

    @RequestMapping("/demo3")
    public String demo3(HttpServletRequest request, HttpServletResponse response) {
        return "demo3";
    }

    @RequestMapping("/demo4")
    public String demo4(HttpServletRequest request, HttpServletResponse response) {
        return "demo4";
    }

    @RequestMapping("/personList")
    public String getPersonList(HttpServletRequest request, HttpServletResponse response) {
        return "personList";
    }

    @RequestMapping("/readExcel")
    @ResponseBody
    public String readExcel() {
//        service.readExcel(userPath);
        return "请将excel文件放在" + userPath + "";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/clickAjax")
    public String clickAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("enter Ajax");
        //114.278, 30.592
        Map<String, String> map = new HashMap<>();
        map.put("name", "基站1");
        map.put("latitude", "114.278");
        map.put("longitude", "30.592");

        Map<String, String> map1 = new HashMap();
        map1.put("name", "基站2");
        map1.put("latitude", "114.279");
        map1.put("longitude", "30.593");

        Map<String, String> map2 = new HashMap();
        map2.put("name", "基站3");
        map2.put("latitude", "114.280");
        map2.put("longitude", "30.594");

        Map<String, String> map3 = new HashMap();
        map3.put("name", "基站4");
        map3.put("latitude", "114.281");
        map3.put("longitude", "30.595");

        Map<String, String> map4 = new HashMap();
        map4.put("name", "基站5");
        map4.put("latitude", "114.282");
        map4.put("longitude", "30.596");
        List<Map<String, String>> list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);

      /*
       Query query = this.entityManager.createQuery("", Long.class);
        query.setParameter("1", "");
       */

        Gson gson = new Gson();
        System.out.println(gson.toJson(list));
        return gson.toJson(list);
    }

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/listenMap")
    @ResponseBody
    public String listenMap(HttpServletRequest request, HttpServletResponse response) {
        String zoomNum = request.getParameter("zoomNum");
        String bounds = request.getParameter("bounds");
        Double zoomSize = Double.valueOf(zoomNum);
        Gson gson = new Gson();
        System.out.println("边框:" + gson.fromJson(bounds, JsonObject.class));
        System.out.println("缩放比例:" + zoomNum);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        JsonObject mapArea = gson.fromJson(bounds, JsonObject.class);
        String swLat = mapArea.get("sw_lat").getAsString();
        String swLng = mapArea.get("sw_lng").getAsString();
        String neLat = mapArea.get("ne_lat").getAsString();
        String neLng = mapArea.get("ne_lng").getAsString();

        final int pageSize = 15;
        if (zoomSize > pageSize) {
            List<Map<String, Object>> list1 = jdbcTemplate.queryForList("select * from mobile_networkelement where 1=1");
            String json = gson.toJson(list1);
            list = list1;
        }

        System.out.println("list1:" + gson.toJson(list));
        return gson.toJson(list);
    }
}
