package com.red.service.imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import com.red.beans.DownType;
import com.red.beans.Download;
import com.red.page.PageDiv;
import com.red.service.DownloadService;
import com.red.service.base.ServiceTamlate;

public class DownloadServiceImp extends ServiceTamlate implements
		DownloadService {
	public static final Logger log=Logger.getLogger(CourseServiceImp.class);

	
	/**********************************类别相关方法****************************************/
	@Override
	public List<DownType> getTypesAll() {
		// TODO Auto-generated method stub
		return downTypeDao.getAllDownType();
	}

	@Override
	public boolean addDownType(DownType types) {
	   boolean re=false;
	   try {
			   if(null==types.getSorts()||types.getSorts()<0||types.getSorts()>9)
			   {
				   types.setSorts((byte)9);
			   }
			   downTypeDao.save(types);
			  re=true;
			  log.info("[DownloadServiceImp]:addDownType:添加类别成功！"+types.getName());
		} catch (Exception e) 
		{
			re=false;
			  log.error("[DownloadServiceImp]:addDownType:添加问题类别失败!:"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean deleteDownTypeById(Integer id) {
		boolean re=false;
		try {
			if(0<id){downTypeDao.deleteById(DownType.class, id);}
			re=true;
			log.info("[DownloadServiceImp]:deleteDownTypeById:删 除类别成功!"+id);
		} catch (Exception e) {
			log.error("[DownloadServiceImp]:deleteDownTypeById:删除问题类别失败!:"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean updateDownType(DownType types) {
		 boolean re=false;
		    try {
				Assert.notNull(types);
				DownType tem=this.getDownType(types.getId());
				
			    if(types.getId()>0) //只有id大于0时才可更新
			    {
			    	tem.setName(types.getName());
			    	tem.setSorts(types.getSorts());
			    	downTypeDao.update(tem);
			    	re=true;
			    	log.info("[DownloadServiceImp]:updateDownType:更新问题类别"+types.getId()+"成功！");
			    }
				
			} catch (Exception e) {
			    log.error("[DownloadServiceImp]:updateDownType:更新问题类别失败！"+e.getMessage());
			    e.printStackTrace();
			}
			return re;
	}

	@Override
	public DownType getDownType(Integer id) {
		DownType tem=null;
		if(id>0)
		{
			tem=downTypeDao.get(DownType.class, id);
		}
		return tem;
	}

	@Override
	public boolean hasDownload(Integer typeId) {
		return downTypeDao.hasDown(typeId);
	}

	/**********************************下载相关方法****************************************/
	@Override
	public boolean addDownload(Download download) {
		boolean re=false;
		try {
			Assert.notNull(download);
			//判断类别的id
		
			if(null!=download.getDownType()&&null!=download.getDownType().getId()&&download.getDownType().getId()>0)
			{
			   // download.setDescs(HtmlRegexpUtil.toHtml(download.getDescs()));
				DownType dt=downTypeDao.get(DownType.class, download.getDownType().getId());
				download.setDownType(dt);
				downloadDao.save(download);	//添加
			}else
			{
				log.error("[DownloadServiceImp]:addDownload:文章类别不能为空！");
				return false;	
			}
			re=true;
			log.info("[DownloadServiceImp]:addDownload:添加下载成功！"+download.getId());
		} catch (Exception e)
		{
		    log.error("[DownloadServiceImp]:addDownload:添加下载失败！"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean deletyDownloadById(Integer id) {
		boolean re=false;
		try {
			downloadDao.deleteById(Download.class, id);
			re=true;
			log.info("[DownloadServiceImp]:deletyDownloadById:删除下载成功"+id);
		} catch (Exception e)
		{
		   log.error("[DownloadServiceImp]:deletyDownloadById:删除下载失败！"+id+"\t"+e.getMessage());
		   e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean updateDownload(Download download) {
		boolean re=false;
		try {
			downloadDao.update(download);
			re=true;
			log.info("[DownloadServiceImp]:updateDownload：修改文章"+download.getId()+"成功！");
		} catch (Exception e) {
		    log.error("[DownloadServiceImp]:updateDownload：删除文章"+download.getId()+"失败!"+e.getMessage());
		    e.printStackTrace();
		}
		return re;
	}

	@Override
	public Download getDownloadById(Integer id) {
		Download download=null;
		if(null!=id&&id>0)
		{
			download=downloadDao.get(Download.class, id);
		}
		return download;
	}

	@Override
	public boolean deleteBatchById(Integer... params) {
		boolean re=false;
	    try {
	    	for(Integer id:params)
	    	this.deletyDownloadById(id);
	    	re=true;
	    	log.info("[DownloadServiceImp]:deleteBatchById:批量删除下载成功！");
		} catch (Exception e) {
			log.error("[DownloadServiceImp]:deleteBatchById:批量删除下载失败！"+e.getMessage());
			e.printStackTrace();
		}
		return re;
	}
	
	
	
	@Override
	public List<Download> getPopsDownload(int topCount) {
		// TODO Auto-generated method stub
		return this.getDownloadDao().getDownByPop(topCount);
	}

	@Override
	public PageDiv<Download> getPopsDownload(int offSet, int pageSize) {
		// TODO Auto-generated method stub
		return this.getPopsDownload(offSet, pageSize);
	}

	@Override
	public List<Download> getLastDownload(int topCount) {
		// TODO Auto-generated method stub
		return downloadDao.getDownByLast(topCount);
	}

	@Override
	public PageDiv<Download> getLastDownload(int offSet, int pageSize) {
		// TODO Auto-generated method stub
		return this.getDownloadDao().getDownByLast(offSet, pageSize);
	}

	@Override
	public List<Download> getMoreDownload(int topCount) {
		// TODO Auto-generated method stub
		return this.getDownloadDao().getDownByCount(topCount);
	}

	@Override
	public PageDiv<Download> getMoreDownload(int offSet, int pageSize) {
		// TODO Auto-generated method stub
		return this.getDownloadDao().getDownByCount(offSet, pageSize);
	}

	@Override
	public PageDiv<Download> getMoreDownload(int typeId, int offSet,
			int pageSize) {
		// TODO Auto-generated method stub
		return this.getDownloadDao().getDownByType(typeId, offSet, pageSize);
	}

	@Override
	public List<Download> getDownTopByType(int typeId, int topCount) {
		// TODO Auto-generated method stub
		return this.getDownloadDao().getDownTopByType(typeId, topCount);
	}
	
	
}
