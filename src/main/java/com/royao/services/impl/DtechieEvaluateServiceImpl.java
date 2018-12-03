


package com.royao.services.impl;


import com.royao.mapper.DtechieEvaluateMapper;
import com.royao.model.DtechieEvaluate;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DtechieEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("dtechieEvaluateService")
public class DtechieEvaluateServiceImpl extends BaseServiceImpl<DtechieEvaluate> implements DtechieEvaluateService {
	
		@Autowired
		private DtechieEvaluateMapper dtechieEvaluateMapper = null;



		public int save(DtechieEvaluate dtechieEvaluate) throws Exception {
        return dtechieEvaluateMapper.save(dtechieEvaluate);
		}

		public int update(DtechieEvaluate dtechieEvaluate) throws Exception {
        return dtechieEvaluateMapper.update(dtechieEvaluate);
		}

		public int delete(Long id) throws Exception {
       return dtechieEvaluateMapper.delete(id);
		}

	     public DtechieEvaluate queryById(Long id) throws Exception {
         return dtechieEvaluateMapper.queryById(id);
         }

		public List<DtechieEvaluate> queryByCondtion(Map map) throws Exception {
        return dtechieEvaluateMapper.queryByCondtion(map);
		}

		public List<DtechieEvaluate> queryAll() throws Exception {
		   return dtechieEvaluateMapper.queryAll();
		}

	public List<DtechieEvaluate> listWithPage(DtechieEvaluate dtechieEvaluate) throws Exception {
		return dtechieEvaluateMapper.listWithPage(dtechieEvaluate);
	}


}