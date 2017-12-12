package com.bswxb.dao;

import com.bswxb.base.BaseDao;
import com.bswxb.po.DelectBooks;

public interface DelectBooksDao  extends  BaseDao<DelectBooks> {
	DelectBooks findByUrl(String url);
}
