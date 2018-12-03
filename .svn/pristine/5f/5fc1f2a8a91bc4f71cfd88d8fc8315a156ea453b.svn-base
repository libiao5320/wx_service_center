package com.royao.services.base;

import com.royao.model.base.BaseEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by libia on 2015/12/31.
 */
public interface BaseService<T extends BaseEntity> {

    public int save(T t) throws Exception;

    public int update(T t) throws Exception;

    public int delete(Long id) throws Exception;

    public T queryById(Long id) throws Exception;

    public List<T> queryByCondtion(Map map) throws Exception;

    public List<T> queryAll() throws Exception;

    public List<T> listWithPage(T t) throws Exception;

}
