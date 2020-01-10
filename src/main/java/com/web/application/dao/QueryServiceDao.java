package com.web.application.dao;

import java.util.List;
import java.util.Map;

public interface QueryServiceDao {
	
	  //pay 列表
	  List<Map<String, Object>> queryPayList(String code, int state);
	  //pay 初始化明细
	  Map<String, Object> queryPayListInfo(String pk_pay);
	  //pay 执行后的明细(处理中,处理完成)
	  Map<String, Map<String, Object>> queryPayListInfoed(String pk_pay);
 
}
