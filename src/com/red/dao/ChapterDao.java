package com.red.dao;

import java.util.List;

import com.red.beans.Chapter;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;

public interface ChapterDao extends RedCoreDao<Chapter>{
	
     /**
      * 取得某课程下，最新发布的课程小节
      * @param courseId   课程id
      * @param topCount   要显示的小节数
      * @return
      */
	   public List<Chapter> getChapterByCourseTopCount(Integer courseId,Integer topCount);
	   /**
	    * 通过课程id取出所有课程内容
	    * @param courseId
	    * @return
	    */
	  public List<Chapter> getChapterByCourseId(Integer courseId);
	   /**
	    * 通过课程id取出课程内容
	    * @param courseId
	    * @return
	    */
	   public PageDiv<Chapter> getChapterByCourseId(Integer courseId,int offSet,int pageSize);
	   
	   
	   /**
	    * 查找最新发布的课程节
	    * @param count  显示的条数
	    * @return
	    */
	   public List<Chapter> getLastChapter(int count); 
	   
	   /**
	    * 判断课程下还没有章节
	    * @param courseid 课程id
	    */
	   public boolean hasChapter(Integer courseId);
}
