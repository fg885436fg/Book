package com.bswxb.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bswxb.base.impl.BaseDaoImpl;
import com.bswxb.dao.AddBooksDao;
import com.bswxb.po.AddBooks;
@Repository
@Transactional
public class AddBookDaoImpl  extends BaseDaoImpl<AddBooks>  implements AddBooksDao  {



}
