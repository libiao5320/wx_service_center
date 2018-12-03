


package com.royao.services.impl;


import com.royao.mapper.DstoreExtendMapper;
import com.royao.model.DstoreExtend;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DstoreExtendService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("storeExtendService")
public class DstoreExtendServiceImpl extends BaseServiceImpl<DstoreExtend> implements DstoreExtendService {

    @Autowired
    private DstoreExtendMapper dstoreExtendMapper;


    public int save(DstoreExtend dstoreExtend) throws Exception {
        return dstoreExtendMapper.save(dstoreExtend);
    }

    public int update(DstoreExtend dstoreExtend) throws Exception {
        return dstoreExtendMapper.update(dstoreExtend);
    }

    public int delete(Long id) throws Exception {
        return dstoreExtendMapper.delete(id);
    }

    public DstoreExtend queryById(Long id) throws Exception {
        return dstoreExtendMapper.queryById(id);
    }

    public List<DstoreExtend> queryByCondtion(Map map) throws Exception {
        return dstoreExtendMapper.queryByCondtion(map);
    }

    public List<DstoreExtend> queryAll() throws Exception {
        return dstoreExtendMapper.queryAll();
    }

    public List<DstoreExtend> listWithPage(DstoreExtend t) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


    public DstoreExtend queryByStoreId(Long storeId) throws Exception {
        return dstoreExtendMapper.queryByStoreId(storeId);
    }

	public void updateStoreId(DstoreExtend extend) {
		this.dstoreExtendMapper.updateStoreId(extend);
	}

	public void deleteBystoreId(Long storeId) {
		this.dstoreExtendMapper.deleteBystoreId(storeId);
	}
}