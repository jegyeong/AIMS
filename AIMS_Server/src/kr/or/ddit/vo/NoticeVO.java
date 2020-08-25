package kr.or.ddit.vo;

import java.io.Serializable;

public class NoticeVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5314746891906751126L;
	private String notice_no;
	private String notice_title;
	private String notice_date;
	private String notice_writer;
	private String notice_content;
	private int notice_cnt;
	

	public String getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}
	public String getNotice_writer() {
		return notice_writer;
	}
	public void setNotice_writer(String notice_writer) {
		this.notice_writer = notice_writer;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}	
	public int getNotice_cnt() {
		return notice_cnt;
	}
	public void setNotice_cnt(int notice_cnt) {
		this.notice_cnt = notice_cnt;
	}
}
