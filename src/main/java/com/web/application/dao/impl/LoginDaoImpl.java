package com.web.application.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.application.dao.LoginDao;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
    @Qualifier("jdbcTempPrimary")
    private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Map<String, Object> queryLogin(String userId) {
		StringBuffer sql=new StringBuffer();
		sql.append("select p.pk_psndoc ,s.cuserid userId,s.user_name username,s.user_code usercode ");
		sql.append(" from bd_psndoc p,sm_user s where p.pk_psndoc=s.pk_psndoc ");
		sql.append(" and p.code=:userId");
		System.out.println(jdbcTemplate);
 		Map<String,String> param=new HashMap<String,String>();
 		param.put("userId", userId);
		Map<String,Object> loginInfo=jdbcTemplate.queryForMap(sql.toString(),param);
	
		return loginInfo;
	}

}
