/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DevaluateImageMapper;
import com.royao.model.DevaluateImage;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DevaluateImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("evaluateImageServiceImpl")
public class DevaluateImageServiceImpl extends BaseServiceImpl<DevaluateImage> implements DevaluateImageService {

    @Autowired
    private DevaluateImageMapper devaluateImageMapper;


    public int save(DevaluateImage devaluateImage) throws Exception {
        return devaluateImageMapper.save(devaluateImage);
    }

    public int update(DevaluateImage devaluateImage) throws Exception {
        return devaluateImageMapper.update(devaluateImage);
    }

    public int delete(Long id) throws Exception {
        return devaluateImageMapper.delete(id);
    }

    public DevaluateImage queryById(Long id) throws Exception {
        return devaluateImageMapper.queryById(id);
    }

    public List<DevaluateImage> queryByCondtion(Map map) throws Exception {
        return devaluateImageMapper.queryByCondtion(map);
    }

    public List<DevaluateImage> queryAll() throws Exception {
        return devaluateImageMapper.queryAll();
    }

    public List<DevaluateImage> listWithPage(DevaluateImage t)
            throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


}