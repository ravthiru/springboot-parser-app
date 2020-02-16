package com.test.parser.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.test.parser.model.Transaction;

public class UploadTransactionsServiceTest {
	
	@Test
	public void buildTransaction() {
		String transactionStr = "315CL  432100020001SGXDC FUSGX NK    20100910JPY01B 0000000001 0000000000000000000060DUSD000000000030DUSD000000000000DJPY201008200012380     688032000092500000000             O";
		Transaction transaction = UploadTransactionsService.constructTransaction(transactionStr);
		assertThat(transaction.getClientNumber())
	      .isEqualTo("4321");
		assertThat(transaction.getProductGroupCode())
	      .isEqualTo("FU");
		assertThat(transaction.getRecordCode())
	      .isEqualTo("315");
	}

}
