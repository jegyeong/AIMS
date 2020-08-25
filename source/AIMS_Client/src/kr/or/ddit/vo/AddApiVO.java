package kr.or.ddit.vo;

import java.io.Serializable;

public class AddApiVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7839589484878477810L;
	private String zipNo;
	private String adres;
	
	

	public String getZipNo() {
		return zipNo;
	}

	public void setZipNo(String zipNo) {
		this.zipNo = zipNo;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	
	
	
}
