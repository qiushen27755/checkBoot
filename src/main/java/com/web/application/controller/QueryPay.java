package com.web.application.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.application.sever.QueryService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/checkSever")
public class QueryPay {
	
	@Autowired
	QueryService sever;
	
	@PostMapping("/payList")
	public Object payList(@RequestBody Map<String,Object> param) {
		
		return sever.payList(param);
	}
	
	@PostMapping("/payListInfo")
	public Object payListInfo(@RequestBody Map<String,Object> param) {
		return sever.payListInfo(param);
	}
}
