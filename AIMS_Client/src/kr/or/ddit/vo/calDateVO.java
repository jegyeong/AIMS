package kr.or.ddit.vo;

import java.io.Serializable;

public class calDateVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1359931748880661967L;
	private String clickTitle,
				   clickCont;
	private int cal_num;

	public int getCal_num() {
		return cal_num;
	}

	public void setCal_num(int cal_num) {
		this.cal_num = cal_num;
	}
	
	//타이틀 넣는거??
	public String getClickTitle() {
		return clickTitle;
	}

	public void setClickTitle(String clickTitle) {
		this.clickTitle = clickTitle;
	}

	public String getClickCont() {
		return clickCont;
	}

	public void setClickCont(String clickCont) {
		this.clickCont = clickCont;
	}
	
}

