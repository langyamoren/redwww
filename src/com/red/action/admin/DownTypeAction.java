package com.red.action.admin;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.DownType;

public class DownTypeAction extends ActionBase{

	private static final long serialVersionUID = 68369983575877820L;
	DownType downType;
	List<DownType> downList=new ArrayList<DownType>();
	
	public String browseDownType()throws Exception
	{
		downList=downloadService.getTypesAll();
		return Action.SUCCESS;
	}
	
     public String addDownType()throws Exception
     {
    	 if(null!=downType&&null!=downType.getName()&&!"".equals(downType.getName()))
    	 {
    		 downType.setSorts((byte)9);
    		     if(downloadService.addDownType(downType))
    		    	 this.addActionMessage("�������ɹ�");
    		     else
    		    	 this.addActionError("�������ʧ��"); 
    	 }else
    	 {
    		 this.addActionError("����ȷ����������");
    	 }
    	 return browseDownType();
     }
     public String updateDownType()throws Exception
     {
    	 if(null!=downType&&downType.getId()>0)
    	 {
    		   DownType old=downloadService.getDownType(downType.getId());
    		   old.setName(downType.getName());
    		   old.setSorts(downType.getSorts());
    		     if(downloadService.updateDownType(downType))
    		    	 this.addActionMessage("�޸����ɹ�");
    		     else
    		    	 this.addActionError("�޸����ʧ��"); 
    	 }else
    	 {
    		 this.addActionError("����ȷ����������");
    	 }
    	 return browseDownType();
     }
     
     public String deleteDownType()throws Exception
     {
    	 if(null!=downType&&downType.getId()>0)
    	 {
    		     if(!downloadService.hasDownload(downType.getId())&&downloadService.deleteDownTypeById(downType.getId()))
    		    	 this.addActionMessage("ɾ�����ɹ�");
    		     else
    		    	 this.addActionError("ɾ�����ʧ��"); 
    	 }else
    	 {
    		 this.addActionError("����ȷ����������");
    	 }
    	 return browseDownType();
     }

	public DownType getDownType() {
		return downType;
	}

	public void setDownType(DownType downType) {
		this.downType = downType;
	}

	public List<DownType> getDownList() {
		return downList;
	}

	public void setDownList(List<DownType> downList) {
		this.downList = downList;
	}
     
}
