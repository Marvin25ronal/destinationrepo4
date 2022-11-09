package com.solucredit.models;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

public interface ReportServiceInterface {
	Report getReport(Map<String, Object> params) throws JRException, IOException, SQLException;
}
