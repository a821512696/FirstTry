package sch.hunnu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import  org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sch.hunnu.dao.peopleDao;
import sch.hunnu.entity.Student;
import sch.hunnu.entity.ft;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebSocketApplicationTests {

    @Autowired
    private peopleDao ps ;

    @Test
    public void contextLoads() {

    List<Student> ls =ps.selectAll();
    for(Student s :ls){
        System.out.println(s.toString());
    }

    }

    /**
     *
     * @throws IOException
     */
    @Test
    public void t1() throws IOException {
        List<ft> lf = ps.selectFtAll();
        for(ft s :lf){
            System.out.println(s.toString());
        }
        ObjectMapper ob = new ObjectMapper();
       String json = ob.writeValueAsString(lf);
        System.out.println("/n/n/n "+json);

        JavaType jt = ob.getTypeFactory().constructParametricType(List.class,ft.class);

        List<ft>   lfs = (List<ft>) ob.readValue(json,jt);
        for(ft s :lfs){
            System.out.println(s.toString());
        }
    }

}
