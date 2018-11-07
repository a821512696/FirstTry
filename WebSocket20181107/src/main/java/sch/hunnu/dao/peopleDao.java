package sch.hunnu.dao;

import org.apache.ibatis.annotations.Select;
import sch.hunnu.entity.Student;
import sch.hunnu.entity.ft;

import java.util.List;

public interface peopleDao {



    @Select("select * from  stu")
    public List<Student>  selectAll();

    @Select("select * from  ft")
    public List<ft>  selectFtAll();

}
