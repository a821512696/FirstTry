package Symmetric;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class DES {

	//提供对称密钥生成器的功能，支持多种加密算法。
	private KeyGenerator keyGen;
	//用于保存密钥
	private SecretKey desKey;
	//用来进行加密或者解密
	private Cipher c;
	//用来保存加密的结果
	private byte[] cipherByte;

	public DES() throws NoSuchAlgorithmException, NoSuchPaddingException{
		//进行des初始化   密钥生成器支持DES
		keyGen = KeyGenerator.getInstance("DES");
		//生产密钥
		desKey = keyGen.generateKey();
		//加密解密过程  支持DES
		c = Cipher.getInstance("DES");
	}
	
	/**
	 * 加密字符串
	 * @param str
	 * @return
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeyException
	 */
	public byte[] encryptionDes(String str) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
		c.init(Cipher.ENCRYPT_MODE, desKey);		//初始化加密
		byte[] strs = str.getBytes();		
		
		cipherByte = c.doFinal(strs);			//开始加密
		System.out.println(cipherByte);
		return cipherByte;
	}
	
	/**
	 * 解密
	 * @param strs
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String decryptionDes(byte[] strs) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		c.init(Cipher.DECRYPT_MODE, desKey);		//初始化解密
		cipherByte = c.doFinal(strs);				//开始解密
		
		System.out.println(cipherByte);
		
		return new String(cipherByte);
		
	}
	
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		DES dess = new DES();
		
		byte[] encryption =  dess.encryptionDes("李宏涛美滋滋");
		
		System.out.println(encryption+"   "+new String(encryption));
		System.out.println(dess.decryptionDes(encryption));
		 
	}
}
