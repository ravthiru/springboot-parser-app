package com.test.parser.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.parser.model.ClientSummary;
import com.test.parser.model.DailySummaryReport;
import com.test.parser.model.ProductSummary;
import com.test.parser.model.Transaction;
import com.test.parser.repository.TransactionsRepository;

@Service
public class SummaryReportService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SummaryReportService.class);
	@Autowired
	TransactionsRepository transactionsRepository;

	public DailySummaryReport generateReport() {
		List<Transaction> transList = transactionsRepository.findAll();
		LOGGER.info("Received size" + transList.size());
		return createReport(transList);
	}

	public DailySummaryReport createReport(List<Transaction> transList) {
		Map<String, List<Transaction>> clientNumberGroup = transList.stream()
				.collect(Collectors.groupingBy(Transaction::getClientNumber, Collectors.toList()));
		DailySummaryReport dailyReport = new DailySummaryReport();
		for (String clientNumber : clientNumberGroup.keySet()) {
			ClientSummary clientSummary = new ClientSummary();
			List<ProductSummary> productSummary = createReportForClient(clientNumberGroup.get(clientNumber)).values()
					.stream().collect(Collectors.toList());
			clientSummary.setProductSummary(productSummary);
			dailyReport.getClientSummary().add(clientSummary);
		}
		LOGGER.info("generated Summary Report" + dailyReport);
		return dailyReport;
	}

	public Map<String, ProductSummary> createReportForClient(List<Transaction> transList) {
		Map<String, ProductSummary> result = transList.stream()
				.collect(Collectors.groupingBy(Transaction::getProductGroupCode,
						Collectors.collectingAndThen(Collectors.toList(), ProductSummary::createSummary)));
		LOGGER.info("Generating Client Report " + result);
		return result;
	}

}
