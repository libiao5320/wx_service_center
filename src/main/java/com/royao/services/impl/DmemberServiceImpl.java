/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */


package com.royao.services.impl;


import com.royao.commons.enums.LogsMethod;
import com.royao.mapper.DmemberMapper;
import com.royao.model.DbalanceLogs;
import com.royao.model.Dmember;
import com.royao.model.Order;
import com.royao.services.base.impl.BaseServiceImpl;
import com.royao.services.inface.DbalanceLogsService;
import com.royao.services.inface.DmemberService;
import com.royao.services.inface.DorderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service("memberServiceImpl")
public class DmemberServiceImpl extends BaseServiceImpl<Dmember> implements DmemberService {

    @Autowired
    private DmemberMapper dmemberMapper;
    
	@Autowired
	private  DbalanceLogsService dbalancelogsService;
	
	@Autowired
	private DorderService dorderService;


    public int save(Dmember dmember) throws Exception {
        return dmemberMapper.save(dmember);
    }

    public int update(Dmember dmember) throws Exception {
        return dmemberMapper.update(dmember);
    }

    public int delete(Long id) throws Exception {
        return dmemberMapper.delete(id);
    }

    public Dmember queryById(Long id) throws Exception {
        return dmemberMapper.queryById(id);
    }

    public List<Dmember> queryByCondtion(Map map) throws Exception {
        return dmemberMapper.queryByCondtion(map);
    }

    public List<Dmember> queryAll() throws Exception {
        return dmemberMapper.queryAll();
    }

    public List<Dmember> listWithPage(Dmember t) throws Exception {
        return this.dmemberMapper.listWithPage(t);
    }

    public boolean register(Dmember dmember) throws Exception {
        return  dmemberMapper.register(dmember) > 0 ?true:false;
    }

    public Dmember queryByWxCode(String wxCode) throws Exception {

        return dmemberMapper.queryByWxCode(wxCode);
    }

    /**
     * 预存款扣款公共方法
     * memberId 会员id
     * pdAmount 扣款总额
     * 
     * type 1普通付款 2支付余款 
     * 
     */
	public String setJianAccountUtil(int type,Map<String,Object> map) throws Exception {
		
		String result="FILE";
		Dmember dmember=new Dmember();
		DbalanceLogs dblog=new DbalanceLogs();
		
		Long memberId=Long.parseLong(map.get("memberId")+"");//会员id
		dmember=dmemberMapper.queryById(memberId);//获得会员信息
	 	Long dqkyye= dmember.getAvailablePredeposit();//当前可以会员余额
	 	Long dqdjye= dmember.getFreezePredeposit();//当前冻结会员余额
		Long freezeAmount=Long.parseLong(map.get("frozenAmount")+"");//冻结总金额
		Long pdAmount=Long.parseLong(map.get("pdAmount")+"");//扣款总金额
		if(type==1){//普通付款
			
			/**set 会员信息**/
			//扣除 支付金额 和 冻结金额
			dmember.setAvailablePredeposit(pdAmount+freezeAmount);//需要  扣款的总金额 -
			dmember.setFreezePredeposit(freezeAmount);;//需要  冻结的总金额 +
			
			/**set 账户流水信息**/
			dblog.setMemberId(dmember.getMemberId());
			dblog.setAmount(pdAmount);
			dblog.setBalance(dqkyye);//扣款前可用余额

			dblog.setState(2);//支付成功
			dblog.setSn(map.get("paySn")+"");//支付单号
			dblog.setMethod(LogsMethod.GST);//消费
			dblog.setExplain(map.get("explain")+"");//说明
			//（可用余额-扣款余额）+冻结余额
			dblog.setCurrentBalance((dqkyye
					- pdAmount)+dqdjye);//所剩余额
		
		}else if(type == 2){//付尾款
			dmember.setAvailablePredeposit(0L);//需要  扣款的总金额 - *可用余额值*
			freezeAmount=freezeAmount-(freezeAmount*2);//为负数
			dmember.setFreezePredeposit(freezeAmount);;//需要  冻结的总金额 +  *冻结余额值*
			
			/**set 账户流水信息**/
			dblog.setMemberId(dmember.getMemberId());
			dblog.setAmount(pdAmount);
			dblog.setBalance(dqkyye);//扣款前可用余额

			dblog.setState(2);//支付成功
			dblog.setSn(map.get("paySn")+"");//支付单号
			dblog.setMethod(LogsMethod.GST);//付余款
			dblog.setExplain(map.get("explain")+"");//说明
			//（可用余额-扣款余额）+冻结余额
			dblog.setCurrentBalance((dqkyye
					- pdAmount)+dqdjye);//所剩余额
		}
		try {
			//改账户金额
			int it=dmemberMapper.updateDmember(dmember);
			//增加账户流水记录
			dbalancelogsService.save(dblog);
			
			result="SUCCESS";
		} catch (Exception e) {
			logger.error("会员id："+memberId+"[]流水插入失败：");
		}

		return result;
	}

	public Dmember queryDetailById(Long memberId) throws SQLException{
		return this.dmemberMapper.queryDetailById(memberId);
	}

	public Integer listWithPageCount(Dmember member) {
		return this.dmemberMapper.listWithPageCount(member);
	}

	public List<Dmember> queryBySaveings(Order or) throws SQLException {
		return this.dmemberMapper.queryBySaveings(or);
	}

	public Long queryBySaveingsCount(Order or) throws SQLException {
		return this.dmemberMapper.queryBySaveingsCount(or);
	}
}