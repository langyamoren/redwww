package com.red.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5
{
	/** *//**����MD5���м���
	* @param str �����ܵ��ַ���
	* @return ���ܺ���ַ���
	 * @throws NoSuchAlgorithmException 
	* @throws NoSuchAlgorithmException û�����ֲ�����ϢժҪ���㷨
	 * @throws UnsupportedEncodingException 
	* @throws UnsupportedEncodingException 
	*/
	public static  String EncoderByMd5(String str)
	{
	//ȷ�����㷽��
	MessageDigest md5;
	String newstr=null;
	try
	{
		md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		//���ܺ���ַ���
		char[]strs=base64en.encode(md5.digest(str.getBytes("utf-8"))).toCharArray();
		for(int i=0;i<strs.length;i++)
		{
			strs[i]=(char)((int)strs[i]^2);
		}
		newstr=new String(strs);
	} catch (NoSuchAlgorithmException e)
	{
		System.out.println("�����쳣");
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnsupportedEncodingException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return newstr;
	}

	
	public static void main(String[] args) {
		System.out.println(MD5.EncoderByMd5("Ocu3W{CTrwgUgrvL1kH;ZS??"));
	}
}
