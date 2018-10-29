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
 
	//��Կ������
	private KeyGenerator gen;
	//��Կ
	private SecretKey key;
	//����Կ���м��ܺͽ���
	private Cipher c;
	//���ܻ��߽��ܺ� ��¼bytep[]
	byte[] bits;
	
	public DES3() throws NoSuchAlgorithmException, NoSuchPaddingException{
		//ָ����Կ������ ֧�ֵ��� DES3�㷨
		gen = KeyGenerator.getInstance("DESede");
		//����һ����Կ
		key = gen.generateKey();
		//���ܽ��ܹ���֧��DES3
		c = Cipher.getInstance("DESede");
	}
	
	
	/**
	 * ����
	 * @param input
	 * @return
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeyException
	 */
	public byte[] encrtyption(String input) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
		c.init(Cipher.ENCRYPT_MODE, key);		//��ʼ������
		bits = input.getBytes();					
		return c.doFinal(bits);					//��ʼ���ܲ�����
	}
	
	/**
	 * ����
	 * @param strs
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public byte[] decryption(byte[] strs) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		c.init(Cipher.DECRYPT_MODE, key);		//��ʼ������
		return c.doFinal(strs);					//��ʼ���ܲ�����
	}	
		
	
	public static void main(String[] args) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		
		DES3 cc =  new DES3();
		
		String mes = "����������� �ٺ�";
		
		byte bits[] = cc.encrtyption(mes);
		
		System.out.println("���� "+bits+"   "+new String(bits));
		
		byte[] bits2 = cc.decryption(bits);
		
		System.out.println("���� "+bits2 +"   "+new String(bits2));
		
	}
	
}
