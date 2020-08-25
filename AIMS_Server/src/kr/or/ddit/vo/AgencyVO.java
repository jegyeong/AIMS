package kr.or.ddit.vo;

import java.io.Serializable;

public class AgencyVO implements Serializable {
	
	private String cou_no;
	private String cou_name;
	private String cou_loc;
	private String cou_tel;
	
	public String getCou_tel() {
		return cou_tel;
	}


	//생성자
	public AgencyVO() {	}
	
	//게더세더
	public String getCou_no() {
		return cou_no;
	}

	public void setCou_no(String cou_no) {
		this.cou_no = cou_no;
	}

	public String getCou_name() {
		return cou_name;
	}

	public void setCou_name(String cou_name) {
		this.cou_name = cou_name;
	}

	public String getCou_loc() {
		return cou_loc;
	}

	public void setCou_loc(String cou_loc) {
		this.cou_loc = cou_loc;
	}
	
	public void setCou_tel(String cou_tel) {
		this.cou_tel = cou_tel;
	}

	public AgencyVO(String cou_no, String cou_name, String cou_loc, String cou_tel) {
		super();
		this.cou_no = cou_no;
		this.cou_name = cou_name;
		this.cou_loc = cou_loc;
		this.cou_tel = cou_tel;
	}
	
	
	
	
	
	
	
	
	

}
