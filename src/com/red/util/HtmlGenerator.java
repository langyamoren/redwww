package com.red.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;


/** ��̬ҳ������ */
public class HtmlGenerator  
{
	 private static Logger logger = Logger.getLogger(HtmlGenerator.class);

	HttpClient httpClient = null; //HttpClientʵ��
	GetMethod getMethod =null; //GetMethodʵ��
	BufferedWriter fw = null;
	String page = null;
	String webappname = null;
	BufferedReader br = null;
	InputStream in = null;
	StringBuffer sb = null;
	String line = null;
	
	//���췽��
	public HtmlGenerator(String webappname){
		this.webappname = webappname;
		
	}
	public static String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
	
	/** ����ģ�漰����������̬ҳ�� */
	public boolean createHtmlPage(String url,String htmlFileName){
		boolean status = false;	
		int statusCode = 0;				
		try{
			//����һ��HttpClientʵ���䵱ģ�������
			httpClient = new HttpClient();
			//����httpclient��ȡ����ʱʹ�õ��ַ���
			httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"gbk");			
			//����GET������ʵ��
			getMethod = new GetMethod(url);
			//ʹ��ϵͳ�ṩ��Ĭ�ϵĻָ����ԣ��ڷ����쳣ʱ���Զ�����3��
			getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
			//����Get�����ύ����ʱʹ�õ��ַ���,��֧�����Ĳ�������������
			getMethod.addRequestHeader("Content-Type","text/html;charset=GB18030");
			//ִ��Get������ȡ�÷���״̬�룬200��ʾ��������������Ϊ�쳣
			statusCode = httpClient.executeMethod(getMethod);			
			if (statusCode!=200) {
				logger.fatal("��̬ҳ�������ڽ���"+url+"������̬ҳ��"+htmlFileName+"ʱ����!");
			}else{
				//��ȡ�������
				sb = new StringBuffer();
				in = getMethod.getResponseBodyAsStream();
				br = new BufferedReader(new InputStreamReader(in));
				while((line=br.readLine())!=null){
					sb.append(line+"\n");
				}
				if(br!=null)br.close();
				page = sb.toString();
				//��ҳ���е����·���滻�ɾ���·������ȷ��ҳ����Դ��������
				page = formatPage(page);
				//���������д��ָ���ľ�̬HTML�ļ��У�ʵ�־�̬HTML����
				writeHtml(htmlFileName,page);
				status = true;
			}			
		}catch(Exception ex){
			logger.fatal("��̬ҳ�������ڽ���"+url+"������̬ҳ��"+htmlFileName+"ʱ����:"+ex.getMessage());			
             ex.printStackTrace();
		}finally{
        	//�ͷ�http����
        	getMethod.releaseConnection();
        }
		return status;
	}
	
	//���������д��ָ���ľ�̬HTML�ļ���
	private synchronized void writeHtml(String htmlFileName,String content) throws Exception{
		fw = new BufferedWriter(new FileWriter(htmlFileName));
		fw.write(page);	
		if(fw!=null)fw.close();		
	}
	
	//��ҳ���е����·���滻�ɾ���·������ȷ��ҳ����Դ��������
	private String formatPage(String page){		
		page = page.replaceAll("\\.\\./\\.\\./\\.\\./", webappname+"/");
		page = page.replaceAll("\\.\\./\\.\\./", webappname+"/");
		page = page.replaceAll("\\.\\./", webappname+"/");			
		return page;
	}
	
	public boolean createRedHtml(String redalis,Object...param) throws FileNotFoundException, IOException
	{
		boolean re=false;
		
		Properties p=new Properties();
		p.load(HtmlGenerator.class.getResourceAsStream("/com/red/util/html.properties"));
		//p.load(new FileInputStream("html.properties"));
		                            
		String orgStr=p.getProperty(redalis);
		String targ=null;
		if(null!=orgStr)
		{
			targ=MessageFormat.format(orgStr,param);
		}
	
		String []strpa=targ.split("&&&");
		if(null!=strpa&&strpa.length==2)
		{
		   String fileName=strpa[1];
		   if(!(File.separatorChar=='/'))
		   {
			 fileName=fileName.replace('/', File.separatorChar);  
		   }
		   File tem=new File(fileName);
		   if(null!=tem&&tem.exists())tem.delete();
		   re=createHtmlPage(strpa[0], fileName);
		}
	
		
		return re;
	}
	
	//���Է���
	public static void main(String[] args) throws FileNotFoundException, IOException{
	 //	HtmlGenerator h = new HtmlGenerator("");
		//h.createHtmlPage("http://www.qq.com","c:/b.html");
		// HtmlGenerator h = new HtmlGenerator("");
		//h.createHtmlPage("http://localhost:8080/red_www/redhtml/articleContent?article.id=19","c:/b.html");	
		HtmlGenerator h = new HtmlGenerator("");
		h.createRedHtml("articleContent", "aaa","bbb","ccc");
		
		//String ss="<p>��˵����&nbsp;&nbsp;&nbsp; �ǲ����������������ǹ���</p> <p>k���� </p> <p>j j j <br /> kdf&nbsp;&nbsp; jdf dsf <img  src=\"/ccitcms/upload/editor_pic/20100823171913343_small.jpg\" border=\"0\" /></p>";
	  // System.out.println(HtmlGenerator.htmlspecialchars(ss));
	}

}
