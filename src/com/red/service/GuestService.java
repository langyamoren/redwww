package com.red.service;

import java.util.List;

import com.red.beans.Article;
import com.red.beans.Chapter;
import com.red.beans.Course;
import com.red.beans.Download;
import com.red.beans.Focus;
import com.red.beans.Member;
import com.red.beans.Question;


/********************************1����ҳ********************************/
/**
 * һ��ǰ̨service����Ϊ��ҳ�ṩ����
 * @author Administrator
 *
 */
public interface GuestService // extends ServiceBase 
{
	/**
	 * ȡ����ҳ��Ҫ��ʾ��������������������
	 * @param count
	 * @return
	 */
   public List<Article> getNewsIndex(Integer articleTypeId,Integer topCount);
   /**
    * ȡ����ҳ����ʾ�Ľ���㣬���������ֶ�
    * @param count
    * @return
    */
   public List<Focus> getFocusIndex(int count);
   /**
    * ȡ����ҳ�Ϲ��棬���¸���id����
    * ��վ������������global_variable.properties��ȡ
    * @param count
    * @return
    */
   public List<Article> getNoticeIndex(int count);
   /**
    * ȡ����ҳ����ʾ�Ŀγ� ��Ϣ,���������ֶ�
    * @param count
    * @return
    */
   public List<Course> getCourseIndex(int count);
   /**
    * ȡ����ҳ����ʾ����������
    * @param count
    * @return
    */
   public List<Question> getQuestionIndex(int count);
   /**
    * �õ����¿γ� ��,
    * @param count
    * @return
    */
   public List<Chapter> getChapterIndex(int count);
   /**
    * ��ҳ��ʾ�����·����б�
    * @param typeId  ���id
    * @param count   ��ʾ����
    * @return
    */
   public List<Article> getArticleIndex(int typeId,int count);
   /**
    * ȡ���¿�ͨ�Ļ�Ա
    * @param topCount
    * @return
    */
   public List<Member> getMemberIndex(int topCount); 
   /**
    * ȡָ���������������
    * ��ʱ����
    * @param topCount
    * @return
    */
   /*
   public list<Links>  getIndexLinks(int topCount);
   */
   /**
    * ȡ����ҳ����ʾ�����أ����Ƽ����ȣ�Ȼ����id ��������
    */  
   public List<Download> getDownloadIndex(int topcCount);
   /**
    * ͨ���ؼ�������
    * @param keywords
    * @return
    */
   public List<Article> getArticleBySearche(String keywords,int offSet,int pageSize);
   /****************************************************************/
   
   
}
