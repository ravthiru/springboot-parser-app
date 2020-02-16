package com.test.parser.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductSummary {

	private String clientType;
	private String clientNumber;
	private String accountNumber;
	private String subAccountNumber;
	private String exchangeCode;
	private String productGroupCode;
	private String symbol;
	private String expirationDate;
	private String transactionAmount;
	
	@JsonIgnore
	BigDecimal transAmount;
	

	public String getExchangeCode() {
		return exchangeCode;
	}

	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}

	public String getProductGroupCode() {
		return productGroupCode;
	}

	public void setProductGroupCode(String productGroupCode) {
		this.productGroupCode = productGroupCode;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSubAccountNumber() {
		return subAccountNumber;
	}

	public void setSubAccountNumber(String subAccountNumber) {
		this.subAccountNumber = subAccountNumber;
	}

	public String getTransactionAmount() {
		 return NumberFormat.getCurrencyInstance().format(transAmount);
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public static ProductSummary createSummary(List<Transaction> productGroup) {
		ProductSummary ps = new ProductSummary();
		Transaction tr = productGroup.get(0);
		BigDecimal totalquantityLong = productGroup.stream().map(t -> t.getQuantityLong()).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		BigDecimal totalquantityShot = productGroup.stream().map(t -> t.getQuantityShot()).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		MathContext mc = new MathContext(2);
		ps.setTransAmount(totalquantityLong.subtract(totalquantityShot, mc));
		ps.setClientType(tr.getClientType());
		ps.setClientNumber(tr.getClientNumber());
		ps.setAccountNumber(tr.getAccountNumber());
		ps.setSubAccountNumber(tr.getSubAccountNumber());
		ps.setExchangeCode(tr.getExchangeCode());
		ps.setProductGroupCode(tr.getProductGroupCode());
		ps.setSymbol(tr.getSymbol());
		ps.setExpirationDate(tr.getExpirationDate());
		return ps;

	}

	@Override
	public String toString() {
		return "ProductSummary [clientNumber=" + clientNumber + ", productGroupCode=" + productGroupCode
				+ ", transactionAmount=" + getTransactionAmount() + "]";
	}

	public BigDecimal getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(BigDecimal transAmount) {
		this.transAmount = transAmount;
	}
}
