package com.royao.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royao.mapper.DrewardMapper;
import com.royao.model.Dreward;
import com.royao.services.inface.DrewardService;

@Service("drewardService")
public class DrewardServiceImpl implements DrewardService {
	
	@Autowired
	private DrewardMapper rewardMapper;
	
	public Dreward queryById(Long id) {
		return this.rewardMapper.queryById(id);
	}

	public void insert(Dreward reward) {
		this.rewardMapper.insert(reward);
	}

	public void update(Dreward reward) {
		this.rewardMapper.update(reward);
	}

	public List<Dreward> queryAll(Dreward reward) {
		return this.rewardMapper.queryAll(reward);
	}

	public Long queryAllByCount(Dreward reward) {
		return this.rewardMapper.queryAllByCount(reward);
	}

}
