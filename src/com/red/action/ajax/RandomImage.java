package com.red.action.ajax;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RandomImage extends ActionSupport
{
	/**
	 * 
	 */
	private String ran;
	
	public String getRan() {
		return ran;
	}
	public void setRan(String ran) {
		this.ran = ran;
	}
	private static final long serialVersionUID = -4133079794736023883L;
	//��֤��ͼƬ�Ŀ�ȡ�
    private int width=80;
    //��֤��ͼƬ�ĸ߶ȡ�
    private int height=30;
	@Override
	public String execute() throws Exception {
		 BufferedImage buffImg=new BufferedImage(width,height,
                 BufferedImage.TYPE_INT_RGB);
Graphics2D g=buffImg.createGraphics();

//����һ��������������ࡣ
Random random=new Random();

g.setColor(Color.WHITE);
g.fillRect(0,0,width,height);

//�������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������
Font font=new Font("Times New Roman",Font.PLAIN,22);
//�������塣
g.setFont(font);

//���߿�
g.setColor(Color.BLACK);
g.drawRect(0,0,width-1,height-1);

//�������160�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��
g.setColor(new Color(160,160,160));
for (int i=0;i<320;i++)
{
int x = random.nextInt(width);
int y = random.nextInt(height);
int xl = random.nextInt(12);
int yl = random.nextInt(12);
g.drawLine(x,y,x+xl,y+yl);
}


//randomCode���ڱ��������������֤�룬�Ա��û���¼�������֤��
StringBuffer randomCode=new StringBuffer();
int red=0,green=0,blue=0;

//�������4λ���ֵ���֤�롣
for (int i=0;i<4;i++)
{
//�õ������������֤�����֡�
String strRand=String.valueOf(random.nextInt(10));

//�����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ��
red=random.nextInt(255);
green=random.nextInt(10);
blue=random.nextInt(10);

//�������������ɫ����֤����Ƶ�ͼ���С�
g.setColor(new Color(red,green,blue));
g.drawString(strRand,13*i+12,23);

//���������ĸ�����������һ��
randomCode.append(strRand);
}
//����λ���ֵ���֤�뱣�浽Session�С�

//Map session=ActionContext.getContext().getSession();

ActionContext.getContext().getSession().put("randomCode",randomCode.toString());

HttpServletResponse resp=ServletActionContext.getResponse();

//��ֹͼ�񻺴档
resp.setHeader("Pragma","no-cache");
resp.setHeader("Cache-Control","no-cache");
resp.setDateHeader("Expires", 0);

resp.setContentType("image/jpeg");

//��ͼ�������Servlet������С�
ServletOutputStream sos=resp.getOutputStream();
ImageIO.write(buffImg, "jpeg",sos);
sos.close();
return null;
	}

}
