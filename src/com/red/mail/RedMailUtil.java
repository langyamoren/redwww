package com.red.mail;

import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class RedMailUtil
{
	  private JavaMailSenderImpl sender;
	  private String from ;
	
	public boolean sendMail(String to,String subject,String htmlFile,String ... params)
	{
		boolean re=false;
		try 
		{
			MimeMessage mailMessage = sender.createMimeMessage();
			MimeMessageHelper messageHelper =  new MimeMessageHelper(mailMessage, true); 
			messageHelper.setTo(to); 
			messageHelper.setFrom(from); 
			messageHelper.setSubject(subject);
			String content=ParseFileToMailContent.parseHtmlToConent(htmlFile);
			for(int i=0;i<params.length;i++)
			{
				content=content.replaceAll("###"+i+"###", params[i]);
			}
			
			messageHelper.setText(content, true);     
			//FileSystemResource file = new FileSystemResource(new File("d:/test.rar"));
			// messageHelper.addAttachment("test.rar", file); 
			sender.send(mailMessage); 
			re=true;
		} catch (Exception e) {
		   System.out.println("发送邮件失败！");
		   e.printStackTrace();
		}
		return re;	
	}


	public JavaMailSenderImpl getSender() {
		return sender;
	}
	public void setSender(JavaMailSenderImpl sender) {
		this.sender = sender;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	/*public static void main(String[] args) 
	{
		 
		JavaMailSenderImpl sender =new JavaMailSenderImpl();
		sender.setDefaultEncoding("GB18030");
		sender.setHost("smtp.163.com");
		sender.setUsername("redwww");
		sender.setPassword("redwww_com_888");
		RedMailUtil ru=new RedMailUtil();
		ru.setSender(sender);
		ru.setFrom("redwww@163.com");
		Object [] mailParam=new Object[]{"liuhut","langyamoren@163.com","12345"};
   	    System.out.println(ru.sendMail("langyamoren@163.com", "红萌网用户注册确认信", "welcome_regist.html",mailParam));  
		//System.out.println(ru.sendMail("langyamoren@163.com", "测试来自网络", ParseFileToMailContent.parseHtmlToConent("pay_money.html")));
	}*/
}
