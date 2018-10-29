package Symmetric;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class DES3 {
 
	//密钥生成器
	private KeyGenerator gen;
	//密钥
	private SecretKey key;
	//对密钥进行加密和解密
	private Cipher c;
	//加密或者解密后 记录bytep[]
	byte[] bits;
	
	public DES3() throws NoSuchAlgorithmException, NoSuchPaddingException{
		//指定密钥生成器 支持的是 DES3算法
		gen = KeyGenerator.getInstance("DESede");
		//生产一个密钥
		key = gen.generateKey();
		//加密解密过程支持DES3
		c = Cipher.getInstance("DESede");
	}
	
	
	/**
	 * 加密
	 * @param input
	 * @return
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeyException
	 */
	public byte[] encrtyption(String input) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
		c.init(Cipher.ENCRYPT_MODE, key);		//初始化加密
		bits = input.getBytes();					
		return c.doFinal(bits);					//开始加密并返回
	}
	
	/**
	 * 解密
	 * @param strs
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public byte[] decryption(byte[] strs) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		c.init(Cipher.DECRYPT_MODE, key);		//初始化解密
		return c.doFinal(strs);					//开始解密并返回
	}	
		
	
	public static void main(String[] args) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		
		DES3 cc =  new DES3();
		
		String mes = "李宏涛美滋滋 嘿嘿";
		
		byte bits[] = cc.encrtyption(mes);
		
		System.out.println("加密 "+bits+"   "+new String(bits));
		
		byte[] bits2 = cc.decryption(bits);
		
		System.out.println("解密 "+bits2 +"   "+new String(bits2));
		
	}
	
}
