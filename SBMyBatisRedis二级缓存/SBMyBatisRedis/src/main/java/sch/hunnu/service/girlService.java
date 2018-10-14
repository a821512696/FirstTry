package sch.hunnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sch.hunnu.dao.IgirlDao;

@Service
public class girlService {

	@Autowired
	IgirlDao dao;
	
	
	/**
	 * 开启事务 测试
	 */
	@Transactional
	public void TestOne(){
		long l = System.currentTimeMillis();
		dao.selectById(9);
		System.out.println("第一次运行时间为"+(System.currentTimeMillis()-l));
		
		l = System.currentTimeMillis();
		dao.selectById(9);
		System.out.println("第二次运行时间为"+(System.currentTimeMillis()-l));
		
		l = System.currentTimeMillis();
		dao.selectById(9);
		System.out.println("第三次运行时间为"+(System.currentTimeMillis()-l));
		
	}
	
	
	/**
	 * 测试二级缓存
	 */
	public void TestTwo(Integer id,int count){
		long l = System.currentTimeMillis();
		dao.selectById(id);
		System.out.println("第"+count+"次运行时间为"+(System.currentTimeMillis()-l));
		
	}





	
}

