package com.royao.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.royao.db.BaseDao;
import com.royao.model.Dkiting;

public interface DkitingMapper extends BaseDao<Dkiting>{

	Integer plistWithPageCount(Dkiting kiting);

	List<Dkiting> plistWithPage(Dkiting t);

	public Integer queryClearCount( Map map ) throws SQLException;
	public List<Map> queryClear( Map map ) throws  SQLException;

	public List<Map> queryClearDetailByStoreId(Map map )throws  SQLException;
	public Long queryClearDetailCountByStoreId(Map map )throws  SQLException;


}
