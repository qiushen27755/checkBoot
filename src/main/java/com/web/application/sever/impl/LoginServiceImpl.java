package com.web.application.sever.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.application.dao.LoginDao;
import com.web.application.sever.LoginService;
import com.web.application.tools.CommenRes;
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDao dao;
	
	@Override
	public Object DingTalkSso(Map<String, Object> param) {
		CommenRes msg=new CommenRes(); 
		String userId=(String) param.get("userId");
		Map<String,Object> loginRes=dao.queryLogin(userId);
		
		Map<String,Object> ret=new HashMap<String,Object>();
 		for(String key : loginRes.keySet()) {
 			String key1=key.toLowerCase();
 			Object value=loginRes.get(key);
 			ret.put(key1, value);
 		}
		msg.setData(ret);
		return msg;
	}

}
