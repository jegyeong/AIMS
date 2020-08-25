package kr.or.ddit.vo;

import java.io.Serializable;

public class BlackListVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2803400702830029160L;
	private String mem_id;
	
	public BlackListVO() {}

	public BlackListVO(String mem_id) {
		super();
		this.mem_id = mem_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	
}
