package sch.hunnu.utils;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MessageUtils {

	/**
	 * 生成验证码
	 * @return
	 */
	public static  String RandomNumber6(){
		String num="";
		for( int i=0;i<6;i++){
			
			num+= (int)(Math.random()*10);
		}
		System.out.println(num);
		
		return num;
		
	}
	
	/**
	 * 获取时间戳
	 * @return
	 */
	public static String getTimeStamp(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");

		 String stamp = sdf.format(new Date());
		
		System.out.println(stamp);
		return stamp;
	}
	 
	/**
	 * 将要发送的参数拼接起来
	 * @param ACCOUNT_SID
	 * @param AUTH_TOKEN
	 * @param smsContent
	 * @param to
	 * @return
	 */
	public static String queryArgs(String ACCOUNT_SID,String AUTH_TOKEN, String smsContent, String to){
		
		String timeStamp = getTimeStamp();	//获取时间戳
		
		String sig = MD5( ACCOUNT_SID,AUTH_TOKEN,timeStamp);		//进行MD5加密
		
		String str = "accountSid="+ACCOUNT_SID+"&smsContent="+
                smsContent+"&to="+to+"&timestamp="+timeStamp+"&sig="+sig;
        
		
		System.out.println("参数："+str);

		return str;
		
	}
	
	/**
	 * 进行MD5加密  把字符串连接 然后 转为byte[] 每一个byte都转为16进制。
	 * @param args
	 * @return
	 */
	public static String MD5(String ...args){
		String str = "";
		//将字符串进行拼接
		if(args!=null &&args.length>0){
			for(String s:args){
				str +=s;
			}
		}else{
			return "";
		}
		
		System.out.println( "加密之前"+str);
		
		//开始加密
		String result="";
		try{
			MessageDigest digest = MessageDigest.getInstance("MD5"); //生成MD5的实例
			
			byte[] byts = digest.digest(str.getBytes());		//转为byte[]
			
			for( byte b:byts){
				String hex = Integer.toHexString(b&0xff);		//b 转为16进制
				
				if (hex.length() == 1) {			//最后一次
                     result+="0"+hex;
                 }else{							
                     result+=hex;
                 }
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("加密后"+result);
		return result;
	}
	
	public static void main(String[] args) {
		//getTimeStamp();
		
		//MD5("123","456","789");
	}
}
