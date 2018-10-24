package sch.hunnu.Utils;

public class buildStr {
	
	public static String getCheckStr(){
		String str="";	//验证码
		int num;		//验证码的数字成分
		char s;			//验证码的字母成分
		for(int i =0;i<5;i++){
			if(i%2==0){										//1 3 5 数字 , 2 4 字母
				num = (int)(Math.random()*10);				//0-9
				str+=num;
			}else{
				s = (char) ((int)(Math.random()*26)+65);	//"A-Z" "65-90"
				str+=s;
			}
		}
	return str;
	
	}
	
}
