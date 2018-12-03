package com.royao.commons.enums;

public enum KitingStatus {

	
	HANDLE_OK{
		public String getName(){
			return "处理成功";
		}
	},
	AUDIT{
		public String getName(){
			return "审核中";
		}
	},
	FAIL{
		public String getName(){
			return "提现失败";
		}
	},
	REJECT{
		public String getName(){
			return "提现拒绝";
		}
	};
	
	public abstract String getName();
}
