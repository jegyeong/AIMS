package kr.or.ddit.vo;

import java.io.Serializable;

public class CategoryCVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3944966241758953239L;
	private String cat_c_no;
	private String cat_c_name;
	private String cat_b_no;
	
	

	public String getCat_c_no() {
		return cat_c_no;
	}

	public void setCat_c_no(String cat_c_no) {
		this.cat_c_no = cat_c_no;
	}

	public String getCat_c_name() {
		return cat_c_name;
	}

	public void setCat_c_name(String cat_c_name) {
		this.cat_c_name = cat_c_name;
	}

	public String getCat_b_no() {
		return cat_b_no;
	}

	public void setCat_b_no(String cat_b_no) {
		this.cat_b_no = cat_b_no;
	}
	
	
	
}
