package sch.hunnu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateUtils {

	
	public static String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(new Date());
	}
	
	public static void main(String[] args) {
		System.out.println( getDate());
	}
}
