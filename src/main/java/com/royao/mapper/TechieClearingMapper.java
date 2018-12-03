package com.royao.mapper;

import java.util.List;

import com.royao.model.TechieClearing;

public interface TechieClearingMapper {
	TechieClearing queryById(Long id);
	
	void insert(TechieClearing clearing);
	
	void update(TechieClearing clearing);
	
	List<TechieClearing> queryAll(TechieClearing clearing);
	
	Long queryAllByCount(TechieClearing clearing);
 }
