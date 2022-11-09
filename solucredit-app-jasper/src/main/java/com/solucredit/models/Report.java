package com.solucredit.models;

import java.io.ByteArrayInputStream;

import com.solucredit.manager.ReportTypeEnum;


public abstract class Report  {
	private String fileName;
	private ByteArrayInputStream stream;
	private int length;

	public String getExtension(String extension) {
		if (extension.equalsIgnoreCase(ReportTypeEnum.EXCEL.toString())) {
			return ".xlsx";
		} else if (extension.equalsIgnoreCase(ReportTypeEnum.PDF.toString())) {
			return ".pdf";
		}
		return ".pdf";
	}

	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ByteArrayInputStream getStream() {
		return stream;
	}

	public void setStream(ByteArrayInputStream stream) {
		this.stream = stream;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	public abstract void setName(String extension);
	public abstract String getNameWithoutExtension();
}
