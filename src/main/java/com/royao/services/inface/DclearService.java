package com.royao.services.inface;


import com.royao.model.Dclear;
import com.royao.services.base.BaseService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by libia on 2016/2/23.
 */
public interface DclearService extends BaseService<Dclear> {


        public boolean addClear(Map params ) throws Exception;
        public List queryClear (Map map) throws Exception ;

        public Dclear dealClear( Map map ) throws Exception;

        public Integer queryClearCount (Map map) throws Exception ;

		public Integer listWithPageCount(Dclear clear);

		public Integer countUnClear(Dclear clear);


        public List queryClearOrder (Map params) throws Exception;
        public Integer queryClearOrderCount (Map params) throws Exception;

        public boolean  saveDealClear (Dclear dclear) throws Exception;

}
