/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */



package com.royao.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royao.mapper.DsystemSetMapper;
import com.royao.model.DsystemSet;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DsystemSetService;



@Service("dsystemSetService")
public class DsystemSetServiceImpl extends BaseServiceImpl<DsystemSet> implements DsystemSetService {
	
		@Autowired
		private DsystemSetMapper dsystemSetMapper;

		public int save(DsystemSet t) throws Exception {
			return this.dsystemSetMapper.save(t);
		}

		public int update(DsystemSet t) throws Exception {
			return this.dsystemSetMapper.update(t);
		}

		public int delete(Long id) throws Exception {
			return this.dsystemSetMapper.delete(id);
		}

		public DsystemSet queryById(Long id) throws Exception {
			return this.dsystemSetMapper.queryById(id);
		}

		public List<DsystemSet> queryByCondtion(@SuppressWarnings("rawtypes") Map map) throws Exception {
			return this.dsystemSetMapper.queryByCondtion(map);
		}

		public List<DsystemSet> queryAll() throws Exception {
			return this.dsystemSetMapper.queryAll();
		}

		public List<DsystemSet> listWithPage(DsystemSet t) throws Exception {
			return this.dsystemSetMapper.listWithPage(t);
		}

		public DsystemSet queryByKey(String s_key) {
			return this.dsystemSetMapper.queryByKey(s_key);
		}

		public int updateValue(DsystemSet dsystemSet) throws Exception {
			return dsystemSetMapper.updateValue(dsystemSet);
		}

}