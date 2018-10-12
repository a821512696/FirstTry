package sch.hunnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sch.hunnu.dao.IAccout;
import sch.hunnu.entity.user;

@Service
public class service {

	@Autowired
	private IAccout dao;
	
	/**
	 * 根据电话号码查询用户
	 * @param phone
	 * @return
	 */
	public user selectByPhone(String phone){
		
		return dao.selectByPhone(phone);
		
	}
	
	
}
