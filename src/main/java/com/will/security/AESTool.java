package com.will.security;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;





public class AESTool {
	
	public static final String src = "http://localhsot:9282/";
	
	public String AESEncrypt(String src){
		String encryData = null;
		try {
			//生成key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keyBytes = secretKey.getEncoded();
			
			//key转换
			Key key = new SecretKeySpec(keyBytes, "AES");
			
			//加密
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk aes encrypt:"+ new sun.misc.BASE64Encoder().encode(result));
			encryData = new sun.misc.BASE64Encoder().encode(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryData;
	}
	
	
	public String AESDecrypt(String src){
		byte[] result = null;
		try {
			//生成key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keyBytes = secretKey.getEncoded();
			
			//key转换
			Key key = new SecretKeySpec(keyBytes, "AES");
			
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			result = cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(src));
			System.out.println("jdk aes decrypt:"+ new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(result);
	}
	
	
	public static void main(String args[]){
		AESTool ase = new AESTool();
		ase.AESEncrypt(src);
		ase.AESDecrypt("IMcUOLkZKLoqZJtHZdwQJmiHPsKsFf68pdbmOmRVkD0=");
		
	}

}
