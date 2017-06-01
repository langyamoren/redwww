package com.red.service;

import java.util.List;

import com.red.beans.DownType;
import com.red.beans.Download;
import com.red.page.PageDiv;


public interface DownloadService //extends ServiceBase
{
	
	
	 /****************************�����ط���**********************************/
	   public List<DownType> getTypesAll();
	   public boolean addDownType(DownType types);  //�������
	   public boolean deleteDownTypeById(Integer id);//ɾ �����
	   public boolean updateDownType(DownType types);//�������
	   public DownType getDownType(Integer id);//����һ�����ʵ��
	   public boolean hasDownload(Integer typeId);
	 /****************************������ط���**********************************/
	   
	   public boolean addDownload(Download download);
	   public boolean deletyDownloadById(Integer id);
	   public boolean updateDownload(Download download);
	   public Download getDownloadById(Integer id);
	   public boolean deleteBatchById(Integer...params);
	 /**
	  * ��ѯ�Ƽ�������
	  * @param topCount
	  * @return
	  */
	  public List<Download> getPopsDownload(int topCount);
	  public PageDiv<Download> getPopsDownload(int offSet,int pageSize);
	  /**
	   * ��ѯ���µ�����
	   * @param topCount
	   * @return
	   */
	  public List<Download> getLastDownload(int topCount);
	  public PageDiv<Download> getLastDownload(int offSet,int pageSize);
	  /**
	   * ���ش�������
	   * @param opCount
	   * @return
	   */
	  public List<Download> getMoreDownload(int opCount);
	  public List<Download> getDownTopByType(int typeId,int topCount);
	  public PageDiv<Download> getMoreDownload(int offSet,int pageSize);
	  public PageDiv<Download> getMoreDownload(int typeId,int offSet,int pageSize);

}
