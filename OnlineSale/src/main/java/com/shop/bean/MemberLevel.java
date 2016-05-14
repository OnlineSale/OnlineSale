package com.shop.bean;

public enum MemberLevel {

	CONSUMER_VIP(1, "CONSUMER_VIP"), XCONSUMER(2, "XCONSUMER"), 
	XCONNSUMER_VIP(3, "XCONNSUMER_VIP"), CITY_CARRIEROPERATOR(4, "CITY_CARRIEROPERATOR"), 
	CITY_UNION_BUSINESS(5, "CITY_UNION_BUSINESS"), AREA_COPARTNER(6, "AREA_COPARTNER");
	
	private int levelInt;
	private String  level;
	
	private MemberLevel(int levelInt, String level) {
		this.levelInt = levelInt;
		this.level = level;
	}
	
	public int getLevelInt() {
		return levelInt;
	}
	
	public String getLevel() {
		return level;
	}
}
