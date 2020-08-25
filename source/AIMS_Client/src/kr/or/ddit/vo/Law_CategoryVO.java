package kr.or.ddit.vo;

import java.io.Serializable;

public class Law_CategoryVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -814197531862598045L;
	
	private String cat_law_no;
	private String cat_law_name;
	
	public String getCat_law_no() {
		return cat_law_no;
	}
	public void setCat_law_no(String cat_law_no) {
		this.cat_law_no = cat_law_no;
	}
	public String getCat_law_name() {
		return cat_law_name;
	}
	public void setCat_law_name(String cat_law_name) {
		this.cat_law_name = cat_law_name;
	}
}
