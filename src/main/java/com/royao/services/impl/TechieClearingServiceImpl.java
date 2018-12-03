package com.royao.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royao.mapper.TechieClearingMapper;
import com.royao.model.TechieClearing;
import com.royao.services.inface.TechieClearingService;

@Service("techieClearingService")
public class TechieClearingServiceImpl implements TechieClearingService {
	
	@Autowired
	private TechieClearingMapper  clearingMapper;
	
	public TechieClearing queryById(Long id) {
		return this.clearingMapper.queryById(id);
	}

	public void insert(TechieClearing clearing) {
		this.clearingMapper.insert(clearing);
	}

	public void update(TechieClearing clearing) {
		this.clearingMapper.update(clearing);
	}

	public List<TechieClearing> queryAll(TechieClearing clearing) {
		return this.clearingMapper.queryAll(clearing);
	}

	public Long queryAllByCount(TechieClearing clearing) {
		return this.clearingMapper.queryAllByCount(clearing);
	}

}
