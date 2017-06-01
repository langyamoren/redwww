package com.red.mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ParseFileToMailContent
{
     public static String parseHtmlToConent(String htmlFile)
     {
    
    	 StringBuilder sb=new StringBuilder();
    	 InputStreamReader isr=null;
    	 BufferedReader br=null;
    	 InputStream is=null;
    	 
    	 try {
				is=ParseFileToMailContent.class.getResourceAsStream("/com/red/res/"+htmlFile);
				  if(null!=is );
				  {
					  isr=new InputStreamReader(is);
					  br=new BufferedReader(isr);
					  String tem=null;
					  while(null!=(tem=br.readLine()))
					  {
					    sb.append(tem);
					  }
					  br.close();
				  }
		     } catch (Exception e) {
			// TODO: handle exception
		     }finally
		     {
		    	if(null!=br)
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		     }
    	 return sb.toString();
     }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 parseHtmlToConent("pay_money.html");

	}

}
