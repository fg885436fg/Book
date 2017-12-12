package com.bswxb.dao;

import java.util.List;

import com.bswxb.base.BaseDao;
import com.bswxb.po.Book_Book;
import com.bswxb.po.User;

public  interface UserDao extends  BaseDao<User>{

	List<User> findByWord(String Hql);
	boolean checkUser(String uname);
	boolean checkUserofIp(String ip);
	List<User> GetUserByName(String uname);
}
