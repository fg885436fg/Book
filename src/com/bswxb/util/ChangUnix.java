package com.bswxb.util;

public class ChangUnix {

	/* @param  unix时间戳转换
*/	
	
	public String TimeStamp2Date(String timestampString){  
	  Long timestamp = Long.parseLong(timestampString)*1000;  
	  
	  String date = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date(timestamp));  
	  return date;  
	}
}
