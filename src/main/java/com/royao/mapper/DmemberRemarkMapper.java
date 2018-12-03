/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;


import java.util.List;

import com.royao.db.BaseDao;
import com.royao.model.DmemberRemark;

public interface DmemberRemarkMapper extends BaseDao<DmemberRemark> {

	List<DmemberRemark> findList(DmemberRemark remark);

}
