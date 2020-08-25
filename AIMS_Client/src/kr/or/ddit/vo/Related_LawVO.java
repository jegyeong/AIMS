package kr.or.ddit.vo;

import java.io.Serializable;

public class Related_LawVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7824156533249550833L;
	private String rel_l_no;
	private String cat_law_no;
	private String rel_l_title;
	private String rel_l_question;
	private String rel_l_answer;
	
	
	public String getRel_l_no() {
		return rel_l_no;
	}
	public void setRel_l_no(String rel_l_no) {
		this.rel_l_no = rel_l_no;
	}
	public String getCat_law_no() {
		return cat_law_no;
	}
	public void setCat_law_no(String car_law_no) {
		this.cat_law_no = car_law_no;
	}
	public String getRel_l_title() {
		return rel_l_title;
	}
	public void setRel_l_title(String rel_l_title) {
		this.rel_l_title = rel_l_title;
	}
	public String getRel_l_question() {
		return rel_l_question;
	}
	public void setRel_l_question(String rel_l_question) {
		this.rel_l_question = rel_l_question;
	}
	public String getRel_l_answer() {
		return rel_l_answer;
	}
	public void setRel_l_answer(String rel_l_answer) {
		this.rel_l_answer = rel_l_answer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
