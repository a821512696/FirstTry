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

	//�ṩ�Գ���Կ�������Ĺ��ܣ�֧�ֶ��ּ����㷨��
	private KeyGenerator keyGen;
	//���ڱ�����Կ
	private SecretKey desKey;
	//�������м��ܻ��߽���
	private Cipher c;
	//����������ܵĽ��
	private byte[] cipherByte;

	public DES() throws NoSuchAlgorithmException, NoSuchPaddingException{
		//����des��ʼ��   ��Կ������֧��DES
		keyGen = KeyGenerator.getInstance("DES");
		//������Կ
		desKey = keyGen.generateKey();
		//���ܽ��ܹ���  ֧��DES
		c = Cipher.getInstance("DES");
	}
	
	/**
	 * �����ַ���
	 * @param str
	 * @return
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeyException
	 */
	public byte[] encryptionDes(String str) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
		c.init(Cipher.ENCRYPT_MODE, desKey);		//��ʼ������
		byte[] strs = str.getBytes();		
		
		cipherByte = c.doFinal(strs);			//��ʼ����
		System.out.println(cipherByte);
		return cipherByte;
	}
	
	/**
	 * ����
	 * @param strs
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String decryptionDes(byte[] strs) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		c.init(Cipher.DECRYPT_MODE, desKey);		//��ʼ������
		cipherByte = c.doFinal(strs);				//��ʼ����
		
		System.out.println(cipherByte);
		
		return new String(cipherByte);
		
	}
	
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		DES dess = new DES();
		
		byte[] encryption =  dess.encryptionDes("�����������");
		
		System.out.println(encryption+"   "+new String(encryption));
		System.out.println(dess.decryptionDes(encryption));
		 
	}
}
