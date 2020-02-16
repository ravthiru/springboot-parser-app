package com.test.parser.controller;


import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.test.parser.model.DailySummaryReport;
import com.test.parser.model.ProductSummary;
import com.test.parser.model.Transaction;

public class SummaryReportServiceTest {

	@Test
	public void createReport() {
		SummaryReportService report = new SummaryReportService();
		Transaction t1 = new Transaction("1234", "AB", new BigDecimal(10), new BigDecimal(2));
		Transaction t2 = new Transaction("1234", "AB", new BigDecimal(12), new BigDecimal(3));
		Transaction t3 = new Transaction("1234", "CD", new BigDecimal(14), new BigDecimal(4));
		Transaction t4 = new Transaction("4321", "XY", new BigDecimal(10), new BigDecimal(2));
		Transaction t5 = new Transaction("4321", "XY", new BigDecimal(9), new BigDecimal(2));
		Transaction t6 = new Transaction("4321", "MN", new BigDecimal(10), new BigDecimal(2));
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(t1);
		transactions.add(t2);
		transactions.add(t3);
		transactions.add(t4);
		transactions.add(t5);
		transactions.add(t6);
		DailySummaryReport summaryReport = report.createReport(transactions);
		assertThat(summaryReport.getClientSummary().size())
	      .isEqualTo(2);
	}
	
	@Test
	public void createReportForClient() {
		SummaryReportService report = new SummaryReportService();
		Transaction t1 = new Transaction("1234", "AB", new BigDecimal(10), new BigDecimal(2));
		Transaction t2 = new Transaction("1234", "AB", new BigDecimal(12), new BigDecimal(3));
		Transaction t3 = new Transaction("1234", "CD", new BigDecimal(14), new BigDecimal(4));
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(t1);
		transactions.add(t2);
		transactions.add(t3);
		Map<String, ProductSummary> clientReport = report.createReportForClient(transactions);
		assertThat(clientReport.size())
	      .isEqualTo(2);
		assertThat(clientReport).containsKey("AB");
		assertThat(clientReport).containsKey("CD");
		assertThat(clientReport.get("AB").getTransAmount()).isEqualTo(new BigDecimal(17));
		assertThat(clientReport.get("CD").getTransAmount()).isEqualTo(new BigDecimal(10));
	}
	
}
