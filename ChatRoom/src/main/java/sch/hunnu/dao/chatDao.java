package sch.hunnu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sch.hunnu.entity.peoList;
import sch.hunnu.entity.priChat;
import sch.hunnu.entity.priSend;
import sch.hunnu.entity.user;

public interface chatDao {
	
	//从私聊表中获取用户账号
	public List<peoList> selectListByACC(@Param("myAcc")String myAcc);
	
	//根据用户账号查询用户所有信息不包括密码
	public List<user> selectUserByAccs(@Param("list")List<peoList> list);
	
	//根据账号密码查询用户
	public int selectUserByInfo(@Param("acc")String acc,@Param("pw")String pw);
	
	//根据账号查询用户
	public user selectUserByAcc(@Param("acc")String acc);
	
	//根据两个acc查询私聊记录
	public List<priChat> selectNoteBy2Acc(@Param("me")String myAcc,@Param("other")String otherAcc);
	
	//插入一条私聊记录
	public int insertIntoPriChat(@Param("pri")priSend p);
}
