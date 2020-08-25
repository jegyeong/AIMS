package kr.or.ddit.vo;

import java.io.Serializable;

public class Answer_FileVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7717108093414507771L;
	private String ans_f_no;
	private String ans_f_addr;
	private String com_ans_no;
	
	public String getCom_ans_no() {
		return com_ans_no;
	}
	public void setCom_ans_no(String com_ans_no) {
		this.com_ans_no = com_ans_no;
	}
	public String getAns_f_no() {
		return ans_f_no;
	}
	public void setAns_f_no(String ans_f_no) {
		this.ans_f_no = ans_f_no;
	}
	public String getAns_f_addr() {
		return ans_f_addr;
	}
	public void setAns_f_addr(String ans_f_addr) {
		this.ans_f_addr = ans_f_addr;
	}
	
}
