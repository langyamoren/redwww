package com.red.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5
{
	/** *//**利用MD5进行加密
	* @param str 待加密的字符串
	* @return 加密后的字符串
	 * @throws NoSuchAlgorithmException 
	* @throws NoSuchAlgorithmException 没有这种产生消息摘要的算法
	 * @throws UnsupportedEncodingException 
	* @throws UnsupportedEncodingException 
	*/
	public static  String EncoderByMd5(String str)
	{
	//确定计算方法
	MessageDigest md5;
	String newstr=null;
	try
	{
		md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		//加密后的字符串
		char[]strs=base64en.encode(md5.digest(str.getBytes("utf-8"))).toCharArray();
		for(int i=0;i<strs.length;i++)
		{
			strs[i]=(char)((int)strs[i]^2);
		}
		newstr=new String(strs);
	} catch (NoSuchAlgorithmException e)
	{
		System.out.println("加密异常");
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
