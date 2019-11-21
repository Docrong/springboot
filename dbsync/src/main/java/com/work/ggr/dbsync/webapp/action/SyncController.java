package com.work.ggr.dbsync.webapp.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : gr
 * @date : 2019/11/21 8:56
 */
@RestController
public class SyncController {
    @Autowired
    @Qualifier("mainDS")
    DataSource mainDS;
    @Autowired
    @Qualifier("backupDS")
    DataSource backupDS;
    private Log log = LogFactory.getLog(this.getClass());

    @RequestMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response) {
        log.info(mainDS);
        log.info(backupDS);
        if (false) {
            return "fail";
        }
        return "success";
    }

    public Map initDsec(){

        return new HashMap();
    }
}
