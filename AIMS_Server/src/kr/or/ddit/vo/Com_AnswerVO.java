package kr.or.ddit.vo;

import java.io.Serializable;

public class Com_AnswerVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1533184898089870022L;
	private String com_ans_no;
	private String com_ans_title;
	private String com_ans_content;
	private String com_ans_writeid;
	private String com_ans_writeday;
	
	public String getCom_ans_no() {
		return com_ans_no;
	}
	public void setCom_ans_no(String com_ans_no) {
		this.com_ans_no = com_ans_no;
	}
	public String getCom_ans_title() {
		return com_ans_title;
	}
	public void setCom_ans_title(String com_ans_title) {
		this.com_ans_title = com_ans_title;
	}
	public String getCom_ans_content() {
		return com_ans_content;
	}
	public void setCom_ans_content(String com_ans_content) {
		this.com_ans_content = com_ans_content;
	}
	public String getCom_ans_writeid() {
		return com_ans_writeid;
	}
	public void setCom_ans_writeid(String com_ans_writeid) {
		this.com_ans_writeid = com_ans_writeid;
	}
	public String getCom_ans_writeday() {
		return com_ans_writeday;
	}
	public void setCom_ans_writeday(String com_ans_writeday) {
		this.com_ans_writeday = com_ans_writeday;
	}
	
}
