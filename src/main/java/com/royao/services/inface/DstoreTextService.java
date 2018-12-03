package com.royao.services.inface;

import com.royao.model.DstoreText;


public interface DstoreTextService{

	DstoreText queryById(Long id)  throws Exception ;
	void update(DstoreText text);
	
	void insert(DstoreText text);
	
	void delete(Long id);
}
