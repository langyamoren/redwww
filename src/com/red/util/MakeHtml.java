package com.red.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class MakeHtml
{
//返回html代码 
public static String getHtmlCode(String httpUrl)
{

	 String htmlCode = ""; 
	 HttpURLConnection connection =null;
	 java.io.BufferedReader breader=null;
 try {
		InputStream in;
		URL url = new java.net.URL(httpUrl);
		connection = (HttpURLConnection)url.openConnection();
		connection = (HttpURLConnection) url.openConnection();
		//connection.setRequestProperty("User-Agent","Mozilla/4.0");
		connection.connect();
		in = connection.getInputStream();
	    breader = new BufferedReader(new InputStreamReader(in , "GBK"));
		String currentLine=null; 
		while(null!=(currentLine=breader.readLine()))
		{
		htmlCode+=currentLine;
		}
		breader.close();
     }catch (Exception e) 
     {
                e.printStackTrace();
     }finally
     {
		try {
			if(null!=breader)breader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
      return htmlCode;
} 

//存储文件
public static synchronized void writeHtml(String filePath,String content)
{
   PrintWriter pw = null; 
try { 
		 File writeFile = new File(filePath);
		 boolean isExit = writeFile.exists();
		 if (isExit != true) 
		 { 
		  writeFile.createNewFile(); 
		 } else 
		 { 
			
			 writeFile.delete(); 
			 writeFile.createNewFile();
		 }  
		 pw = new PrintWriter(new FileOutputStream(filePath, true)); 
		 pw.println(content); 
		 pw.close();  
    } catch (Exception ex) 
    {  
	 System.out.println(ex.getMessage());
	}finally{  pw.close(); }  
}  
public static void main(String[] args)
{  	 Date before = new Date();
     long star = before.getTime(); 
	String url = "http://www.sina.com";
	writeHtml("c:/demo.htm",getHtmlCode(url)); 
	System.out.println(System.currentTimeMillis()-star);
} 

} 