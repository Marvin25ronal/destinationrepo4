package com.solucredit.models;

public class ConsentLetterReportDTO extends Report {
	// Aqui vamos a meter los datos extra que se necesitan
	private String fileName = "carta_consentimiento";

	public void setName(String extension) {
		this.setFileName(this.fileName + this.getExtension(extension));
	}
	public String getNameWithoutExtension() {
		return this.fileName;
	}
}
