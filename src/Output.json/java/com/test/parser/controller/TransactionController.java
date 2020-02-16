package com.test.parser.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.parser.exception.TransactionsFileUploadException;
import com.test.parser.model.DailySummaryReport;

@RestController
public class TransactionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
	private UploadTransactionsService uploadService;

	private SummaryReportService reportService;

	public TransactionController(UploadTransactionsService uploadService, SummaryReportService reportService) {
		this.uploadService = uploadService;
		this.reportService = reportService;
	}

	/**
	 * For uploading transactions file , it is processed and loaded to Database
	 * 
	 * @param file
	 * @return
	 * @throws TransactionsFileUploadException 
	 */
	@PostMapping("/upload")
	public String uploadTransactions(@RequestParam("file") MultipartFile file) throws TransactionsFileUploadException {
		LOGGER.info("Upload Transactions file");
		if (file.isEmpty()) {
			return "Upload Transaction File";
		}
		return uploadService.uploadTransactions(file);
	}

	/**
	 * Used for generating Summary report with following information
	 * 
	 * Client_Information Product_Information Total_Transaction_Amount
	 * 
	 * @return DailySummaryReport
	 */
	@GetMapping("/report")
	DailySummaryReport summaryReport() {
		return reportService.generateReport();
	}

}
