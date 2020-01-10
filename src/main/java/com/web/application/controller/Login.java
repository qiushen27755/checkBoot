package com.web.application.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.application.sever.LoginService;

@RestController
@RequestMapping(value="/checkinfo")
public class Login {
	
	@Autowired
	LoginService server;
	
	@RequestMapping(value="ssoDingLogin", method = RequestMethod.POST)
	public Object LoginDing(@RequestBody Map<String,Object> param) {
		
		return server.DingTalkSso(param);
	}
}
