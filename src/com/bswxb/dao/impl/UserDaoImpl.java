package com.bswxb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bswxb.base.impl.BaseDaoImpl;
import com.bswxb.dao.UserDao;
import com.bswxb.po.Book_Book;
import com.bswxb.po.User;
@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User>  implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByWord(String Hql) {
		Query query = this.getSession().createQuery(Hql);
		
	   return query.setCacheable(true).list();
	}

	@Override
	public boolean checkUser(String uname) {
		String Hql=" select count(*) From User u Where   u.uname=:uname";  
	    Query query = this.getSession().createQuery(Hql).setString("uname", uname);		
	    int i = 0 ;
	    i= ((Number) query.uniqueResult()).intValue();
	    
	    if(i>0) {
	    	
	    	return true;
	    }
	    
		return false;
		
	}

	@Override
	public boolean checkUserofIp(String ip) {
		
		
		String Hql=" select count(*) From User u Where   u.uip=:ip";  
	    Query query = this.getSession().createQuery(Hql).setString("ip", ip);		
	    int i = 0 ;
	    i= ((Number) query.uniqueResult()).intValue();
	    
	    if(i>=3) {
	    	
	    	return true;
	    }
	    
		return false;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> GetUserByName(String uname) {
		
		String Hql=" From User u Where   u.uname=:uname";
		Query query = this.getSession().createQuery(Hql).setString("uname", uname);
		
	 return query.setCacheable(true).list();
	}


}
