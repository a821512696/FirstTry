package Asysmetric;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {
	static Cipher c;
	
	/**
	 * 获取 公钥和私钥, 将公钥和私钥放在map里。
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public Map<String,Object> getKeyMap() throws NoSuchAlgorithmException{
		KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
		gen.initialize(1024);
		KeyPair key = gen.generateKeyPair();
		
		Map<String,Object> map = new HashMap<>();
		map.put("priKey",key.getPrivate() );
		map.put("pubKey", key.getPublic());
		return map;
	}
	
	/**
	 * 公钥加密或者解密
	 * @param publicKey
	 * @param Bmes
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public byte[] publicKeyOperation(RSAPublicKey publicKey ,byte[] Bmes,String flage) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
	
		if(publicKey==null) return null;
		
		c =	Cipher.getInstance("RSA");				//生成支持RSA算法的一个加密或者解密过程
	
		if(flage.equals("encryption")){				//判断进行加密或者解密
			c.init(Cipher.ENCRYPT_MODE, publicKey);
		}else{
			c.init(Cipher.DECRYPT_MODE, publicKey);
		}
		
		return c.doFinal(Bmes);						//进行操作并且返回
	}
	
	/**
	 * 私钥加密或者解密
	 * @param privateKey
	 * @param Bmes
	 * @param flage
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public byte[] privateKeyOperation(RSAPrivateKey privateKey ,byte[] Bmes,String flage) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		
		if(privateKey==null) return null;
			
		c =	Cipher.getInstance("RSA");				//生成支持RSA算法的一个加密或者解密过程
		
		if(flage.equals("encryption")){				//判断进行加密或者解密
			c.init(Cipher.ENCRYPT_MODE, privateKey);
		}else{
			c.init(Cipher.DECRYPT_MODE, privateKey);
		}
		
		return c.doFinal(Bmes);						//进行操作并且返回
	}
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		RSA rsa = new RSA();
		Map<String, Object> map = rsa.getKeyMap();
		
		RSAPrivateKey priKey = (RSAPrivateKey) map.get("priKey");
		System.out.println(priKey.toString()+"\n\n");
		RSAPublicKey pubKey = (RSAPublicKey) map.get("pubKey");
		System.out.println(pubKey.toString()+"\n\n");
		
		String mess = "今天又是充满希望的一天呢!";
		
		byte[] encrys = rsa.publicKeyOperation(pubKey, mess.getBytes(), "encryption");
		System.out.println("加密： "+encrys.toString()+"\n"+new String(encrys)+"\n");
		byte[] decrys = rsa.privateKeyOperation(priKey, encrys, "decryption");
		System.out.println("解密： "+decrys.toString()+"\n"+new String(decrys));
		
	}
}
