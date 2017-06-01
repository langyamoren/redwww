package com.red.action.web;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.red.action.ActionBase;
import com.red.beans.Chapter;

public class CourseContentAction extends ActionBase {

	private static final long serialVersionUID = 712291522115184186L;
    private Chapter chapter;
    private List<String> vodlist=new ArrayList<String>();
    private Integer chapNo;
	@Override
	public String execute() throws Exception 
	{
		if(null!=chapter&&chapter.getId()>0)
		{
			chapter=courseService.getChapterById(chapter.getId());
			
			if(null!=chapter.getVodPath()&&!"".equals(chapter.getVodPath().trim()))
			{
				String allvod=chapter.getVodPath();
				String [] spall=allvod.split("[|]{2}");
				for(String tem:spall)
				{
					if(tem.trim().length()>0)
					{
						vodlist.add(tem);
					}
				}
			}
		}
		return Action.SUCCESS;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	public List<String> getVodlist() {
		return vodlist;
	}
	public void setVodlist(List<String> vodlist) {
		this.vodlist = vodlist;
	}
	public Integer getChapNo() {
		return chapNo;
	}
	public void setChapNo(Integer chapNo) {
		this.chapNo = chapNo;
	}
    
}
