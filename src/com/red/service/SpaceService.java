package com.red.service;

import com.red.beans.Finance;
import com.red.beans.Member;
import com.red.beans.Password;
import com.red.beans.Question;
import com.red.page.PageDiv;

public interface SpaceService 
{
	
    /**
     * ��ѯ�û��Ĳ�����ϸ
     * @param memberId  �û�id
     * @param offset       
     * @param pageSize
     * @return
     */
    public PageDiv<Finance> getFinaceByMemberId(Integer memberId,int offset,int pageSize);
    /**
     * ��ѯ�Ƽ����û�
     * @param memberId   ���ѵ�id
     * @param offset
     * @param pageSize
     * @return
     */
    public PageDiv<Member> getRecomeMember(Integer memberId,int offset,int pageSize);
    /**
     * �鿴���ʵ�����
     * @param memberId  �û�id
     * @param offSet
     * @param pageSize
     * @return
     */
    public PageDiv<Question> getQuestions(Integer memberId,int offSet,int pageSize);
    
    /**
     * �޸��û�����
     * @param member
     * @return
     */
    public boolean updateMemberInfo(Member member);
    /**
     * �޸��û�����
     * @param memberId
     * @return
     */
    public Member getMemberById(Integer memberId);
    /**
     * ���Ӳ����
     * @param finance
     * @return
     */
    public boolean addFinance(Finance finance);
    /**
     * ���ݶ�������ѯ������ж����ݿ��Ƿ��Ѵ��ڴ˶�����
     * @param orderNo  ������
     * @return  ��true��û��false
     */
    public boolean orderExsit(String orderNo);
    /**
     * ��ֵ 
     * @param memberId  �û� id
     * @param fromAcount  ��Ǯ��֧���������ʺ�
     * @param orderAcount ���ȷ����Ķ�����
     * @param payAmount   ������Ǯ��
     * @param payType   0��Ǯ1֧����
     * @return
     */
    public boolean chunZhi(Integer memberId,String fromAcount,String orderAcount,Integer payMoney,Integer payType);
    public boolean payMoney(Member member,Integer vipPrice,Password pwd) ;
   /**
    * �������
    * @param member
    * @return
    */
    public boolean duixian(Member member);
}
