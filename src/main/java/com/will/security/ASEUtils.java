package com.will.security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author hcguo
 *
 */
public class ASEUtils {
	
	private String sKey = "10d2Xd4hf0s1XvSw";
	
	private String ivParameter = "10d2Xd4hf0s1XvSw";
	
	private static ASEUtils instance = null;
	
	private ASEUtils() {

    }

    public static ASEUtils getInstance() {
        if (instance == null)
            instance = new ASEUtils();
        return instance;
    }
	
	
    public String encrypt(String sSrc) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
        return new BASE64Encoder().encode(encrypted);
    }

    public String decrypt(String sSrc) throws Exception {
        try {
            byte[] raw = sKey.getBytes();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "utf-8");
            return originalString;
        } catch (Exception ex) {
            return null;
        }
        
        
        
    }
    
    
    public static void main(String args[]) throws Exception{
		ASEUtils ase = new ASEUtils();
		System.out.println(ase.encrypt("http://localhsot:9282/:31209321"));
		System.out.println(ase.decrypt(ase.encrypt("http://localhsot:9282/:31209321")));
		
	}
}
