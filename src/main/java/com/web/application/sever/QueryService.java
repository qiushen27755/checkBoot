package com.web.application.sever;

import java.util.Map;

  

public interface QueryService {
	 
	  Object payList(Map<String, Object> param);

	  Object payListInfo(Map<String, Object> param);
}
