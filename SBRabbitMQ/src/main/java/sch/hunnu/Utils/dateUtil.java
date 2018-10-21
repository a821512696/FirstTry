package sch.hunnu.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class dateUtil {

	
	public static String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return sdf.format(new Date());
	}
	
	public static void main(String[] args) {
		System.out.println(getDate());
	}
}
