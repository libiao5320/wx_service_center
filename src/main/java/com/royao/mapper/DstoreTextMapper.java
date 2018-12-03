package com.royao.mapper;

import com.royao.model.DstoreText;

public interface DstoreTextMapper {

	DstoreText queryById(Long id);
	
	void update(DstoreText text);
	
	void insert(DstoreText text);
	
	void delete(Long id);
}
