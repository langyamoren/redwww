package com.red.action.admin;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.CourseType;

public class CourseTypeAction extends ActionBase{

	private static final long serialVersionUID = 5284437598574058273L;
	CourseType courseType;
	List<CourseType> courseTypeList=new ArrayList<CourseType>();
	
	public String browseCourseType()throws Exception
	{
		courseTypeList=courseService.getCourseTypeAll();
		return Action.SUCCESS;
	}
	
     public String addCourseType()throws Exception
     {
    	 if(null!=courseType&&null!=courseType.getName()&&!"".equals(courseType.getName()))
    	 {
    		 courseType.setSorts((byte)9);
    		     if(courseService.addCourseType(courseType))
    		    	 this.addActionMessage("�������ɹ�");
    		     else
    		    	 this.addActionError("�������ʧ��"); 
    	 }else
    	 {
    		 this.addActionError("����ȷ����������");
    	 }
    	 return browseCourseType();
     }
     public String updateCourseType()throws Exception
     {
    	 if(null!=courseType&&courseType.getId()>0)
    	 {
    		   CourseType old=courseService.getCourseTypeById(courseType.getId());
    		   old.setName(courseType.getName());
    		   old.setSorts(courseType.getSorts());
    		     if(courseService.updateCourseType(courseType))
    		    	 this.addActionMessage("�޸����ɹ�");
    		     else
    		    	 this.addActionError("�޸����ʧ��"); 
    	 }else
    	 {
    		 this.addActionError("����ȷ����������");
    	 }
    	 return browseCourseType();
     }
     
     public String deleteCourseType()throws Exception
     {
    	 if(null!=courseType&&courseType.getId()>0)
    	 {
    		     if(!courseService.hasCourse(courseType.getId())&&courseService.deleteCoutseTypeById(courseType.getId()))
    		    	 this.addActionMessage("ɾ�����ɹ�");
    		     else
    		    	 this.addActionError("ɾ�����ʧ��"); 
    	 }else
    	 {
    		 this.addActionError("����ȷ����������");
    	 }
    	 return browseCourseType();
     }

	public CourseType getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

	public List<CourseType> getCourseTypeList() {
		return courseTypeList;
	}

	public void setCourseTypeList(List<CourseType> courseTypeList) {
		this.courseTypeList = courseTypeList;
	}

	
     
}
