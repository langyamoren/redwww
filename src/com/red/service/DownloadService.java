package com.red.service;

import java.util.List;

import com.red.beans.DownType;
import com.red.beans.Download;
import com.red.page.PageDiv;


public interface DownloadService //extends ServiceBase
{
	
	
	 /****************************类别相关方法**********************************/
	   public List<DownType> getTypesAll();
	   public boolean addDownType(DownType types);  //增加类别
	   public boolean deleteDownTypeById(Integer id);//删 除类别
	   public boolean updateDownType(DownType types);//更新类别
	   public DownType getDownType(Integer id);//加载一个类别实体
	   public boolean hasDownload(Integer typeId);
	 /****************************下载相关方法**********************************/
	   
	   public boolean addDownload(Download download);
	   public boolean deletyDownloadById(Integer id);
	   public boolean updateDownload(Download download);
	   public Download getDownloadById(Integer id);
	   public boolean deleteBatchById(Integer...params);
	 /**
	  * 查询推荐的下载
	  * @param topCount
	  * @return
	  */
	  public List<Download> getPopsDownload(int topCount);
	  public PageDiv<Download> getPopsDownload(int offSet,int pageSize);
	  /**
	   * 查询最新的下载
	   * @param topCount
	   * @return
	   */
	  public List<Download> getLastDownload(int topCount);
	  public PageDiv<Download> getLastDownload(int offSet,int pageSize);
	  /**
	   * 下载次数最多的
	   * @param opCount
	   * @return
	   */
	  public List<Download> getMoreDownload(int opCount);
	  public List<Download> getDownTopByType(int typeId,int topCount);
	  public PageDiv<Download> getMoreDownload(int offSet,int pageSize);
	  public PageDiv<Download> getMoreDownload(int typeId,int offSet,int pageSize);

}
