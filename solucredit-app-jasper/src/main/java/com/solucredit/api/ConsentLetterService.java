package com.solucredit.api;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solucredit.manager.JasperReportManager;
import com.solucredit.models.ConsentLegalLetterReportDTO;
import com.solucredit.models.ConsentLetterReportDTO;
import com.solucredit.models.Report;
import com.solucredit.models.ReportServiceInterface;

import net.sf.jasperreports.engine.JRException;

@Service
public class ConsentLetterService implements ReportServiceInterface {
	@Autowired
	private JasperReportManager reportManager;

//	@Autowired
//	private DataSource dataSource;

	@Override
	public Report getReport(Map<String, Object> params) throws JRException, IOException, SQLException {
		// TODO Auto-generated method stub
		Report consentLetterReport = new ConsentLetterReportDTO();
		consentLetterReport.setName(params.get("type").toString());
		ByteArrayOutputStream stream = reportManager.export(consentLetterReport.getNameWithoutExtension(),
				params.get("type").toString(), params,null);
		byte[] bs = stream.toByteArray();
		consentLetterReport.setStream(new ByteArrayInputStream(bs));
		consentLetterReport.setLength(bs.length);
		return consentLetterReport;
	}
	
	public Report getConsentLetterLegal(Map<String, Object> params) throws JRException, IOException, SQLException {
		Report consentLetterReport = new ConsentLegalLetterReportDTO();
		consentLetterReport.setName(params.get("type").toString());
		ByteArrayOutputStream stream = reportManager.export(consentLetterReport.getNameWithoutExtension(),
				params.get("type").toString(), params, null);
		byte[] bs = stream.toByteArray();
		consentLetterReport.setStream(new ByteArrayInputStream(bs));
		consentLetterReport.setLength(bs.length);
		return consentLetterReport;
	}

}
