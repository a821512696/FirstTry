package sch.hunnu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import sch.hunnu.entity.girl;

public interface IgirlDao {
	
	//查询所有记录
	public List<girl> selectAllGirl();
	
	
	@Select("select * from girl where id =#{id}")
	public girl selectByIdAnnotation(@Param("id") Integer id);
	
	
	
	public girl selectById(@Param("id") Integer id);
	
	
	
	
	
	
	
	
	
	
	
}
