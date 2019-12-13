package com.work.ggr.dbsync.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : gr
 * @date : 2019/11/22 17:49
 */
@Service("syncServiceImpl")
public class SyncServiceImpl {

	@Qualifier("mainDS")
	@Autowired
	private DataSource mainDs;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	/**
	 * 根据数据源获取当前数据库的所有表名
	 *
	 * @param dataSource
	 * @return
	 */
	public List<String> getTablesName(DataSource dataSource) {
		List<String> list = null;
		try {
			conn = dataSource.getConnection();
			list = new ArrayList();
			String sql = " show tables";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(String.valueOf(rs.getObject(1)));
			}
			conn.close();
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public String getTableDesc(String tablename, DataSource dataSource) {
		String desc = "";
		String sql = "show create table " + tablename;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String.valueOf(rs.getObject(1));//tablename
				desc = String.valueOf(rs.getObject(2));
			}
			conn.close();
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return desc;
	}

	public List getData(DataSource dataSource, String tablename) {
		List result = new ArrayList();
		try {
			String sql = "select * from " + tablename;
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsm = ps.getMetaData();
			int columncount = rsm.getColumnCount();
			while (rs.next()) {
				List list = new ArrayList();
				for (int i = 1; i <= columncount; i++) {
					list.add(rs.getObject(i));
				}
				result.add(list);
			}
			ps.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public void initTable(DataSource dataSource, String desc) {
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(desc);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void insertData(DataSource dataSource, String tablename) {
		String sql = "";
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeQuery();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
