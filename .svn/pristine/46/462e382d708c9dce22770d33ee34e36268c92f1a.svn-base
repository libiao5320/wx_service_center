package com.royao.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royao.mapper.DstoreTextMapper;
import com.royao.model.DstoreText;
import com.royao.services.inface.DstoreTextService;

@Service("storeTextService")
public class DstoreTextServiceImpl implements DstoreTextService {

	@Autowired
	private DstoreTextMapper storeTextMapper;

	public DstoreText queryById(Long id) throws Exception {
		return this.storeTextMapper.queryById(id);
	}

	public void update(DstoreText text) {
		this.storeTextMapper.update(text);
	}

	public void insert(DstoreText text) {
		this.storeTextMapper.insert(text);
	}

	public void delete(Long id) {
		this.storeTextMapper.delete(id);
	}

}
