/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DstoreManagerMapper;
import com.royao.model.DstoreManager;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DstoreManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("storeManagerService")
public class DstoreManagerServiceImpl extends BaseServiceImpl<DstoreManager> implements DstoreManagerService {

    @Autowired
    private DstoreManagerMapper dstoreManagerMapper;


    public int save(DstoreManager dstoreManager) throws Exception {
        return dstoreManagerMapper.save(dstoreManager);
    }

    public int update(DstoreManager dstoreManager) throws Exception {
        return dstoreManagerMapper.update(dstoreManager);
    }

    public int delete(Long id) throws Exception {
        return dstoreManagerMapper.delete(id);
    }

    public DstoreManager queryById(Long id) throws Exception {
        return dstoreManagerMapper.queryById(id);
    }

    public List<DstoreManager> queryByCondtion(Map map) throws Exception {
        return dstoreManagerMapper.queryByCondtion(map);
    }

    public List<DstoreManager> queryAll() throws Exception {
        return dstoreManagerMapper.queryAll();
    }

    public List<DstoreManager> listWithPage(DstoreManager t)
            throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

	public void updateManager(DstoreManager manager) {
		this.dstoreManagerMapper.updateManager(manager);
	}
	public DstoreManager queryByStoreId(Long storeId) {
		return this.dstoreManagerMapper.queryByStoreId(storeId);
	}
	public void deleteBySmsStoreId(Long id) {
		this.dstoreManagerMapper.deleteBySmsStoreId(id);
	}
}