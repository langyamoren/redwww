package com.red.util;

import java.io.File;
import java.text.SimpleDateFormat;

public class CreateHtmlFile
{

	public static  String createHtmlFileName()
	{
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sf.format(new java.util.Date())+".html";
	}
	

	public static void main(String[] args) {
		File f=new File("F:\\googleproxy\\fetchserver\\admin.py");
	    System.out.println(f.getName());
	    System.out.println(f.getParent());
	    System.out.println(f.getParent());
	}
}
