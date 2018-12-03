


package com.royao.services.impl;


import com.royao.mapper.DtechieMapper;
import com.royao.model.Dtechie;
import com.royao.model.Order;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DtechieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service("dtechieService")
public class DtechieServiceImpl extends BaseServiceImpl<Dtechie> implements DtechieService {
	
		@Autowired
		private DtechieMapper dtechieMapper;



		public int save(Dtechie dtechie) throws Exception {
        return dtechieMapper.save(dtechie);
		}

		public int update(Dtechie dtechie) throws Exception {
        return dtechieMapper.update(dtechie);
		}

		public int delete(Long id) throws Exception {
       return dtechieMapper.delete(id);
		}

	     public Dtechie queryById(Long id) throws Exception {
         return dtechieMapper.queryById(id);
         }

		public List<Dtechie> queryByCondtion(Map map) throws Exception {
        return dtechieMapper.queryByCondtion(map);
		}

		public List<Dtechie> queryAll() throws Exception {
		   return dtechieMapper.queryAll();
		}

		public List<Dtechie> listWithPage(Dtechie dtechie) throws Exception {
			return this.dtechieMapper.listWithPage(dtechie);
		}


	public List queryHomeBestTechie() throws Exception {
		return dtechieMapper.queryHomeBestTechie();
	}

	public Dtechie findById(Long id) {
		return this.dtechieMapper.findById(id);
	}

	/**杨鑫*/
	public List<Dtechie> queryReward(Order or) throws SQLException {
		return this.dtechieMapper.queryReward(or);
	}

	public Long queryRewardCount(Order or) throws SQLException {
		return this.dtechieMapper.queryRewardCount(or);
	}
}