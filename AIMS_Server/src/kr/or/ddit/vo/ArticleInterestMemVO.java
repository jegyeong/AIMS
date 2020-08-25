package kr.or.ddit.vo;

import java.io.Serializable;

import javafx.collections.ObservableList;

// 내 경매 내역
public class ArticleInterestMemVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6839420972713410087L;
	private String A_ART_NO;
	private String A_ART_LOC;
	private String COU_NO;
	private String CAT_A_NO;
	private String CAT_B_NO;
	private String CAT_C_NO;
	private String A_ART_LOW;
	private String A_ART_AREA;
	private int A_ART_CNT;
	private String A_ART_INTER;
	private int A_ART_TOUR;
	private String A_ART_DAY;
	private String 	A_ART_RESULT;
	private String A_ART_NAME;
	private String 	A_ART_APPR;
	private int A_ART_PRICE;
	private	int A_ART_ADDNUM;
	private String int_no;
	private String mem_pass;
	private String mem_name;
	private String mem_addr;
	private String mem_tel;
	private String mem_email;
	private String mem_regno;

//	public ArticleInterestMemVO() {}
//
//	public ArticleInterestMemVO(String a_ART_NO, String a_ART_LOC, String cOU_NO, String cAT_A_NO, String cAT_B_NO,
//			String cAT_C_NO, String a_ART_LOW, String a_ART_AREA, int a_ART_CNT, String a_ART_INTER, int a_ART_TOUR,
//			String a_ART_DAY, String a_ART_RESULT, String a_ART_NAME, String a_ART_APPR, int a_ART_PRICE,
//			int a_ART_ADDNUM, String int_no, String mem_pass, String mem_name, String mem_addr, String mem_tel,
//			String mem_email, String mem_regno) {
//		super();
//		this.A_ART_NO = a_ART_NO;
//		this.A_ART_LOC = a_ART_LOC;
//		this.COU_NO = cOU_NO;
//		this.CAT_A_NO = cAT_A_NO;
//		this.CAT_B_NO = cAT_B_NO;
//		this.CAT_C_NO = cAT_C_NO;
//		this.A_ART_LOW = a_ART_LOW;
//		this.A_ART_AREA = a_ART_AREA;
//		this.A_ART_CNT = a_ART_CNT;
//		this.A_ART_INTER = a_ART_INTER;
//		this.A_ART_TOUR = a_ART_TOUR;
//		this.A_ART_DAY = a_ART_DAY;
//		this.A_ART_RESULT = a_ART_RESULT;
//		this.A_ART_NAME = a_ART_NAME;
//		this.A_ART_APPR = a_ART_APPR;
//		this.A_ART_PRICE = a_ART_PRICE;
//		this.A_ART_ADDNUM = a_ART_ADDNUM;
//		this.int_no = int_no;
//		this.mem_pass = mem_pass;
//		this.mem_name = mem_name;
//		this.mem_addr = mem_addr;
//		this.mem_tel = mem_tel;
//		this.mem_email = mem_email;
//		this.mem_regno = mem_regno;
//	}

	public String getA_ART_NO() {
		return A_ART_NO;
	}

	public void setA_ART_NO(String a_ART_NO) {
		A_ART_NO = a_ART_NO;
	}

	public String getA_ART_LOC() {
		return A_ART_LOC;
	}

	public void setA_ART_LOC(String a_ART_LOC) {
		A_ART_LOC = a_ART_LOC;
	}

	public String getCOU_NO() {
		return COU_NO;
	}

	public void setCOU_NO(String cOU_NO) {
		COU_NO = cOU_NO;
	}

	public String getCAT_A_NO() {
		return CAT_A_NO;
	}

	public void setCAT_A_NO(String cAT_A_NO) {
		CAT_A_NO = cAT_A_NO;
	}

	public String getCAT_B_NO() {
		return CAT_B_NO;
	}

	public void setCAT_B_NO(String cAT_B_NO) {
		CAT_B_NO = cAT_B_NO;
	}

	public String getCAT_C_NO() {
		return CAT_C_NO;
	}

	public void setCAT_C_NO(String cAT_C_NO) {
		CAT_C_NO = cAT_C_NO;
	}

	public String getA_ART_LOW() {
		return A_ART_LOW;
	}

	public void setA_ART_LOW(String a_ART_LOW) {
		A_ART_LOW = a_ART_LOW;
	}

	public String getA_ART_AREA() {
		return A_ART_AREA;
	}

	public void setA_ART_AREA(String a_ART_AREA) {
		A_ART_AREA = a_ART_AREA;
	}

	public int getA_ART_CNT() {
		return A_ART_CNT;
	}

	public void setA_ART_CNT(int a_ART_CNT) {
		A_ART_CNT = a_ART_CNT;
	}

	public String getA_ART_INTER() {
		return A_ART_INTER;
	}

	public void setA_ART_INTER(String a_ART_INTER) {
		A_ART_INTER = a_ART_INTER;
	}

	public int getA_ART_TOUR() {
		return A_ART_TOUR;
	}

	public void setA_ART_TOUR(int a_ART_TOUR) {
		A_ART_TOUR = a_ART_TOUR;
	}

	public String getA_ART_DAY() {
		return A_ART_DAY;
	}

	public void setA_ART_DAY(String a_ART_DAY) {
		A_ART_DAY = a_ART_DAY;
	}

	public String getA_ART_RESULT() {
		return A_ART_RESULT;
	}

	public void setA_ART_RESULT(String a_ART_RESULT) {
		A_ART_RESULT = a_ART_RESULT;
	}

	public String getA_ART_NAME() {
		return A_ART_NAME;
	}

	public void setA_ART_NAME(String a_ART_NAME) {
		A_ART_NAME = a_ART_NAME;
	}

	public String getA_ART_APPR() {
		return A_ART_APPR;
	}

	public void setA_ART_APPR(String a_ART_APPR) {
		A_ART_APPR = a_ART_APPR;
	}

	public int getA_ART_PRICE() {
		return A_ART_PRICE;
	}

	public void setA_ART_PRICE(int a_ART_PRICE) {
		A_ART_PRICE = a_ART_PRICE;
	}

	public int getA_ART_ADDNUM() {
		return A_ART_ADDNUM;
	}

	public void setA_ART_ADDNUM(int a_ART_ADDNUM) {
		A_ART_ADDNUM = a_ART_ADDNUM;
	}

	public String getInt_no() {
		return int_no;
	}

	public void setInt_no(String int_no) {
		this.int_no = int_no;
	}

	public String getMem_pass() {
		return mem_pass;
	}

	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_addr() {
		return mem_addr;
	}

	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}

	public String getMem_tel() {
		return mem_tel;
	}

	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_regno() {
		return mem_regno;
	}

	public void setMem_regno(String mem_regno) {
		this.mem_regno = mem_regno;
	}

	public static void setItems(ObservableList<ArticleInterestMemVO> data) {
		// TODO Auto-generated method stub
		
	}
	
	
}
