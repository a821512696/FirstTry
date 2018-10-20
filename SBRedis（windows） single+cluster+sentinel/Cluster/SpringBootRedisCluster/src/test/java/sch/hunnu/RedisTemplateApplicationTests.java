package sch.hunnu;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sch.hunnu.entity.user2;
import sch.hunnu.util.redisUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateApplicationTests {

    @Resource(name="redisUtilCluster") 
	redisUtil redis;
	
	
	@Test
	public void contextLoads() {
		String key = "nubmber";
		redis.set(key,"123456");
	System.out.println(redis.get(key));
	
	redis.set("cluster","cluster");
	System.out.println(redis.get("cluster"));
	

	redis.set("name","name");
	System.out.println(redis.get("name"));
		
	}

	
	
	@Resource(name = "user2")
	user2 p ;
	@Test
	public void test(){
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getSex());
		System.out.println(p.getPhone());
		
	}
	
	/*
	@Resource(name="redisUtilSentinel")
	redisUtil tools;
	
	@Test
	public void test2(){
	 
		while(true){
		try {
			Thread.sleep(1000);
		System.out.println(tools.set("name", "lht"));
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	*/
	
	
}
