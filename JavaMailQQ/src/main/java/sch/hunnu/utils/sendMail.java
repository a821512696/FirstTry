package sch.hunnu.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * learn from https://blog.csdn.net/i_dont_know_a/article/details/80561027#commentBox
 * @author Hi
 *
 */
public class sendMail {
	
	//腾讯的服务器的邮箱主机地址
	public static String myMailHost = "smtp.qq.com";

	//发件人 邮箱
	public static String myMailAccount = "821512696@qq.com";
	
	//发件人密码 填授权码
	public static String myMailPassword = "uudhvnikxovpbbdd";
	
	/**
	 * 发送邮件 single
	 * 发送以后qq mail没有发送记录
	 * @param toMailAddress
	 * @param title
	 * @param bodyContent
	 * @throws GeneralSecurityException
	 * @throws MessagingException
	 * @throws IOException
	 */
	public void sendMail(String toMailAddress,String title,String bodyContent) throws GeneralSecurityException, MessagingException, IOException{
		
		Properties props = new Properties();
		
		//mail开启  debug调试模式
		props.setProperty("mail.debug", "true");
		
		//mail服务器开启用户验证
		props.setProperty("mail.smtp.auth","true");
		
		//设置端口
		props.setProperty("mail.smtp.port","465");
		
		//设置发送的主机
		props.setProperty("mail.smtp.host",myMailHost);
		
		//设置发送邮件的协议
		props.setProperty("mail.transport.protocol","smtp");
		
		//开启SSL认证 ，腾讯的mail 基于ssl加密 故而需要开启。
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		
		//设置是否使用ssl安全连接（一般都使用）
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
        
        //创建会话
        Session session = Session.getInstance(props);
        
        //获取邮件对象
        Message mes = new MimeMessage(session);
        
        //设置邮件主题
        mes.setSubject(title);
        
        //线程安全性好，比String 快。
        StringBuilder body = new StringBuilder();
        
        body.append("\n"+bodyContent);
        
        body.append("\n发送时间："+dateUtils.getDate());
        body.append("\nHello World!");
        //设置邮件内容
        mes.setText(body.toString());
        
        System.out.println(body.toString());
        
        //设置发送邮件的时间
        mes.setSentDate(new Date());
		
        //设置发件人邮箱：  邮箱地址，昵称，昵称的字符串
        mes.setFrom(new InternetAddress(myMailAccount, "清风揽月", "UTF-8"));
        
        //获取邮差
		Transport transport = session.getTransport();
		
		//连接到发送者的邮箱
		 //密码不是自己QQ邮箱的密码，而是在开启SMTP服务时所获取到的授权码
		transport.connect(myMailHost, myMailAccount, myMailPassword);
		
		//发送邮件
		transport.sendMessage(mes,new Address[]{ new InternetAddress(toMailAddress)});
		
		
		File f = new File("C:\\Users\\Hi\\Desktop\\sendMail\\"+title+".eml");
		if(!f.exists()){
			f.createNewFile();
		}
		
		//邮件保存到本地
		OutputStream out  = new FileOutputStream(f);
		out.close();
		
		transport.close();
		
	}
	
	
	public static void main(String[] args) throws GeneralSecurityException, MessagingException, IOException {	
		sendMail s = new sendMail();
		s.sendMail("1596651174@qq.com","love", "你好,世界！加油~");
	}
	
	
	
}
