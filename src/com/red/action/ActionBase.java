package com.red.action;

import com.opensymphony.xwork2.ActionSupport;
import com.red.mail.RedMailUtil;
import com.red.service.AdminService;
import com.red.service.ArticleService;
import com.red.service.CourseService;
import com.red.service.DownloadService;
import com.red.service.GuestService;
import com.red.service.MemberService;
import com.red.service.QuestionService;
import com.red.service.SpaceService;

public class ActionBase extends ActionSupport
{

	private static final long serialVersionUID = 4661819933865565004L;
	protected AdminService adminService;
	protected ArticleService articleService;
	protected CourseService courseService;
	protected DownloadService downloadService;
	protected GuestService guestService;
	protected MemberService memberService;
	protected QuestionService questionService;
	protected SpaceService  spaceService;
	//Mailπ§æﬂ¿‡
	protected RedMailUtil  redMailUtil;
	
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public DownloadService getDownloadService() {
		return downloadService;
	}
	public void setDownloadService(DownloadService downloadService) {
		this.downloadService = downloadService;
	}
	public GuestService getGuestService() {
		return guestService;
	}
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}
	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public QuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	public SpaceService getSpaceService() {
		return spaceService;
	}
	public void setSpaceService(SpaceService spaceService) {
		this.spaceService = spaceService;
	}
	public RedMailUtil getRedMailUtil() {
		return redMailUtil;
	}
	public void setRedMailUtil(RedMailUtil redMailUtil) {
		this.redMailUtil = redMailUtil;
	}
	
	
}
