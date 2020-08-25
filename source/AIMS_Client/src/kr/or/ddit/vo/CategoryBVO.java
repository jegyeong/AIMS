package kr.or.ddit.vo;

import java.io.Serializable;

public class CategoryBVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6491648013422893208L;
	private String cat_b_no;
	private String cat_b_name;
	private String cat_a_no;
	
	

	public String getCat_b_no() {
		return cat_b_no;
	}

	public void setCat_b_no(String cat_b_no) {
		this.cat_b_no = cat_b_no;
	}

	public String getCat_b_name() {
		return cat_b_name;
	}

	public void setCat_b_name(String cat_b_name) {
		this.cat_b_name = cat_b_name;
	}

	public String getCat_a_no() {
		return cat_a_no;
	}

	public void setCat_a_no(String cat_a_no) {
		this.cat_a_no = cat_a_no;
	}
	
	
	
}
