package kr.or.ddit.vo;

import java.io.Serializable;

public class Notice_FileVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8227276430483269352L;
	private String file_no;
	private String file_addr;
	private String notice_no;
	
	public String getFile_no() {
		return file_no;
	}
	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}
	public String getFile_addr() {
		return file_addr;
	}
	public void setFile_addr(String file_addr) {
		this.file_addr = file_addr;
	}
	public String getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
	}	
}
