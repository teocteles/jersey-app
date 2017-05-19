package br.edu.webservice.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptoUtil {
	
	public static String criptoStringMD5(String valor) {
		
		String texto = null;
		
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(valor.getBytes());
			
			byte[] diagest = md5.digest();
			BigInteger bigInteger = new BigInteger(1, diagest);
			texto = bigInteger.toString();
			/* limitando a qtd de caracteres
			while(texto.length() < 32) {
				texto = "0"+texto;
			}*/
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return texto;
	}
	
	
	public static void main(String[] args) {
		System.out.println(CriptoUtil.criptoStringMD5("admin"));
	}

}
