


package com.royao.services.impl;


import com.royao.mapper.DtechieGoodsMapper;
import com.royao.model.DtechieGoods;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DtechieGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dtechieGoodsService")
public class DtechieGoodsServiceImpl extends BaseServiceImpl<DtechieGoods> implements DtechieGoodsService {
	
		@Autowired
		private DtechieGoodsMapper dtechieGoodsMapper ;



		public int save(DtechieGoods dtechieGoods) throws Exception {
        return dtechieGoodsMapper.save(dtechieGoods);
		}

		public int update(DtechieGoods dtechieGoods) throws Exception {
        return dtechieGoodsMapper.update(dtechieGoods);
		}

		public int delete(Long id) throws Exception {
       return dtechieGoodsMapper.delete(id);
		}

	     public DtechieGoods queryById(Long id) throws Exception {
         return dtechieGoodsMapper.queryById(id);
         }

		public List<DtechieGoods> queryByCondtion(Map map) throws Exception {
        return dtechieGoodsMapper.queryByCondtion(map);
		}

		public List<DtechieGoods> queryAll() throws Exception {
		   return dtechieGoodsMapper.queryAll();
		}

	public List<DtechieGoods> listWithPage(DtechieGoods dtechieGoods) throws Exception {
		return null;
	}


}