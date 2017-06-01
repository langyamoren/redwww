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

	
	/**********************************�����ط���****************************************/
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
			  log.info("[DownloadServiceImp]:addDownType:������ɹ���"+types.getName());
		} catch (Exception e) 
		{
			re=false;
			  log.error("[DownloadServiceImp]:addDownType:����������ʧ��!:"+e.getMessage());
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
			log.info("[DownloadServiceImp]:deleteDownTypeById:ɾ �����ɹ�!"+id);
		} catch (Exception e) {
			log.error("[DownloadServiceImp]:deleteDownTypeById:ɾ���������ʧ��!:"+e.getMessage());
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
				
			    if(types.getId()>0) //ֻ��id����0ʱ�ſɸ���
			    {
			    	tem.setName(types.getName());
			    	tem.setSorts(types.getSorts());
			    	downTypeDao.update(tem);
			    	re=true;
			    	log.info("[DownloadServiceImp]:updateDownType:�����������"+types.getId()+"�ɹ���");
			    }
				
			} catch (Exception e) {
			    log.error("[DownloadServiceImp]:updateDownType:�����������ʧ�ܣ�"+e.getMessage());
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

	/**********************************������ط���****************************************/
	@Override
	public boolean addDownload(Download download) {
		boolean re=false;
		try {
			Assert.notNull(download);
			//�ж�����id
		
			if(null!=download.getDownType()&&null!=download.getDownType().getId()&&download.getDownType().getId()>0)
			{
			   // download.setDescs(HtmlRegexpUtil.toHtml(download.getDescs()));
				DownType dt=downTypeDao.get(DownType.class, download.getDownType().getId());
				download.setDownType(dt);
				downloadDao.save(download);	//���
			}else
			{
				log.error("[DownloadServiceImp]:addDownload:���������Ϊ�գ�");
				return false;	
			}
			re=true;
			log.info("[DownloadServiceImp]:addDownload:������سɹ���"+download.getId());
		} catch (Exception e)
		{
		    log.error("[DownloadServiceImp]:addDownload:�������ʧ�ܣ�"+e.getMessage());
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
			log.info("[DownloadServiceImp]:deletyDownloadById:ɾ�����سɹ�"+id);
		} catch (Exception e)
		{
		   log.error("[DownloadServiceImp]:deletyDownloadById:ɾ������ʧ�ܣ�"+id+"\t"+e.getMessage());
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
			log.info("[DownloadServiceImp]:updateDownload���޸�����"+download.getId()+"�ɹ���");
		} catch (Exception e) {
		    log.error("[DownloadServiceImp]:updateDownload��ɾ������"+download.getId()+"ʧ��!"+e.getMessage());
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
	    	log.info("[DownloadServiceImp]:deleteBatchById:����ɾ�����سɹ���");
		} catch (Exception e) {
			log.error("[DownloadServiceImp]:deleteBatchById:����ɾ������ʧ�ܣ�"+e.getMessage());
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
