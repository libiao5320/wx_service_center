/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;


import com.royao.db.BaseDao;
import com.royao.model.DstoreExtend;
import org.springframework.stereotype.Component;

import java.sql.SQLException;


public interface DstoreExtendMapper extends BaseDao<DstoreExtend> {

    public DstoreExtend queryByStoreId(Long storeId) throws SQLException;
    
    public void updateStoreId(DstoreExtend extend);
    
    public void deleteBystoreId(Long storeId);
}
