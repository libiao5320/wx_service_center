/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.inface;


import com.royao.model.DwxBanner;
import com.royao.services.base.BaseService;

import java.util.List;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public interface DwxBannerService extends BaseService<DwxBanner> {


    public List<DwxBanner> queryHomeBanner();

	public Integer listWithPageCount(DwxBanner dwxBanner);


}