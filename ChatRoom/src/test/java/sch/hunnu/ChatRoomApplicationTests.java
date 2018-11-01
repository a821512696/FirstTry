package sch.hunnu;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sch.hunnu.dao.chatDao;
import sch.hunnu.entity.peoList;
import sch.hunnu.entity.priChat;
import sch.hunnu.entity.priSend;
import sch.hunnu.entity.pubChat;
import sch.hunnu.entity.user;
import sch.hunnu.utils.dateUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatRoomApplicationTests {

	@Autowired
	private chatDao dao;
	@Test
	public void contextLoads() {
		List<peoList> ll = dao.selectListByACC("s1");
		
		for(peoList l : ll){
			System.out.println(l.getAcc());
		}
	}

	@Test
	public void select(){
		List<peoList> ll = dao.selectListByACC("s1");
		List<user> ls = dao.selectUserByAccs(ll);
		
		for(user s :ls){
			System.out.println(s.toString());
		}
	}
	@Test
	public void select1(){
	List<priChat> lp =	dao.selectNoteBy2Acc("s1","s2");
		for(priChat c:lp){
			System.out.println(c.toString());
		}
	}
	
	@Test
	public void select2(){
	int p =	dao.selectUserByInfo("s1", "s1");
		
	System.out.println(p);
	}

	@Test
	public void select3(){
	user p =	dao.selectUserByAcc("s1");
		
	System.out.println(p.toString());
	}
	
	@Test
	public void select4(){
		priSend ps = new priSend("sender", "receiver", "senderNick", "content", dateUtil.getDateNow());
		int i =dao.insertIntoPriChat(ps);
		System.out.println(i);
	}
	
	@Test
	public void select5(){
		List<pubChat> pc = dao.selectPubChatAll("123456789");
		
		for(pubChat c:pc){
			System.out.println(c.toString());
		}
	}
	
	@Test
	public void select6(){
	 
		pubChat pc = new pubChat("123456789","s998", "test", "test", "test", dateUtil.getDateNow());
		
		int i =dao.insertIntoPubChat(pc);
		System.out.println(i);
	}
	
	@Test
	public void select7(){
		
		user p = new user("123456789", "123456", "nick", "pic", dateUtil.getDateNow());
		System.out.println(dao.insertIntoUser(p));
		
		
		
		
	}
}
