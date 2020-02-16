package com.test.parser.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.parser.exception.TransactionsFileUploadException;
import com.test.parser.model.Transaction;
import com.test.parser.repository.TransactionsRepository;

@Service
public class UploadTransactionsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UploadTransactionsService.class);
	
	@Autowired
	TransactionsRepository transactionsRepository;

	public String uploadTransactions(MultipartFile file) throws TransactionsFileUploadException {
		try (InputStream inputStream = file.getInputStream()) {
			new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()
					.map(tranStr -> UploadTransactionsService.constructTransaction(tranStr))
					.forEach(transObj -> transactionsRepository.save(transObj));
			// transactions.stream().map(tranStr->UploadTransactionsService.constructTransaction(tranStr)).forEach(transObj->transactionsRepository.save(transObj));
		} catch (Exception exception) {
			LOGGER.warn("Error while uploading Transactions File ", exception);
			throw new TransactionsFileUploadException("Error while uploading Transactions File");
		}
		return "Upload Sucessful";
	}

	public static Transaction constructTransaction(String transStr) {

		Transaction transObj = new Transaction();

		String recordCode = transStr.substring(0, 3);
		String clientType = transStr.substring(3, 7);
		String clientNumber = transStr.substring(7, 11);
		String accountNumber = transStr.substring(11, 15);
		String subAccountNumber = transStr.substring(15, 19);
		transObj.setRecordCode(recordCode);
		transObj.setClientType(clientType);
		transObj.setClientNumber(clientNumber);
		transObj.setAccountNumber(accountNumber);
		transObj.setSubAccountNumber(subAccountNumber);

		// System.out.println(" recordCode= "+recordCode+"clientType= "+clientType+"
		// clientNumber = "+clientNumber+" accountNumber= "+accountNumber+"
		// subAccountNumber ="+subAccountNumber);

		// Product_Information
		String productGroupCode = transStr.substring(25, 27);
		String exchangeCode = transStr.substring(27, 31);
		String symbol = transStr.substring(31, 37);
		String expirationDate = transStr.substring(37, 45);
		transObj.setProductGroupCode(productGroupCode);
		transObj.setExchangeCode(exchangeCode);
		transObj.setSymbol(symbol);
		transObj.setExpirationDate(expirationDate);

		// Transaction_Amount

		BigDecimal quantityLong = new BigDecimal(transStr.substring(52, 62));
		BigDecimal quantityShot = new BigDecimal(transStr.substring(63, 72));
		LOGGER.info(" quantityLong " + quantityLong + " quantityShot" + quantityShot);
		transObj.setQuantityLong(quantityLong);
		transObj.setQuantityShot(quantityShot);
		return transObj;

	}

}
