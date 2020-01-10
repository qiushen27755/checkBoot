package com.web.application.tools;

import lombok.Getter;
import lombok.Setter;

public class PageResult {
	/**
	 * 成功状态码
	 */
	public static final int STATUS_SUCCESS = 200;

	/**
	 * 错误状态码
	 */
	public static final int STATUS_ERROR = 300;


	public PageResult(int statusCode,String message,Object data){
		this.setStatusCode(statusCode);
		this.setMessage(message);
		this.setData(data);
    }
	
	public PageResult(){
		this(STATUS_SUCCESS,"操作成功");
    }
    
    public PageResult(String message){
    	this(STATUS_SUCCESS,message);
    }
    
    public PageResult(int statusCode){
		this(statusCode,null);
	}
    
    public PageResult(int statusCode,String message){
    	this(statusCode,message,null);
    }
    
    @Getter
    @Setter
	private int statusCode=200;
    @Getter
    @Setter
    private int limit=10; //限制
    @Getter
    @Setter
    private String message = "操作成功";
    @Getter
    @Setter
    private String Message;
    @Getter
    @Setter
 	private Object Data;
    @Getter
    @Setter
 	private Integer pageSize; //当前 行数 
    @Getter
    @Setter
 	private Integer offset;// 请求行数
    @Getter
    @Setter
 	private Integer pageNum;// 当前页
    @Getter
    @Setter
 	private Integer pageTotal; // 总页
    @Getter
    @Setter
 	private Integer total;

}
