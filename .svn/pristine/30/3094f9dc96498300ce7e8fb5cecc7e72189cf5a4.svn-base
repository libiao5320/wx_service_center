package com.royao.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royao.mapper.DmemberRemarkMapper;
import com.royao.model.DmemberRemark;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DmemberRemarkService;

@Service("memberRemarkService")
public class DmemberRemarkServiceImpl extends BaseServiceImpl<DmemberRemark> implements DmemberRemarkService {

	@Autowired
	private DmemberRemarkMapper memberRemarkMapper;
	
	public List<DmemberRemark> findList(DmemberRemark remark) {
		return this.memberRemarkMapper.findList(remark);
	}

	public int save(DmemberRemark t) throws Exception {
		return this.memberRemarkMapper.save(t);
	}

	public int update(DmemberRemark t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Long id) throws Exception {
		return this.memberRemarkMapper.delete(id);
	}

	public DmemberRemark queryById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DmemberRemark> queryByCondtion(Map map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DmemberRemark> queryAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DmemberRemark> listWithPage(DmemberRemark t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
