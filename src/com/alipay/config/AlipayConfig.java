/* *
 *���ܣ������ʻ��й���Ϣ������·������������ҳ�棩
 *�汾��3.1
 *���ڣ�2010-11-01
 *˵����
 *���´���ֻ��Ϊ�˷����̻����Զ��ṩ���������룬�̻����Ը����Լ���վ����Ҫ�����ռ����ĵ���д,����һ��Ҫʹ�øô��롣
 *�ô������ѧϰ���о�֧�����ӿ�ʹ�ã�ֻ���ṩһ���ο���
	
 *��ʾ����λ�ȡ��ȫУ����ͺ��������ID
 *1.����֧������ҳ(www.alipay.com)��Ȼ��������ǩԼ֧�����˺ŵ�½.
 *2.����������еġ��̼ҷ��񡱣����ɲ鿴
	
 *��ȫУ����鿴ʱ������֧�������ҳ��ʻ�ɫ��������ô�죿
 *���������
 *1�������������ã������������������������
 *2���������������ԣ����µ�¼��ѯ��
 * */
package com.alipay.config;

import java.util.*;

public class AlipayConfig {
	// ��λ�ȡ��ȫУ����ͺ��������ID
	// 1.����֧�����̻���������(b.alipay.com)��Ȼ��������ǩԼ֧�����˺ŵ�½.
	// 2.���ʡ��������񡱡������ؼ��������ĵ�����https://b.alipay.com/support/helperApply.htm?action=selfIntegration��
	// 3.�ڡ��������ɰ������У���������������(Partner ID)��ѯ��������ȫУ����(Key)��ѯ��
	
	
	//�����������������������������������Ļ�����Ϣ������������������������������
	// ���������ID����2088��ͷ��16λ��������ɵ��ַ���
	public static String partner = "2088002040018755";
	
	// ���װ�ȫ�����룬�����ֺ���ĸ��ɵ�32λ�ַ���
	public static String key = "g98jz0628otp30cv18o960jkb8z8toxg";
	
	// ǩԼ֧�����˺Ż������տ�֧�����ʻ�
	public static String seller_email = "langyamoren@163.com";
	
	// notify_url ���׹����з�����֪ͨ��ҳ�� Ҫ�� http://��ʽ������·�����������?id=123�����Զ������
	//public static String notify_url = "http://www.redwww.com/red/";
	public static String notify_url ="http://www.redwww.com/red/notify_alipay";
	// ��������ת��ҳ�� Ҫ�� http://��ʽ������·�����������?id=123�����Զ������
	public static String return_url = "http://www.redwww.com/red/backpay_alipay";
	
	// ��վ��Ʒ��չʾ��ַ���������?id=123�����Զ������
	public static String show_url = "http://www.redwww.com";
	
	//�տ���ƣ��磺��˾���ơ���վ���ơ��տ���������
	public static String mainname = "������";	
	
	//�����������������������������������Ļ�����Ϣ������������������������������
	
	


	// �ַ������ʽ Ŀǰ֧�� gbk �� utf-8
	public static String input_charset = "gbk";
	
	// ǩ����ʽ �����޸�
	public static String sign_type = "MD5";
	
	//����ģʽ,�����Լ��ķ������Ƿ�֧��ssl���ʣ���֧����ѡ��https������֧����ѡ��http
	public static String transport = "http";
}
