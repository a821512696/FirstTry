package sch.hunnu;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import redis.clients.jedis.Jedis;
import sch.hunnu.dao.IgirlDao;
import sch.hunnu.entity.girl;
import sch.hunnu.service.girlService;
import sch.hunnu.utils.redisUtil;
    
@RunWith(SpringRunner.class)
@SpringBootTest
public class SbMyBatisRedisApplicationTests {
	
	@Autowired
	IgirlDao dao;
	
	@Test
	public void contextLoads() {
	//girl p= dao.selectByIdAnnotation(9);
	girl p = dao.selectById(9);
	System.out.println(p.toString());
	}
	
	@Test
	public void testRedis(){
	Jedis jedis = redisUtil.getJedis();
	//jedis.auth("123456");
	System.out.println(jedis.info("replication"));	
		jedis.close();
	}
	 
	@Autowired
	private	girlService service;
	
	/**
	 * 测试一级缓存
	 */
	@Test
	public void testOne(){
		
		service.TestOne();
	}
	
	/**
	 * 测试二级缓存
	 */
	@Test
	public void testTwo(){

		for(int i =1;i<5;i++){
			service.TestTwo(9, i);
		}
	}
	
	/**
	 * 测试Redis 做二级缓存
	 */
	@Test
	public void testRedisTwo(){
		for(int i =1;i<5;i++){
			service.TestTwo(8, i);
		}
	}
}
