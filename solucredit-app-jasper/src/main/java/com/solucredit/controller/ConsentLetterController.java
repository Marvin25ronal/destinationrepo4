package com.solucredit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solucredit.api.ConsentLetterService;

import com.solucredit.models.Report;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/consentletter")
public class ConsentLetterController extends Controller {
	@Autowired
	private ConsentLetterService consentLetterService;

	@GetMapping("/individual")
	public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {
		Report dto =  consentLetterService.getReport(params);
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = this.getMediaType(params.get("type").toString());

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
	@GetMapping("/legal")
	public ResponseEntity<Resource> downloadletter(@RequestParam Map<String,Object> params)
			throws JRException, IOException, SQLException {
		Report dto =  consentLetterService.getConsentLetterLegal(params);
		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = this.getMediaType(params.get("type").toString());

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}
}
