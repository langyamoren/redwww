package com.red.dao;

import java.util.List;

import com.red.beans.Download;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;

public interface DownloadDao  extends RedCoreDao<Download>
{
	 /**
	  * 通过类别id查找相关的下载，
	  * @param typeId
	  * @param count  要显示的条数
	  * @return
	  */
	   public List<Download> getDownByType(Integer typeId,int count);
	   /**
	    * 通过类别id分显示相关的下载
	    * @param typeId
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Download> getDownByType(Integer typeId,int offSet,int pageSize);
	   /**
		*取出推荐的下载
		*ispop=1
		* @param topCount
		* @return
		*/
	   public List<Download> getDownByPop(int topCount);
	   /**
		*取出推荐的下载
		*ispop=1
		* @param offSet 分页起始记录  pageSize每页记录数
		* @return
		*/
	   public PageDiv<Download> getDownByPop(int offSet,int pageSize);
	   /**
	    * 取最新的下载
	    * @param count
	    * @return
	    */
	   public List<Download> getDownByLast(int topCount);
	   /**
	    * 获取最新发布的下载
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Download> getDownByLast(int offSet,int pageSize);
        /**
         * 查找指定最新发布的下载
         * @param topCount
         * @return
         */
	   public List<Download> getDownByCount(int topCount);
	   /**
	    * 取指定类别下最新发布的下载
	    * @param typeId
	    * @param topCount
	    * @return
	    */
	   public List<Download> getDownTopByType(Integer typeId,Integer topCount);
	   /**
	    * 得到最新发布的课程
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Download> getDownByCount(int offSet,int pageSize);
	   
}
