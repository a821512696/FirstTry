package sch.hunnu.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import sch.hunnu.entity.user;

public interface IAccout {
	
	//根据电话号码来查询 用户是否存在
	@Select("select count(*) from user where phone=#{number}")
	public int selectAccount(@Param("number") String number);
	
	
	//根据电话号码查询用户
	public user selectByPhone(@Param("phone") String phone);
}
