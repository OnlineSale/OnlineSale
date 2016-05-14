package com.shop.bean;

public enum MemberLevel {

	CONSUMER_VIP("CONSUMER_VIP"), XCONSUMER("XCONSUMER"), 
	XCONNSUMER_VIP("XCONNSUMER_VIP"), CITY_CARRIEROPERATOR("CITY_CARRIEROPERATOR"), 
	CITY_UNION_BUSINESS("CITY_UNION_BUSINESS"), AREA_COPARTNER("AREA_COPARTNER");
	
	private String  level;
	
	private MemberLevel(String level) {
		this.level = level;
	}
	
	public String getLevel() {
		return level;
	}
}
