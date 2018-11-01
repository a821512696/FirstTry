package sch.hunnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sch.hunnu.dao.chatDao;
import sch.hunnu.entity.peoList;
import sch.hunnu.entity.priChat;
import sch.hunnu.entity.priSend;
import sch.hunnu.entity.pubChat;
import sch.hunnu.entity.user;

@Service
public class ChatService {

	@Autowired
	private chatDao dao;
/*
 * 开启事务：
 * 1.使用mybatis 一级缓存 
 * 2.多项 删除 更新 新增	
 */
	
	
	//获取聊天列表和他们的信息
	public List<user> getChatList(String userAcc){
		List<peoList> pl = dao.selectListByACC(userAcc);
		return dao.selectUserByAccs(pl);
	}

	//检查账号密码
	public user loginCheck(String acc,String pw){
		
		if(dao.selectUserByInfo(acc, pw)>=1){
			return dao.selectUserByAcc(acc);
		}else{
			return null;
		}
	}
	
	//获取私聊内容
	public List<priChat> getPriChatContents(String myAcc,String otherAcc){
		return  dao.selectNoteBy2Acc(myAcc, otherAcc);
	}
	
	//插入一条记录到私聊表中
	@Transactional
	public int insertIntoPriChat(priSend ps){
		return dao.insertIntoPriChat(ps);
	}
	
	//获取公聊内容
	public List<pubChat> getPubChatNotes(String groupId){
		return dao.selectPubChatAll(groupId);
	}
	
	

	//插入一条记录到公聊表中
	@Transactional
	public int insertIntoPuChat(pubChat p){
		return dao.insertIntoPubChat(p);
	}
	
	
	
}
