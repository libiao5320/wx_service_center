package com.royao.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royao.mapper.DkitingMapper;
import com.royao.model.Dkiting;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DkitingService;

@Service("kitingService")
public class DkitingServiceImpl extends BaseServiceImpl<Dkiting> implements DkitingService{
	
	@Autowired
	private DkitingMapper kitingMapper;
		
	public int save(Dkiting t) throws Exception {
		
		return this.kitingMapper.save(t);
	}

	public int update(Dkiting t) throws Exception {
		
		return this.kitingMapper.update(t);
	}

	public int delete(Long id) throws Exception {
		
		return this.kitingMapper.delete(id);
	}

	public Dkiting queryById(Long id) throws Exception {
		return this.kitingMapper.queryById(id);
	}

	public List<Dkiting> queryByCondtion(@SuppressWarnings("rawtypes") Map map) throws Exception {
		return this.kitingMapper.queryByCondtion(map);
	}

	public List<Dkiting> queryAll() throws Exception {
		return this.kitingMapper.queryAll();
	}

	public List<Dkiting> listWithPage(Dkiting t) throws Exception {
		return this.kitingMapper.listWithPage(t);
	}
	
	public List<Dkiting> plistWithPage(Dkiting t) throws Exception {
		return this.kitingMapper.plistWithPage(t);
	}

	public Integer queryClearCount(Map map) throws Exception {
		return kitingMapper.queryClearCount(map);
	}

	public List<Map> queryClear(Map map) throws Exception {
		return kitingMapper.queryClear(map);
	}

	public List<Map> queryClearDetailByStoreId(Map map) throws Exception {
		return kitingMapper.queryClearDetailByStoreId(map);
	}

	public Integer plistWithPageCount(Dkiting kiting) throws Exception {
		return this.kitingMapper.plistWithPageCount(kiting);
	}

	public Long queryClearDetailCountByStoreId(Map map )throws  Exception
	{
		return this.kitingMapper.queryClearDetailCountByStoreId(map);
	}

}
