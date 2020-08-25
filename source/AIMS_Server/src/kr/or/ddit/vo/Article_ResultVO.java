package kr.or.ddit.vo;

import java.io.Serializable;
// 경매 겷과 
public class Article_ResultVO implements Serializable{
	private String RES_NO;
	private String A_ART_NO;
	private String MEM_ID;
	private String RES_WON;
	private String RES_STATE;
	private String RES_DATE;
	public String getRES_NO() {
		return RES_NO;
	}
	public void setRES_NO(String rES_NO) {
		RES_NO = rES_NO;
	}
	public String getA_ART_NO() {
		return A_ART_NO;
	}
	public void setA_ART_NO(String a_ART_NO) {
		A_ART_NO = a_ART_NO;
	}
	public String getMEM_ID() {
		return MEM_ID;
	}
	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}
	public String getRES_WON() {
		return RES_WON;
	}
	public void setRES_WON(String rES_WON) {
		RES_WON = rES_WON;
	}
	public String getRES_STATE() {
		return RES_STATE;
	}
	public void setRES_STATE(String rES_STATE) {
		RES_STATE = rES_STATE;
	}
	public String getRES_DATE() {
		return RES_DATE;
	}
	public void setRES_DATE(String rES_DATE) {
		RES_DATE = rES_DATE;
	}
	
	
	
}
