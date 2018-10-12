package sch.hunnu.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;

public class SendMessageUtils {

	/**
	 * ACCOUNT_SID，AUTH_TOKEN，BASE_URL 可以从秒嘀登陆后的界面里获取
	 */
	//用户ID
	private static final String ACCOUNT_SID= "fc28b15157744f59b2a9c76ed9ae82d4";
	
	//密钥
	private static final String AUTH_TOKEN= "c414eecd8148460ba518985d07c21466";
	
	//请求地址的前半部分 固定的不用修改
	private static final String BASE_URL= "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
	
	//6位随机码 
//	private static String randNum = MessageUtils.RandomNumber6();
	
	//短信主题

	
	
	/**
	 * 向指定的手机号码发送验证码短信
	 * @param telephone
	 * @return
	 * @throws JsonProcessingException 
	 */
	public static String sendMessageTo(String telephone,String randNum) throws JsonProcessingException{
		//短信内容
		String smsContent="【随思科技】尊敬的用户，您的验证码为"+randNum+"。请勿将验证码告诉他人，以免损失。";
		
		String args = MessageUtils.queryArgs(ACCOUNT_SID, AUTH_TOKEN, smsContent, telephone);
		String returnData="";
		try{
			URL url = new URL(BASE_URL);	
			URLConnection con = url.openConnection();	//根据链接建立连接
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setConnectTimeout(5000);		//设置连接超时为5秒
			con.setReadTimeout(10000);			//设置读取超时未10秒
			
			OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream(), "utf-8");
			writer.write(args);	//写入输出流
			writer.flush();		//清空缓存 全部输出
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line ="";
			
			while((line=bf.readLine())!=null){
				returnData+=line;				//保存返回的数据
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//将返回数据转为 JSON 格式
		ObjectMapper ob = new ObjectMapper();
		String obJson =ob.writeValueAsString(returnData);
		
		return obJson;
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		String tel ="18075147438";
		String checkNum = MessageUtils.RandomNumber6();
		String responseMes =	sendMessageTo(tel,checkNum);
		System.out.println(checkNum);
		System.out.println(responseMes);
	}
}
