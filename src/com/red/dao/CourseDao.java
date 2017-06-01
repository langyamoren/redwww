package com.red.dao;

import java.util.List;

import com.red.beans.Course;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;

public interface CourseDao extends RedCoreDao<Course>{

	   /**
	    * ��ȡҪ��ʾ�Ŀγ̣���������ҳ
	    * @param count Ҫ��ʾ������
	    * @return
	    */
	   public List<Course> getCourseByTop(int count);
	   /**
	    * ��ȡ���пγ̣���ҳ��ʾ
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Course> getCourseByPage(int offSet ,int pageSize);
	   /**
	    * ���ݿγ���������ȡ���пγ̣���sort����������
	    * 
	    * @param typeId
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   
	   public PageDiv<Course> getCourseByType(int typeId,int offSet ,int pageSize);
	   /**
	    * ��ȡ�Ƽ��Ŀγ̣���sort��������
	    * @param topCount   Ҫ��ʾ���Ƽ��γ���
	    * @return
	    */
	   public List<Course> getCourseByRecom(int topCount);
	   /**
	    * ͨ���ؼ�����������صĿγ�
	    * @param keyword
	    * @param topCount
	    * @return
	    */
	   
	   public List<Course> getCourseByKeyword(String keyword,int topCount);
 
}
