package com.work.ggr.dbsync.webapp.action;

import com.work.ggr.dbsync.service.impl.SyncServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	@Autowired
	private SyncServiceImpl service;

	@RequestMapping("/test")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		log.info(mainDS);
		log.info(backupDS);

		List<String> maintable = service.getTablesName(mainDS);
		List<String> backuptable = service.getTablesName(backupDS);
		log.info(maintable);
		log.info(backuptable);

		List<String> xinzeng = new ArrayList();//需要新增的表
		List<String> tongbu = new ArrayList();//需要数据同步的表
		for (String str : maintable) {
			if (backuptable.contains(str)) {
				tongbu.add(str);
			} else {
				xinzeng.add(str);
			}
		}
		log.info(xinzeng);
		log.info(tongbu);

		List<String> xinzengdesc = new ArrayList<String>();
		for (String tablename : xinzeng) {
			String desc = service.getTableDesc(tablename, mainDS);
			xinzengdesc.add(desc);
		}
        for (String sql:xinzengdesc) {//将备份库不存在的表初始化一下
            service.initTable(backupDS,sql);
        }
		log.info(xinzengdesc);
		for (String tablename : xinzeng) {
			List dataList = service.getData(mainDS, tablename);//获取表的数据

		}
        for (String tablename:tongbu) {
            List dataList = service.getData(mainDS, tablename);
        }
		return "success";
	}

	public Map initDsec() {

		return new HashMap();
	}
}
