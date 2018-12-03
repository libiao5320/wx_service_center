package com.royao.commons.enums;

public enum RewardStatus {
		
	allowinvite{
		public String getName(){
			return "邀请注册";
		}
	},
	reward{
		public String getName(){
			return "打赏";
		}
	};
	
	public abstract String getName();
}
