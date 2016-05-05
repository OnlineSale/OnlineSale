package com.shop.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于格式化输出json 数据
 * @author chuankun   email:yichuankun@qq.com
 * 2016年4月18日 上午11:03:34
 *	TODO
 */
public class Message {

	/**
	 * 格式化返回数据
	 * @return
	 */
	public static Object getMessage(int code,String error,Object data){
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("code", code);
		map.put("error", error);
		map.put("data", data);
		return map;
	}
}
