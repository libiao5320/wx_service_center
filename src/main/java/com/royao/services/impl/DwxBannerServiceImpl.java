/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.mapper.DwxBannerMapper;
import com.royao.model.DwxBanner;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DwxBannerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("wxBannerService")
public class DwxBannerServiceImpl extends BaseServiceImpl<DwxBanner> implements DwxBannerService {

    @Autowired
    private DwxBannerMapper dwxBannerMapper;


    public int save(DwxBanner dwxBanner) throws Exception {
        return dwxBannerMapper.save(dwxBanner);
    }

    public int update(DwxBanner dwxBanner) throws Exception {
        return dwxBannerMapper.update(dwxBanner);
    }

    public int delete(Long id) throws Exception {
        return dwxBannerMapper.delete(id);
    }

    public DwxBanner queryById(Long id) throws Exception {
        return dwxBannerMapper.queryById(id);
    }

    public List<DwxBanner> queryByCondtion(Map map) throws Exception {
        return dwxBannerMapper.queryByCondtion(map);
    }

    public List<DwxBanner> queryAll() throws Exception {
        return dwxBannerMapper.queryAll();
    }

    public List<DwxBanner> listWithPage(DwxBanner t) throws Exception {
        // TODO Auto-generated method stub
        return dwxBannerMapper.listWithPage(t);
    }


    public List<DwxBanner> queryHomeBanner() {

        return dwxBannerMapper.queryHomeBanner();
    }

	public Integer listWithPageCount(DwxBanner dwxBanner) {
		return dwxBannerMapper.listWithPageCount();
	}
}