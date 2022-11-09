package com.solucredit.models;

public class ConsentLegalLetterReportDTO extends Report {
	private String fileName = "carta_consentimiento_juridico";

	@Override
	public void setName(String extension) {
		this.setFileName(this.fileName + this.getExtension(extension));
	}

	@Override
	public String getNameWithoutExtension() {
		// TODO Auto-generated method stub
		return this.fileName;
	}

}
