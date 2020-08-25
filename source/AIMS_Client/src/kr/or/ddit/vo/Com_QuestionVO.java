package kr.or.ddit.vo;

import java.io.Serializable;

public class Com_QuestionVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6861828164776515918L;
	private String com_que_no;
	private String com_que_title;
	private String com_que_content;
	private String com_que_writeid;
	private String com_que_writeday;
	private String cat_a_no;
	
	public String getCom_que_no() {
		return com_que_no;
	}
	public void setCom_que_no(String com_que_no) {
		this.com_que_no = com_que_no;
	}
	public String getCom_que_title() {
		return com_que_title;
	}
	public void setCom_que_title(String com_que_title) {
		this.com_que_title = com_que_title;
	}
	public String getCom_que_content() {
		return com_que_content;
	}
	public void setCom_que_content(String com_que_content) {
		this.com_que_content = com_que_content;
	}
	public String getCom_que_writeid() {
		return com_que_writeid;
	}
	public void setCom_que_writeid(String com_que_writeid) {
		this.com_que_writeid = com_que_writeid;
	}
	public String getCom_que_writeday() {
		return com_que_writeday;
	}
	public void setCom_que_writeday(String com_que_writeday) {
		this.com_que_writeday = com_que_writeday;
	}
	public String getCat_a_no() {
		return cat_a_no;
	}
	public void setCat_a_no(String cat_a_no) {
		this.cat_a_no = cat_a_no;
	}
}
