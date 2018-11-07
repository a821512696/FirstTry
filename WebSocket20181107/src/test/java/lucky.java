import java.util.ArrayList;
import java.util.List;

public class lucky {


    public static void displayAll(List<Integer> members){
        System.out.println("当前参与抽奖的人"+members.size()+"位：");
        StringBuilder str = new StringBuilder("");
        for(Integer i:members){
             str.append(i);
             str.append(", ");
        }

        System.out.println(str+"\n");

    }


    public static void main(String[] args){
        Integer[] lucker = new Integer[3];
        List<Integer> members = new ArrayList<>();

        for(Integer i=0;i<96;i++){
            members.add(i,i);
        }
        displayAll(members);

        for(int i=0;i<3;i++){
        int luck = (int)(Math.random()*members.size());
        lucker[i] = members.get(luck);
        System.out.println("第"+(i+1)+"位幸运者："+lucker[i] + "\n\n\n");
        //下次这个幸运者不参与
            members.remove(luck);
        //查看是否把中奖者剔除了
        displayAll(members);
        }


    }
}
