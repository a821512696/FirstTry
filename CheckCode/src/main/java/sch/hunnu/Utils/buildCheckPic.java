package sch.hunnu.Utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class buildCheckPic {

	private static int picWidth=100;
	private static int picHeight=50;
	
	public static Color buildColor(){
		return new Color((int)(Math.random()*200)+20,(int)(Math.random()*200)+20, (int)(Math.random()*200)+20);
	}
	
	
	public static BufferedImage buildPic(String checkStr){
	//新建图片对象
	BufferedImage img = new BufferedImage(100,50, BufferedImage.TYPE_INT_RGB);
 
	//获取对于图片对象的画笔
	Graphics pan= img.getGraphics();
 
	pan.setColor(Color.white);
	
	//设置绘画的区域
	pan.fillRect(0, 0, picWidth, picHeight);
	
	//画些线防止图片读取
	for(int i=0;i<5;i++){
		//随机颜色
		pan.setColor(buildColor());
		
		int x1 =(int) (Math.random()*picWidth);
		int y1 =(int) (Math.random()*picHeight);
		int x2 =(int) (Math.random()*picWidth);
		int y2 =(int) (Math.random()*picHeight);
		pan.drawLine(x1, y1, x2, y2);
	}
	
	//将字符串 画到图片上
	
	int space =(int)picWidth/checkStr.length(); //字与字之间的间隔
	int strX = 0,strY=0;
	
	Font f = new Font("TimesRoman", Font.BOLD, 20);
	pan.setFont(f);
	
	for(int i =0;i<checkStr.length();i++){
		//设置随机颜色
		pan.setColor(buildColor());
		
		strY=(int)(Math.random()*30)+20;
		
		pan.drawString(checkStr.charAt(i)+"",strX, strY);
		System.out.println(strX+"  "+strY);
		strX+=space;
	}
	
	return img;
	}
	
	
}
