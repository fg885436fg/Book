package com.bswxb.service;

import com.bswxb.po.User;

public interface  UserService {
	
	Boolean check(String uname);
    
	Boolean checkIp(String ip);
	
	User GetUserByName(String uname);
	
}
