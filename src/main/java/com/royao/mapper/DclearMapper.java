package com.royao.mapper;

import com.royao.db.BaseDao;
import com.royao.model.Dclear;

import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by libia on 2016/2/23.
 */
public interface DclearMapper extends BaseDao<Dclear> {


        public int addClearOrder(Map map) throws SQLException;

		public Integer listWithPageCount(Dclear clear);

		public Integer countUnClear(Dclear clear);

        public Dclear dealClear( Map map ) throws SQLException;

        public List queryClear (Map map) throws SQLException ;
        public Integer queryClearCount (Map map) throws SQLException ;
        public List queryClearOrder (Map params ) throws SQLException;
        public Integer queryClearOrderCount (Map params ) throws SQLException;
        public Integer  saveDealClear (Dclear dclear) throws SQLException;

}
