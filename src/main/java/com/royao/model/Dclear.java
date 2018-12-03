package com.royao.model;

import com.royao.model.base.BaseEntity;
import com.royao.util.MoneyUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * Created by libia on 2016/2/23.
 */
public class Dclear extends BaseEntity implements java.io.Serializable {


    /**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 4089140085569907808L;
	private Long id;
    private Long seriNo;
    private Long storeId;
    private String storeName;
    private Long clearFee;
    private String clearFeeDollar;
    private Long saleFee;
    private String saleFeeDollar;
    private Integer storeConfirm;
    private String confirmUser;
    private String confirmTime;
    private String clearTime;
    private String startTime;
    private String endTime;
    private Integer clearState;
    private String clearRemark;
    private Long clearUser;
    private String createTime;
    private String startCreateTime;//结算开始时间
    private String endCreateTime;//结算结束时间

    private String field;//查询条件，用于分页查询时的下拉条件
    
    private List<Dorder> orderList;
    
    private Integer orderCount;//该对账单的订单条数

    private String clearModel;
    private String cycleTime ;
    private Long realClearFee;
    private String realClearFeeDollar;



    public Integer getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}

	public String getStartCreateTime() throws ParseException {
    	if(StringUtils.isNotBlank(createTime)){
    		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//格式化对象
    		  Calendar calendar = Calendar.getInstance();//日历对象
    		  calendar.setTime(sdf.parse(createTime));//设置当前日期
    		  calendar.add(Calendar.MONTH, -1);//月份减一
    		  
    		  startCreateTime = sdf.format(calendar.getTime());
    	}
    	
		return startCreateTime;
	}

	public void setStartCreateTime(String startCreateTime) {
		this.startCreateTime = startCreateTime;
	}

	public String getEndCreateTime() throws ParseException {
		if(StringUtils.isNotBlank(createTime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//格式化对象
			endCreateTime = sdf.format(sdf.parse(createTime));
		}
		
		return endCreateTime;
	}

	public void setEndCreateTime(String endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public List<Dorder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Dorder> orderList) {
		this.orderList = orderList;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeriNo() {
        return seriNo;
    }

    public void setSeriNo(Long seriNo) {
        this.seriNo = seriNo;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getClearFee() {
    	if (this.clearFee == null && this.clearFeeDollar != null) {
            this.clearFee = MoneyUtil.getDollarToCent(this.clearFeeDollar);
        }
        return clearFee;
    }

    public void setClearFee(Long clearFee) {
        this.clearFee = clearFee;
    }

    public Long getSaleFee() {
    	if (this.saleFee == null && this.saleFeeDollar != null) {
            this.saleFee = MoneyUtil.getDollarToCent(this.saleFeeDollar);
        }
        return saleFee;
    }

    public void setSaleFee(Long saleFee) {
        this.saleFee = saleFee;
    }

    public String getClearFeeDollar() {
    	if (this.clearFeeDollar == null && this.clearFee != null) {
            this.clearFeeDollar = MoneyUtil.getCentToDollar(this.clearFee);
        }
		return clearFeeDollar;
	}

	public void setClearFeeDollar(String clearFeeDollar) {
		this.clearFeeDollar = clearFeeDollar;
	}

	public String getSaleFeeDollar() {
		if (this.saleFeeDollar == null && this.saleFee != null) {
            this.saleFeeDollar = MoneyUtil.getCentToDollar(this.saleFee);
        }
		return saleFeeDollar;
	}

	public void setSaleFeeDollar(String saleFeeDollar) {
		this.saleFeeDollar = saleFeeDollar;
	}

	public Integer getStoreConfirm() {
        return storeConfirm;
    }

    public void setStoreConfirm(Integer storeConfirm) {
        this.storeConfirm = storeConfirm;
    }

    public String getConfirmUser() {
        return confirmUser;
    }

    public void setConfirmUser(String confirmUser) {
        this.confirmUser = confirmUser;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getClearTime() {
        return clearTime;
    }

    public void setClearTime(String clearTime) {
        this.clearTime = clearTime;
    }

    public Integer getClearState() {
        return clearState;
    }

    public void setClearState(Integer clearState) {
        this.clearState = clearState;
    }

    public String getClearRemark() {
        return clearRemark;
    }

    public void setClearRemark(String clearRemark) {
        this.clearRemark = clearRemark;
    }

    public Long getClearUser() {
        return clearUser;
    }

    public void setClearUser(Long clearUser) {
        this.clearUser = clearUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getClearModel() {
        return clearModel;
    }

    public void setClearModel(String clearModel) {
        this.clearModel = clearModel;
    }

    public String getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(String cycleTime) {
        this.cycleTime = cycleTime;
    }

    public Long getRealClearFee() {
        return realClearFee;
    }

    public void setRealClearFee(Long realClearFee) {
        this.realClearFee = realClearFee;
    }



    public String getRealClearFeeDollar() {

        if (this.realClearFeeDollar == null && this.realClearFee != null) {
            this.realClearFeeDollar = MoneyUtil.getCentToDollar(this.realClearFee);
        }

        return realClearFeeDollar;
    }

    public void setRealClearFeeDollar(String realClearFeeDollar) {
        this.realClearFeeDollar = realClearFeeDollar;
    }


}
