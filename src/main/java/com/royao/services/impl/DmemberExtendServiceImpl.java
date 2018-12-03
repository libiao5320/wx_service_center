package com.royao.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.royao.mapper.DmemberExtendMapper;
import com.royao.model.Dkiting;
import com.royao.model.DmemberExtend;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DmemberExtendService;

@Service("memberExtendService")
public class DmemberExtendServiceImpl extends BaseServiceImpl<DmemberExtend> implements DmemberExtendService {

	@Autowired
	private DmemberExtendMapper memberExtendMapper; 
	
	public int save(DmemberExtend t) throws Exception {
		return this.memberExtendMapper.save(t);
	}

	public int update(DmemberExtend t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public DmemberExtend queryById(Long id) throws Exception {
		return this.memberExtendMapper.queryById(id);
	}

	public List<DmemberExtend> queryByCondtion(Map map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DmemberExtend> queryAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DmemberExtend> listWithPage(DmemberExtend t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
