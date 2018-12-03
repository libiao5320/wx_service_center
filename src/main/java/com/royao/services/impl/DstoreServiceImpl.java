/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.common.Constants;
import com.royao.commons.enums.StoreStatus;
import com.royao.mapper.DstoreMapper;
import com.royao.model.Dstore;
import com.royao.model.Order;
import com.royao.model.base.PageObject;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DstoreService;
import com.royao.util.PositionUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("storeServiceImpl")
public class DstoreServiceImpl extends BaseServiceImpl<Dstore> implements DstoreService {

    @Autowired
    private DstoreMapper dstoreMapper;


    public int save(Dstore dstore) throws Exception {
        return dstoreMapper.save(dstore);
    }

    public int update(Dstore dstore) throws Exception {
        return dstoreMapper.update(dstore);
    }

    public int delete(Long id) throws Exception {
        return dstoreMapper.delete(id);
    }

    public Dstore queryById(Long id) throws Exception {
        return dstoreMapper.queryById(id);
    }

    public List<Dstore> queryByCondtion(Map map) throws Exception {
        return dstoreMapper.queryByCondtion(map);
    }

    public List<Dstore> queryAll() throws Exception {
        return dstoreMapper.queryAll();
    }

	public List<Dstore> listWithPage(Dstore t) throws Exception {
		return dstoreMapper.listWithPage(t);
	}

	public Dstore queryDetailById(Long id) {
		return this.dstoreMapper.queryDetailById(id);
	}

	public List<Dstore> getNearbyStore(Double x, Double y,Map<?, ?> params) {
		PageObject pageObject = new PageObject();
        pageObject.setPageNo(Integer.parseInt(params.get("pageNo").toString()));
		Map positionMap = PositionUtil.getAround(x,y, Constants.radius);//地址信息
		positionMap.put("pageInfo", pageObject);//分页信息
		if(StringUtils.isNotBlank(params.get("classId")+"")){
			positionMap.put("classId", Long.parseLong(params.get("classId").toString()));//店铺分类
		}else{
			positionMap.put("classId", null);//店铺分类
		}
		positionMap.put("distanceS", Integer.parseInt(params.get("distanceS").toString()));//地址起始位置
		positionMap.put("distanceE", Integer.parseInt(params.get("distanceE").toString()));//地址结束位置
		positionMap.put("search", params.get("search"));//搜索信息
		positionMap.put("storeState", 1);//开启状态
		positionMap.put("status", StoreStatus.normal);//正常状态
		
		return this.dstoreMapper.getNearbyStore(positionMap);
	}

	public List<Object> getStoreListByName(Dstore store) {
		return this.dstoreMapper.getStoreListByName(store);
	}

	public List<Object> getStoreByName(Dstore store) {
		return this.dstoreMapper.getStoreByName(store);
	}

	public List<Map<?, ?>> indexList(Order or) {
		return this.dstoreMapper.indexList(or);
	}

	public Long queryCount() {
		return this.dstoreMapper.queryCount();
	}

	public Dstore queryDetail(Long storeId) {
		return this.dstoreMapper.queryDetail(storeId);
	}

	public List<Dstore> queryAlls(Map<String,Object> state) {
		return this.dstoreMapper.queryAlls(state);
	}

	public Long queryAllsCount(Map<String,Object> state) {
		return this.dstoreMapper.queryAllsCount(state);
	}

	public Dstore queryByLoginPhone(String phone) {
		return this.dstoreMapper.queryByLoginPhone(phone);
	}

	public Long insert(Dstore store) {
		
		this.dstoreMapper.insert(store);
		
		return store.getStoreId();
	}

	public void updateByMap(Map<String, String> map) {
		this.dstoreMapper.updateByMap(map);
	}

	public Map getStoreDetailById(Long id) {
		return this.dstoreMapper.getStoreDetailById(id);
	}

	public long countSalesById(long storeId) {
		return this.dstoreMapper.countSalesById(storeId);
	}

	public long countAccountById(long storeId) {
		return this.dstoreMapper.countAccountById(storeId);
	}
}