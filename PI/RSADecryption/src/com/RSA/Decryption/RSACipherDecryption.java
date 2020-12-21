package com.RSA.Decryption;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RSACipherDecryption {
	
	public static String DecryptedMessage = null;
	public static String decr = null;
	public static void main(String[] args) {
		try {

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String decrypt(String cipherText, String privateKeyPath,
			String transformation, String encoding)

	{

		try {
			DecryptedMessage = null;
			//X509EncodedKeySpec x509 = new X509EncodedKeySpec(IOUtils.toByteArray(new FileInputStream(privateKeyPath)));
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
					IOUtils.toByteArray(new FileInputStream(privateKeyPath)));
		    
		    //PrivateKey key = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privateKeyPath.getBytes()));

		   // Cipher cipher = Cipher.getInstance("RSA");
		   // cipher.init(Cipher.PRIVATE_KEY, key);
		  //  byte[] decryptedBytes = cipher.doFinal(cipherText.getBytes());
		   
		    //return decryptedBytes.toString();
			
			byte[] encrptdByte =Base64.decodeBase64(cipherText);
			int size1 =encrptdByte.length;
		   // byte encrptdByte[] = cipherText1.getBytes(encoding);
		   // int size = encrptdByte.length;
		    byte[] encryptionByte = null;
		    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		    cipher.init(Cipher.DECRYPT_MODE, KeyFactory.getInstance("RSA")
					.generatePrivate(pkcs8EncodedKeySpec));
		    //encryptionByte = cipher.doFinal(encrptdByte);
		    DecryptedMessage = new String(cipher.doFinal(encrptdByte), encoding);
			/*DecryptedMessage = null;
			
			X509EncodedKeySpec x509 = new X509EncodedKeySpec(IOUtils.toByteArray(new FileInputStream(privateKeyPath)));
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
					IOUtils.toByteArray(new FileInputStream(privateKeyPath)));
		
			
			

			Cipher cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.DECRYPT_MODE, KeyFactory.getInstance("RSA")
					.generatePrivate(x509));
			
			DecryptedMessage = new String(cipher.doFinal(Base64
					.decodeBase64(cipherText)), encoding);*/
			
			//DecryptedMessage = new String(cipher.doFinal(Base64
				//	.decodeBase64(cipherText)), encoding);
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return DecryptedMessage;

	}
}
