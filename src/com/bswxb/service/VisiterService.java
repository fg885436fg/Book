package com.bswxb.service;

import com.bswxb.po.Visiter;

public interface VisiterService {

	void save(String ip );
	
	Visiter findOne(String ip);
	
}
