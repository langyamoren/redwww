package com.red.dao;

import java.util.List;

import com.red.beans.Download;
import com.red.dao.base.RedCoreDao;
import com.red.page.PageDiv;

public interface DownloadDao  extends RedCoreDao<Download>
{
	 /**
	  * ͨ�����id������ص����أ�
	  * @param typeId
	  * @param count  Ҫ��ʾ������
	  * @return
	  */
	   public List<Download> getDownByType(Integer typeId,int count);
	   /**
	    * ͨ�����id����ʾ��ص�����
	    * @param typeId
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Download> getDownByType(Integer typeId,int offSet,int pageSize);
	   /**
		*ȡ���Ƽ�������
		*ispop=1
		* @param topCount
		* @return
		*/
	   public List<Download> getDownByPop(int topCount);
	   /**
		*ȡ���Ƽ�������
		*ispop=1
		* @param offSet ��ҳ��ʼ��¼  pageSizeÿҳ��¼��
		* @return
		*/
	   public PageDiv<Download> getDownByPop(int offSet,int pageSize);
	   /**
	    * ȡ���µ�����
	    * @param count
	    * @return
	    */
	   public List<Download> getDownByLast(int topCount);
	   /**
	    * ��ȡ���·���������
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Download> getDownByLast(int offSet,int pageSize);
        /**
         * ����ָ�����·���������
         * @param topCount
         * @return
         */
	   public List<Download> getDownByCount(int topCount);
	   /**
	    * ȡָ����������·���������
	    * @param typeId
	    * @param topCount
	    * @return
	    */
	   public List<Download> getDownTopByType(Integer typeId,Integer topCount);
	   /**
	    * �õ����·����Ŀγ�
	    * @param offSet
	    * @param pageSize
	    * @return
	    */
	   public PageDiv<Download> getDownByCount(int offSet,int pageSize);
	   
}
