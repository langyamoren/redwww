package com.red.service.base;

import com.red.dao.AdminDao;
import com.red.dao.AnswerDao;
import com.red.dao.ArticleDao;
import com.red.dao.ArticleTypeDao;
import com.red.dao.ChapterDao;
import com.red.dao.CourseDao;
import com.red.dao.CourseTypeDao;
import com.red.dao.DownTypeDao;
import com.red.dao.DownloadDao;
import com.red.dao.FinanceDao;
import com.red.dao.FocusDao;
import com.red.dao.MemberDao;
import com.red.dao.MemberlevelDao;
import com.red.dao.PasswordDao;
import com.red.dao.QuestionDao;
import com.red.dao.QuestionTypeDao;
public class ServiceTamlate //extends ServiceBaseImp
{
	protected AdminDao adminDao;
	protected AnswerDao answerDao;
	protected ArticleDao articleDao;
	protected ChapterDao chapterDao;
	protected CourseDao courseDao;
	protected CourseTypeDao  courseTypeDao;
	protected DownloadDao downloadDao;
	protected DownTypeDao downTypeDao;
	protected FinanceDao financeDao;
	protected FocusDao focusDao;
	protected MemberDao memberDao;
	protected MemberlevelDao memberlevelDao;
	protected QuestionDao questionDao;
	protected QuestionTypeDao questionTypeDao;
	protected ArticleTypeDao articleTypeDao;
	protected PasswordDao passwordDao;
	
	/**
	 * 提供一个通用操作的封装，减轻期它service上的压力
	 */

	public AdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	public AnswerDao getAnswerDao() {
		return answerDao;
	}
	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}
	public ArticleDao getArticleDao() {
		return articleDao;
	}
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	public ChapterDao getChapterDao() {
		return chapterDao;
	}
	public void setChapterDao(ChapterDao chapterDao) {
		this.chapterDao = chapterDao;
	}
	public CourseDao getCourseDao() {
		return courseDao;
	}
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	public CourseTypeDao getCourseTypeDao() {
		return courseTypeDao;
	}
	public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
		this.courseTypeDao = courseTypeDao;
	}
	public DownloadDao getDownloadDao() {
		return downloadDao;
	}
	public void setDownloadDao(DownloadDao downloadDao) {
		this.downloadDao = downloadDao;
	}
	public DownTypeDao getDownTypeDao() {
		return downTypeDao;
	}
	public void setDownTypeDao(DownTypeDao downTypeDao) {
		this.downTypeDao = downTypeDao;
	}
	public FinanceDao getFinanceDao() {
		return financeDao;
	}
	public void setFinanceDao(FinanceDao financeDao) {
		this.financeDao = financeDao;
	}
	public FocusDao getFocusDao() {
		return focusDao;
	}
	public void setFocusDao(FocusDao focusDao) {
		this.focusDao = focusDao;
	}
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public MemberlevelDao getMemberlevelDao() {
		return memberlevelDao;
	}
	public void setMemberlevelDao(MemberlevelDao memberlevelDao) {
		this.memberlevelDao = memberlevelDao;
	}
	public QuestionDao getQuestionDao() {
		return questionDao;
	}
	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	public QuestionTypeDao getQuestionTypeDao() {
		return questionTypeDao;
	}
	public void setQuestionTypeDao(QuestionTypeDao questionTypeDao) {
		this.questionTypeDao = questionTypeDao;
	}
	public ArticleTypeDao getArticleTypeDao() {
		return articleTypeDao;
	}
	public void setArticleTypeDao(ArticleTypeDao articleTypeDao) {
		this.articleTypeDao = articleTypeDao;
	}
	public PasswordDao getPasswordDao() {
		return passwordDao;
	}
	public void setPasswordDao(PasswordDao passwordDao) {
		this.passwordDao = passwordDao;
	}

}
