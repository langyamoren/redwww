package com.red.util;

import java.util.List; 
import java.util.ArrayList; 
import java.util.Date; 
import java.net.URL; 
import java.net.URLConnection; 
import java.io.*; 

/** 
* Filename: JspToHtml.java <br> 
* Ttitle: jspת����html<br> 
* De.ion: �Ѷ�̬��ҳת���ɾ�̬��ҳ<br> 
* Copyright:        Copyright (c) 2002-2008 BocSoft,Inc.All Rights Reserved. <br> 
* Company:         BocSoft<br> 
* Author:            <a href="mailto:sgicer@163.com">��ϫ</a> <br> 
* Date: 2006-6-19 <br> 
* Time: 16:41:09 <br> 
* Version: 2.0.0 <br> 
*/ 
public class ToHtml { 
	private static String title ="�������"; 
	  private static String context ="�������"; 
	  private static String editer ="�������"; 
	    
	        /** 
	            * ���ݱ���ģ�����ɾ�̬ҳ�� 
	         * @param JspFile    jsp·�� 
	         * @param HtmlFile html·�� 
	         * @return 
	         */ 
	        public static boolean JspToHtmlFile(String filePath, String HtmlFile) { 
	                String str = ""; 
	                long beginDate = (new Date()).getTime(); 
	                try { 
	                        String tempStr = ""; 
	                  FileInputStream is = new FileInputStream(filePath);//��ȡģ���ļ� 
	                        BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
	                        while ((tempStr = br.readLine()) != null) 
	                        str = str + tempStr ; 
	                        is.close(); 
	                } catch (IOException e) { 
	                        e.printStackTrace(); 
	                        return false; 
	                } 
	                try { 
	                    
	            str = str.replaceAll("###title###", title); 
	            str = str.replaceAll("###content###", context); 
	            str = str.replaceAll("###author###", editer);//�滻��ģ������Ӧ�ĵط� 
	             
	                        File f = new File(HtmlFile); 
	                        BufferedWriter o = new BufferedWriter(new FileWriter(f)); 
	                        o.write(str); 
	                        o.close(); 
	                        System.out.println("����ʱ��" + ((new Date()).getTime() - beginDate) + "ms"); 
	                } catch (IOException e) { 
	                        e.printStackTrace(); 
	                        return false; 
	                } 
	                return true; 
	        } 

	        /** 
	         * ����url���ɾ�̬ҳ�� 
	         * 
	         * @param u        ��̬�ļ�·�� �磺http://www.163.com/x.jsp 
	         * @param path �ļ����·���磺x:abcbb.html 
	         * @return 
	         */ 
	        public static boolean JspToHtmlByURL(String u, String path) { 
                //��utl�ж�ȡhtml��Ϊstr 
                String str = ""; 
                try { 
                        URL url = new URL(u); 
                        URLConnection uc = url.openConnection(); 
                        InputStream is = uc.getInputStream(); 
                        BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
                        while (br.ready()) { 
                                str += br.readLine() + " "; 
                                 
                        } 
                        is.close(); 
                        //д���ļ� 
                        File f = new File(path); 
                        BufferedWriter o = new BufferedWriter(new FileWriter(f)); 
                        o.write(str); 
                        o.close(); 
                        str = ""; 
                        return true; 
                } catch (Exception e) { 
                        e.printStackTrace(); 
                        return false; 
                } 
        } 
        /** 
         * ����url���ɾ�̬ҳ�� 
         * 
         * @param url ��̬�ļ�·�� �磺http://www.163.com/x.jsp 
         * @return d 
         */ 
        public static StringBuffer getHtmlTextByURL(String url) { 
                //��utl�ж�ȡhtml��Ϊstr 
                StringBuffer sb = new StringBuffer(); 
                try { 
                        URL u = new URL(url); 
                        URLConnection uc = u.openConnection(); 
                        InputStream is = uc.getInputStream(); 
                        BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
                        while (br.ready()) { 
                                sb.append(br.readLine() + " "); 
                        } 
                        is.close(); 
                        return sb; 
                } catch (Exception e) { 
                        e.printStackTrace(); 
                        return sb; 
                } 
        } 

        /** 
         * ����main ���� 
         * 
         * @param arg 
         */ 
        public static void main(String[] arg) { 
                long begin = System.currentTimeMillis(); 
    //ѭ������20��html�ļ� 
                for (int k = 0; k < 20; k++) { 
                        String url = "mb.htm";//ģ���ļ���ַ 
                        String savepath = "d:/" + k + ".html";//�����ļ���ַ 
                        JspToHtmlFile(url, savepath); 
                } 
                System.out.println("��ʱ:" + (System.currentTimeMillis() - begin) + "ms"); 
        } 
}


