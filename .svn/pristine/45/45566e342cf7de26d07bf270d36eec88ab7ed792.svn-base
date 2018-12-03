/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.common.Constants;
import com.royao.commons.enums.YN;
import com.royao.mapper.DgoodsMapper;
import com.royao.mapper.DgoodsSetMapper;
import com.royao.model.Dgoods;
import com.royao.model.DgoodsSet;
import com.royao.model.GoodImg;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DgoodsService;
import com.royao.util.DateUtil;
import com.royao.util.PositionUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("goodsServiceImpl")
public class DgoodsServiceImpl extends BaseServiceImpl<Dgoods> implements DgoodsService {

    @Autowired
    private DgoodsMapper dgoodsMapper;
    @Autowired
    private DgoodsSetMapper dgoodsSetMapper;


    public int save(Dgoods dgoods) throws Exception {
        return dgoodsMapper.save(dgoods);
    }

    public int update(Dgoods dgoods) throws Exception {
        return dgoodsMapper.update(dgoods);
    }

    public int delete(Long id) throws Exception {
        return dgoodsMapper.delete(id);
    }

    public Dgoods queryById(Long id) throws Exception {
        return dgoodsMapper.queryById(id);
    }
    
    public Dgoods queryByIdByDetail(Long id) throws SQLException {
        return dgoodsMapper.queryByIdByDetail(id);
    }

    @SuppressWarnings("rawtypes")
	public List<Dgoods> queryByCondtion(Map map) throws Exception {
        return dgoodsMapper.queryByCondtion(map);
    }

    public List<Dgoods> queryAll() throws Exception {
        return dgoodsMapper.queryAll();
    }

    public List<Dgoods> listWithPage(Dgoods t) throws Exception {
        return dgoodsMapper.listWithPage(t);
    }


    public List search(Dgoods dgoods) throws Exception {
        return dgoodsMapper.search(dgoods);
    }

    public List getBestEvalGoods(double x ,double y) throws Exception {

        Map positionMap = PositionUtil.getAround(x,y, Constants.radius);

        return dgoodsMapper.getBestEvalGoods(positionMap);
    }

    public List queryByClass(Long classId) throws Exception {



        return dgoodsMapper.queryByClass(classId);
    }

    public List listWithPageAndConditon(Map params) throws Exception {
        return dgoodsMapper.listWithPageAndConditon(params);
    }

    public int batchAddGood(List list, List<String> imgs, DgoodsSet dgoodSet) throws Exception {

        int result = 0;

        for (int i  = 0 ; i <list.size() ; i++)
        {
            Dgoods dgoods  = ( Dgoods ) list.get(i);


            dgoods.setGoodsImage( imgs.get( 0 ) );
            if(  dgoodsMapper.save(dgoods) > 0 ) {


                for(int j = 0 ; j < imgs.size() ;j++) {
                    GoodImg goodImg =  new GoodImg();


                    if ( j == 0 )
                    goodImg .setIsMain(YN.Y);
                    else
                    goodImg.setIsMain( YN.N);

                    goodImg.setImg(imgs.get(j));
                    goodImg.setGoodId(dgoods.getGoodsId());
                    goodImg.setCreateDate(DateUtil.format("yyyy-MM-dd"));
                    dgoodsMapper.addImg(goodImg);
                }

                result++;
                
                long count = dgoodsSetMapper.listWithPageCount();
                dgoodSet.setSetId((int) (count+1));
                dgoodSet.setGoodsId(dgoods.getGoodsId()); 
                dgoodSet.setState(dgoods.getGoodsState());
                dgoodsSetMapper.save(dgoodSet);
            }
        }

        return result;


    }

	public List<Dgoods> listWithPageBy(Map params) throws Exception {
		return dgoodsMapper.listWithPageBy(params);
	}

	public int queryCountBy(Map params) throws Exception {
		// TODO Auto-generated method stub
		return dgoodsMapper.queryCountBy(params);
	}



    public boolean updateGoodsSalenumJia(Dgoods dgoods) {
		try {
			dgoodsMapper.updateGoodsSalenumJia(dgoods);
			return true;
		} catch (Exception e) {
			logger.error("修改商品信息异常： "+e.getMessage());
		}
		return false;
	}

	public int updateGood(List goodList) {
		int result = 0;

		Dgoods dgoods  = (Dgoods) goodList.get(0);
		String imagestr = dgoods.getGoodsImage();
		if(!"".equals(imagestr) && imagestr.indexOf("[") > -1 && imagestr.indexOf("]") > -1){
			imagestr = imagestr.substring(imagestr.indexOf("=")+1, imagestr.indexOf("]"));
		}
		dgoods.setGoodsImage(imagestr);
        try {
			if(  dgoodsMapper.update(dgoods) > 0 )
				result++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
	}

	public List getImgsById(long id) {
		return dgoodsMapper.getImgsById(id);
	}

	public int deleteImgByGoodId(Integer goodsId) {
		return dgoodsMapper.deleteImgByGoodId(goodsId);
	}

	public int addImg(GoodImg goodImg) {
		try {
			return dgoodsMapper.addImg(goodImg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int countByStoreAnd(Map params) {
		return dgoodsMapper.countByStoreAnd(params);
	}

	public List<Map> queryByStoreAnd(Map params) {
		return dgoodsMapper.queryByStoreAnd(params);
	}

	
}