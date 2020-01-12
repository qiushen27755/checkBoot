package com.web.application.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.application.dao.QueryServiceDao;

@Repository
public class QueryServuceDaoImpl implements QueryServiceDao{
	@Autowired
    @Qualifier("jdbcTempSencondary")
    private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> queryPayList(String code, int state) {
		String sql="select * from bank_rec where  status=:state";
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("code", code);
		condition.put("state", state);
 		List<Map<String,Object>> payList=jdbcTemplate.queryForList(sql,condition);
		return payList;
 	}

	@Override
	public Map<String,Object > queryPayListInfo(String pk_pay) {
 		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("pk_pay", pk_pay);		 
		String sql="select * from bank_rec where rec_code=:pk_pay";
		Map<String,Object> master=jdbcTemplate.queryForMap(sql.toString(),condition);
		Map<String,Object> map=new HashMap<String,Object>();
 			for(String key : master.keySet()) {
				map.put(key.toLowerCase(), master.get(key));
			}
 	 
 		return map;
	}

	@Override
	public Map<String, Map<String, Object>> queryPayListInfoed(String pk_pay) {
		Map<String,Map<String,Object>> payListInfoed=new HashMap<String,Map<String,Object>>();
		payListInfoed.put("master", queryPayListInfo(pk_pay));
 		Map<String,Object> condition=new HashMap<String,Object>();
 		condition.put("pk_pay", "~");
 		String certSql="select * from t_cert where pk_pay=:pk_pay"; // 略略 还没定
 		List<Map<String,Object>> certList=jdbcTemplate.queryForList(certSql,condition);
 		
 		for(Map<String,Object> map:certList) {
 			Map<String,Object> lowerMap=new HashMap<String,Object>();
 				for(String key:map.keySet()) {
 					lowerMap.put(key.toLowerCase(), map.get(key));
 				}
 			payListInfoed.put((String) map.get("pk_cert"), lowerMap);
 		}
 		return payListInfoed;
	}
}
