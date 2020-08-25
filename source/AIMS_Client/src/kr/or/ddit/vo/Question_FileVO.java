package kr.or.ddit.vo;

import java.io.Serializable;

public class Question_FileVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9209285899591055051L;
	private String que_f_no;
	private String que_f_addr;
	private String com_que_no;
	
	public String getCom_que_no() {
		return com_que_no;
	}
	public void setCom_que_no(String com_que_no) {
		this.com_que_no = com_que_no;
	}
	public String getQue_f_no() {
		return que_f_no;
	}
	public void setQue_f_no(String que_f_no) {
		this.que_f_no = que_f_no;
	}
	public String getQue_f_addr() {
		return que_f_addr;
	}
	public void setQue_f_addr(String que_f_addr) {
		this.que_f_addr = que_f_addr;
	}
	
}
