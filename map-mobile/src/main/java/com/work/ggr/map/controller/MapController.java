package com.work.ggr.map.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.work.ggr.map.service.MapService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
        service.readExcel(userPath);
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
        Map map = new HashMap<>();
        map.put("name", "基站1");
        map.put("latitude", "114.278");
        map.put("longitude", "30.592");

        Map map1 = new HashMap();
        map1.put("name", "基站2");
        map1.put("latitude", "114.279");
        map1.put("longitude", "30.593");

        Map map2 = new HashMap();
        map2.put("name", "基站3");
        map2.put("latitude", "114.280");
        map2.put("longitude", "30.594");

        Map map3 = new HashMap();
        map3.put("name", "基站4");
        map3.put("latitude", "114.281");
        map3.put("longitude", "30.595");

        Map map4 = new HashMap();
        map4.put("name", "基站5");
        map4.put("latitude", "114.282");
        map4.put("longitude", "30.596");
        List list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);

//        for (int i = 0; i < 10000; i++) {
//            Map m = new HashMap();
//            m.put("name", "基站" + i);
//            m.put("latitude", 114.282 + i / 1000);
//            m.put("longitude", 30.596 + i / 1000);
//            list.add(m);
//        }

        Gson gson = new Gson();

        System.out.println(gson.toJson(list));
        return gson.toJson(list);
    }

    @RequestMapping("listenZoom")
    @ResponseBody
    public String listenZoom(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Enter listenZoom");
        String ZoomNum = request.getParameter("zoomSize");
        return ZoomNum;
    }

    @RequestMapping("/listenMapMove")
    @ResponseBody
    public String listenMapMove(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("enter Bounds");
        String bounds = request.getParameter("bounds");
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(bounds,JsonObject.class);

        return bounds;
    }
}
