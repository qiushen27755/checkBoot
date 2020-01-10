package com.web.application.dao;

import java.util.Map;

import org.springframework.cache.annotation.Cacheable;

import com.web.application.tools.Constand;

 
public interface LoginDao {
	
	@Cacheable(value=Constand.CACHE_DB,key="#p0")
	Map<String, Object> queryLogin(String userId);

}
