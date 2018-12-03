


package com.royao.services.impl;


import com.royao.mapper.DtechieEvaluateImageMapper;
import com.royao.model.DtechieEvaluateImage;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DtechieEvaluateImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("dtechieEvaluateImageService")
public class DtechieEvaluateImageServiceImpl extends BaseServiceImpl<DtechieEvaluateImage> implements DtechieEvaluateImageService {
	
		@Autowired
		private DtechieEvaluateImageMapper dtechieEvaluateImageMapper = null;



		public int save(DtechieEvaluateImage dtechieEvaluateImage) throws Exception {
        return dtechieEvaluateImageMapper.save(dtechieEvaluateImage);
		}

		public int update(DtechieEvaluateImage dtechieEvaluateImage) throws Exception {
        return dtechieEvaluateImageMapper.update(dtechieEvaluateImage);
		}

		public int delete(Long id) throws Exception {
       return dtechieEvaluateImageMapper.delete(id);
		}

	     public DtechieEvaluateImage queryById(Long id) throws Exception {
         return dtechieEvaluateImageMapper.queryById(id);
         }

		public List<DtechieEvaluateImage> queryByCondtion(Map map) throws Exception {
        return dtechieEvaluateImageMapper.queryByCondtion(map);
		}

		public List<DtechieEvaluateImage> queryAll() throws Exception {
		   return dtechieEvaluateImageMapper.queryAll();
		}

		public List<DtechieEvaluateImage> listWithPage(DtechieEvaluateImage dtechieEvaluateImage) throws Exception {
		return null;
		}


}