package com.bswxb.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bswxb.base.impl.BaseDaoImpl;
import com.bswxb.dao.UpdateDao;
import com.bswxb.po.Update;

@Repository
@Transactional
public class UpdateDaoImpl extends BaseDaoImpl<Update> implements UpdateDao {

	@Override
	public Update findbyHql(String Hql) {

		return (Update) this.getSession().createQuery(Hql).uniqueResult();

	}

}
