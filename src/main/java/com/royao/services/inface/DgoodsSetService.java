/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.inface;


import java.util.List;

import com.royao.model.DgoodsSet;
import com.royao.services.base.BaseService;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public interface DgoodsSetService extends BaseService<DgoodsSet> {

	DgoodsSet queryByGoodId(long parseLong);


}