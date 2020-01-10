package com.web.application.tools;

import lombok.Data;

@Data
public class CommenRes {
	
	private int statusCode=200;
	private String message;
	private Object data;

	 
}
