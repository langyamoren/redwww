package com.red.dao;

import java.util.List;

import com.red.beans.Chapter;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;

public interface ChapterDao extends RedCoreDao<Chapter>{
	
     /**
      * ȡ��ĳ�γ��£����·����Ŀγ�С��
      * @param courseId   �γ�id
      * @param topCount   Ҫ��ʾ��С����
      * @return
      */
	   public List<Chapter> getChapterByCourseTopCount(Integer courseId,Integer topCount);
	   /**
	    * ͨ���γ�idȡ�����пγ�����
	    * @param courseId
	    * @return
	    */
	  public List<Chapter> getChapterByCourseId(Integer courseId);
	   /**
	    * ͨ���γ�idȡ���γ�����
	    * @param courseId
	    * @return
	    */
	   public PageDiv<Chapter> getChapterByCourseId(Integer courseId,int offSet,int pageSize);
	   
	   
	   /**
	    * �������·����Ŀγ̽�
	    * @param count  ��ʾ������
	    * @return
	    */
	   public List<Chapter> getLastChapter(int count); 
	   
	   /**
	    * �жϿγ��»�û���½�
	    * @param courseid �γ�id
	    */
	   public boolean hasChapter(Integer courseId);
}
