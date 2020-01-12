package com.web.application.sever.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.web.application.dao.QueryServiceDao;
import com.web.application.sever.QueryService;
import com.web.application.tools.CommenRes;
import com.web.application.tools.PageResult;

@Service
public class QueryServiceImpl implements QueryService{
	@Autowired
	QueryServiceDao dao;
	public Object payList(Map<String, Object> param) {
		PageResult pRes=new PageResult();
		String code=(String) param.get("code");
		int state=(int) param.get("state");
		List<Map<String, Object>> payList=dao.queryPayList(code,state);
		
		List<Map<String, Object>> data=new ArrayList<Map<String,Object>>();
		for(Map<String,Object> Map : payList) {
			Map<String,Object> flex=new HashMap<String,Object>();
			for(String key : Map.keySet()) {
				flex.put(key.toLowerCase(), Map.get(key));
			}
			data.add(flex);
 		}
		
		// ----分页--
		int offset=(int) param.get("offset"); //一页几行
		int index=(int) param.get("index");
 		//------校验
		if(offset>pRes.getLimit()) {
 			pRes.setStatusCode(300);
 			pRes.setMessage("超过限制:"+offset+">"+pRes.getLimit());
 			return pRes;
 		}
		//---------------分页-------
		int total=data.size(); //总长度
 		int pageTotal=(total%offset)==0 ? total/offset :(total/offset+1);//总页数
 		if((index+1)>pageTotal){ //
			data=null;
			pRes.setData(data);
		}
 		
 		if(offset*(index+1)>total){//最后一页的话
 			pRes.setData(data.subList((index)*offset, total));
		}else{
			pRes.setData(data.subList(index*offset, offset*(index+1)));
 		}
 		pRes.setPageSize(offset*(index+1)-index*offset);//当前行数
 		pRes.setTotal(total); //总行数
 		pRes.setPageTotal(pageTotal);//总页
 		pRes.setPageNum(index);//当前页
 		return pRes;
 	}
	
	
	@Override
	public Object payListInfo(Map<String, Object> param) {
		CommenRes payInfo=new CommenRes();
		String pk_pay=String.valueOf(param.get("pk_pay"));
		int status=(int) param.get("status");
		if(status==0) {
			Map<String,Object> payListInfo=dao.queryPayListInfo(pk_pay);
			
			
			payInfo.setData(payListInfo);
			return payInfo;
		}else {
			Map<String ,Map<String,Object>> payListInfo=dao.queryPayListInfoed(pk_pay);	
			JSONObject payListInfoed=new JSONObject();
			JSONArray arr=new JSONArray ();
			for(String key : payListInfo.get("master").keySet()) {
				payListInfoed.put(key, payListInfo.get("master").get(key));
			}
 			for(String f : payListInfo.keySet()) {
				if(f.equals("master"))  continue;
				JSONObject info=new JSONObject();
					for(String fs: payListInfo.get(f).keySet()) {
						info.put(fs, payListInfo.get(f).get(fs));
					}
					arr.add(info);
			}
			payListInfoed.put("cert", arr);
			payInfo.setData(payListInfoed);
			return payInfo;
		}
 	}
}
