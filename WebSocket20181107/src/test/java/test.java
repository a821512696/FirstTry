import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class test {

    public static void list(List<String> p){
        long l = System.currentTimeMillis();
        int j =0;
        for(int i=0;i<130000;i++){
            j=(int)(Math.random()*p.size());
            p.get(j);
        }

        System.out.println(System.currentTimeMillis() - l);
    }

    public static void set( CopyOnWriteArraySet<String> set){
        long l = System.currentTimeMillis();
        int j =0;

        System.out.println(System.currentTimeMillis() - l);
    }

    public static void main(String[] args){
        long l = System.currentTimeMillis();
        List<String> ls = Collections.synchronizedList(new ArrayList<>());
        for(int i =0; i<100;i++){
            ls.add(i,i+"");
        }
        System.out.println(System.currentTimeMillis() - l);

        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        for(int i =0; i<100;i++){
            set.add(i+"");
        }

        list(ls);
    }
}
