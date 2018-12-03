package com.royao.services.inface;

import java.util.List;

import com.royao.model.DmemberRemark;
import com.royao.services.base.BaseService;

public interface DmemberRemarkService extends BaseService<DmemberRemark>{

	List<DmemberRemark> findList(DmemberRemark remark);

}
