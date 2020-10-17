package com.work.ggr.springbase.Controller;

import com.work.ggr.springbase.service.FieldA;
import com.work.ggr.springbase.service.FieldB;
import com.work.ggr.springbase.service.SetterA;
import com.work.ggr.springbase.service.SetterB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : gr
 * @date : 2020/9/10 21:42
 */
@Controller
public class BaseController {

    @Autowired
    private FieldA a;
    @Autowired
    private FieldB b;

    @RequestMapping("/test")
    @ResponseBody
    public String testField() {
        System.out.println(a.toString());;
        System.out.println(b.toString());;
        return "123";
    }

    private SetterA setterA;
    private SetterB setterB;

    @Autowired
    public void setSetterA(SetterA setterA) {
        this.setterA = setterA;
    }

    @Autowired
    public void setSetterB(SetterB setterB) {
        this.setterB = setterB;
    }



    @RequestMapping("/test2")
    @ResponseBody
    public String testSetter() {
        System.out.println(setterA.toString());
        System.out.println(setterB.toString());
        return "Setter Success";
    }
}
