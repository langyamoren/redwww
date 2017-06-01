package com.red.intercepter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.red.beans.Admin;

/** session���ڡ���¼��Ч�Լ�������Ȩ����֤������ */
public class LoginedCheckInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -88049056621882087L;

	/** �������󲢽��е�¼��Ч����֤ */
	public String intercept(ActionInvocation ai) throws Exception {
		//ȡ�������URL
		String url = ServletActionContext.getRequest().getRequestURL().toString();
		String prim = null;
		Admin admin = null;
		int index = 0;
		//��֤Session�Ƿ����
		if(!ServletActionContext.getRequest().isRequestedSessionIdValid()){
			//session����,ת��session������ʾҳ,������ת����¼ҳ��
			//return "red_error";
			ServletActionContext.getResponse().sendRedirect("mred/mredlogin");
			return null;
		}else{
			//�Ե�¼��ע������ֱ�ӷ���,��������
			if (url.indexOf("mred/admin/admin_login")!=-1 || url.indexOf("mred/admin/admin_logout")!=-1){
				return ai.invoke();
			}else{
				admin = (Admin)ServletActionContext.getRequest().getSession().getAttribute("admin");
				//��֤�Ƿ��Ѿ���¼
				if (null==admin){
					//��δ��¼,��ת����¼ҳ��
					return "red_error";
				}else{
					//����ģ����Ȩ��λӳ��,���ֿ�����ǰ̨����������������������ռ�"/admin"��ʾ����
					if (url.indexOf("mred/admin/admin_")!=-1){//ϵͳ�û�����
						index = 2; //Ȩ��λΪ2
					}else if (url.matches("mred/article_type/._article_type")){//�������
						index = 3; //Ȩ��λΪ3
					}else if (url.matches("mred/article/._article")){//����
						index = 4; //Ȩ��λΪ4
					}else if (url.matches("mred/focus/focus_")){ //������
						index = 5; //Ȩ��λΪ5
					}else if (url.indexOf("mred/member/member_")!=-1){//��Ա�������
						index = 6; //Ȩ��λΪ6
					}else if (url.matches("/mred/download_type/._download_type")){//���ط������
						index = 7; //Ȩ��λΪ7
					}else if (url.matches("/mred/download/._download")){//���ع���
						index = 8; //Ȩ��λΪ8
					}else if (url.matches("mred/member/._password")){//�������
						index = 9; //Ȩ��λΪ9
					}else if (url.matches("mred/question_types/._question_types")){//�ʴ����
						index = 10; //Ȩ��λΪ10
					}else if(url.matches("mred/question/._question"))
					{
						index=11;//Ȩ��λΪ11   �ʴ����
					}else if(url.matches("mred/course/._course"))
					{
						index=12;//Ȩ��λΪ12   �γ̹���
					}else if(url.matches("mred/course/._course")||url.indexOf("mred/chapter/._chapter")!=-1)
					{
						index =13;//Ȩ��λΪ13   �γ����� ���ֵȹ���
					}else if(url.indexOf("mred/index")!=-1)
					{
						index=14;//��ӭҳ
					}else if(url.indexOf("mred/createHtml")!=-1)
					{
						index=15;//ҳ�澲̬��
					}else if(url.matches("mred/._duixian"))
					{
						index=16;//ҳ�澲̬��
					}
					//ȡ�õ�ǰ�û��Ĳ���Ȩ��
					prim = admin.getPrivileges().trim();
					//����Ȩ����֤
					if (index>0){
						if (prim.substring(0,1).equals("1") || prim.substring(index-1,index).equals("1")){
							//��֤ͨ��,����
							return ai.invoke();
						}else{
							//��֤ʧ��,ת��Ȩ����֤ʧ����ʾҳ
							return "havenopr";
						}
					}else{
						//��������ҪȨ����֤������ֱ�ӷ���
						return ai.invoke();
					}					
				}				
			}			
		}
	}
}