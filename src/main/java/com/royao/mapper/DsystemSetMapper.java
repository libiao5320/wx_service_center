/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.royao.mapper;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.royao.db.BaseDao;
import com.royao.model.DsystemSet;


@Component
public interface DsystemSetMapper extends BaseDao<DsystemSet>{
		DsystemSet queryByKey(String s_key);
		 public int updateValue(DsystemSet dsystemSet) throws SQLException;
		List<DsystemSet> list(DsystemSet systemSet);
		
}
