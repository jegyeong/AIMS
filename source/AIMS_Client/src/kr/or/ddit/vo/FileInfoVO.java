package kr.or.ddit.vo;

import java.io.Serializable;

public class FileInfoVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4618311182689154984L;
	private String fileName;	// 파일이름
	private byte[] fileData;	// 파일내용
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
}
