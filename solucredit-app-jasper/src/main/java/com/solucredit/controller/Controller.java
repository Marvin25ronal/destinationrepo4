package com.solucredit.controller;

import org.springframework.http.MediaType;

import com.solucredit.manager.ReportTypeEnum;

public abstract class Controller {
	public MediaType getMediaType(String type) {
		if (type.equalsIgnoreCase(ReportTypeEnum.EXCEL.toString())) {
			return MediaType.APPLICATION_OCTET_STREAM;
		} else if (type.equalsIgnoreCase(ReportTypeEnum.PDF.toString())) {
			return MediaType.APPLICATION_PDF;
		}
		return MediaType.APPLICATION_PDF;
	}
}
