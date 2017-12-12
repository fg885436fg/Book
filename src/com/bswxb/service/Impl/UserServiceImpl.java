package com.bswxb.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bswxb.dao.UserDao;
import com.bswxb.po.User;
import com.bswxb.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public Boolean check(String uname) {
		
	
		
		
		return this.userDao.checkUser(uname);
	}


	@Override
	public Boolean checkIp(String ip) {
		

		return this.userDao.checkUserofIp(ip);
	}


	@Override
	public User GetUserByName(String uname) {
		
		List<User> users = new ArrayList<User>();
	
		users= this.userDao.GetUserByName(uname);
		
		return users.get(0);
	}

}
