/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DeventImageMapper;
import com.royao.model.DeventImage;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DeventImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("eventImageService")
public class DeventImageServiceImpl extends BaseServiceImpl<DeventImage> implements DeventImageService {

    @Autowired
    private DeventImageMapper deventImageMapper;


    public int save(DeventImage deventImage) throws Exception {
        return deventImageMapper.save(deventImage);
    }

    public int update(DeventImage deventImage) throws Exception {
        return deventImageMapper.update(deventImage);
    }

    public int delete(Long id) throws Exception {
        return deventImageMapper.delete(id);
    }

    public DeventImage queryById(Long id) throws Exception {
        return deventImageMapper.queryById(id);
    }

    public List<DeventImage> queryByCondtion(Map map) throws Exception {
        return deventImageMapper.queryByCondtion(map);
    }

    public List<DeventImage> queryAll() throws Exception {
        return deventImageMapper.queryAll();
    }

    public List<DeventImage> listWithPage(DeventImage t) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


    public List queryHomeEventImgage() {
        return deventImageMapper.queryHomeEventImgage();
    }

	public Long deleteByEventId(Long id) {
		return deventImageMapper.deleteByEventId(id);
	}

	public List<DeventImage> findList(DeventImage image) {
		return this.deventImageMapper.findList(image);
	}
}