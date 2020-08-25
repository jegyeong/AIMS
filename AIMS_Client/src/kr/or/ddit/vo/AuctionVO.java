package kr.or.ddit.vo;

import java.io.Serializable;

public class AuctionVO implements Serializable{
	private String auc_no;
	private String auc_price;
	private String mem_id;
	
//	private AuctionVO() {}
//
//	public AuctionVO(String auc_no, String auc_price, String mem_id) {
//		super();
//		this.auc_no = auc_no;
//		this.auc_price = auc_price;
//		this.mem_id = mem_id;
//	}

	public String getAuc_no() {
		return auc_no;
	}

	public void setAuc_no(String auc_no) {
		this.auc_no = auc_no;
	}

	public String getAuc_price() {
		return auc_price;
	}

	public void setAuc_price(String auc_price) {
		this.auc_price = auc_price;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	
}
