package com.red.service;

import com.red.beans.Finance;
import com.red.beans.Member;
import com.red.beans.Password;
import com.red.beans.Question;
import com.red.page.PageDiv;

public interface SpaceService 
{
	
    /**
     * 查询用户的财务明细
     * @param memberId  用户id
     * @param offset       
     * @param pageSize
     * @return
     */
    public PageDiv<Finance> getFinaceByMemberId(Integer memberId,int offset,int pageSize);
    /**
     * 查询推荐的用户
     * @param memberId   自已的id
     * @param offset
     * @param pageSize
     * @return
     */
    public PageDiv<Member> getRecomeMember(Integer memberId,int offset,int pageSize);
    /**
     * 查看提问的问题
     * @param memberId  用户id
     * @param offSet
     * @param pageSize
     * @return
     */
    public PageDiv<Question> getQuestions(Integer memberId,int offSet,int pageSize);
    
    /**
     * 修改用户资料
     * @param member
     * @return
     */
    public boolean updateMemberInfo(Member member);
    /**
     * 修改用户资料
     * @param memberId
     * @return
     */
    public Member getMemberById(Integer memberId);
    /**
     * 增加财务表
     * @param finance
     * @return
     */
    public boolean addFinance(Finance finance);
    /**
     * 根据订单来查询财务表，判断数据库是否已存在此订单，
     * @param orderNo  订单号
     * @return  有true，没有false
     */
    public boolean orderExsit(String orderNo);
    /**
     * 充值 
     * @param memberId  用户 id
     * @param fromAcount  快钱或支付定交易帐号
     * @param orderAcount 红萌发生的订单号
     * @param payAmount   发生的钱数
     * @param payType   0快钱1支付宝
     * @return
     */
    public boolean chunZhi(Integer memberId,String fromAcount,String orderAcount,Integer payMoney,Integer payType);
    public boolean payMoney(Member member,Integer vipPrice,Password pwd) ;
   /**
    * 申请兑现
    * @param member
    * @return
    */
    public boolean duixian(Member member);
}
