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
	 * ��ȡ ��Կ��˽Կ, ����Կ��˽Կ����map�
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
	 * ��Կ���ܻ��߽���
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
		
		c =	Cipher.getInstance("RSA");				//����֧��RSA�㷨��һ�����ܻ��߽��ܹ���
	
		if(flage.equals("encryption")){				//�жϽ��м��ܻ��߽���
			c.init(Cipher.ENCRYPT_MODE, publicKey);
		}else{
			c.init(Cipher.DECRYPT_MODE, publicKey);
		}
		
		return c.doFinal(Bmes);						//���в������ҷ���
	}
	
	/**
	 * ˽Կ���ܻ��߽���
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
			
		c =	Cipher.getInstance("RSA");				//����֧��RSA�㷨��һ�����ܻ��߽��ܹ���
		
		if(flage.equals("encryption")){				//�жϽ��м��ܻ��߽���
			c.init(Cipher.ENCRYPT_MODE, privateKey);
		}else{
			c.init(Cipher.DECRYPT_MODE, privateKey);
		}
		
		return c.doFinal(Bmes);						//���в������ҷ���
	}
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		RSA rsa = new RSA();
		Map<String, Object> map = rsa.getKeyMap();
		
		RSAPrivateKey priKey = (RSAPrivateKey) map.get("priKey");
		System.out.println(priKey.toString()+"\n\n");
		RSAPublicKey pubKey = (RSAPublicKey) map.get("pubKey");
		System.out.println(pubKey.toString()+"\n\n");
		
		String mess = "�������ǳ���ϣ����һ����!";
		
		byte[] encrys = rsa.publicKeyOperation(pubKey, mess.getBytes(), "encryption");
		System.out.println("���ܣ� "+encrys.toString()+"\n"+new String(encrys)+"\n");
		byte[] decrys = rsa.privateKeyOperation(priKey, encrys, "decryption");
		System.out.println("���ܣ� "+decrys.toString()+"\n"+new String(decrys));
		
	}
}
