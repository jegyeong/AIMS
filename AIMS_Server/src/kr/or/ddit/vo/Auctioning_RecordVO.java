package kr.or.ddit.vo;

import java.io.Serializable;

public class Auctioning_RecordVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3711641460707894286L;
	private String a_rec_no;
	private String mem_id;
	private String a_art_no;
	private String a_rec_price;
	private String a_rec_data;
	public String getA_rec_no() {
		return a_rec_no;
	}
	public void setA_rec_no(String a_rec_no) {
		this.a_rec_no = a_rec_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getA_art_no() {
		return a_art_no;
	}
	public void setA_art_no(String a_art_no) {
		this.a_art_no = a_art_no;
	}
	public String getA_rec_price() {
		return a_rec_price;
	}
	public void setA_rec_price(String a_rec_price) {
		this.a_rec_price = a_rec_price;
	}
	public String getA_rec_data() {
		return a_rec_data;
	}
	public void setA_rec_data(String a_rec_data) {
		this.a_rec_data = a_rec_data;
	}
}
