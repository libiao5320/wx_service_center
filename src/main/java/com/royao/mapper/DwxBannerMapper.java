/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.royao.mapper;


import com.royao.db.BaseDao;
import com.royao.model.DwxBanner;

import org.springframework.stereotype.Component;

import java.util.List;


public interface DwxBannerMapper extends BaseDao<DwxBanner> {

    public List<DwxBanner> queryHomeBanner();

	public Integer listWithPageCount();

}
