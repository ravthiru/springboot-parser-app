package com.test.parser.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private Long id;

	// Client_Information
	private String recordCode;

	private String ClientType;
	private String clientNumber;
	private String accountNumber;
	private String subAccountNumber;

	// Product_Information
	private String exchangeCode;
	private String productGroupCode;
	private String symbol;
	private String expirationDate;

	// Transaction_Amount

	private BigDecimal quantityLong;
	private BigDecimal quantityShot;

	public Transaction() {
	};

	public Transaction(String clientNumber, String productGroupCode, BigDecimal quantityLong, BigDecimal quantityShot) {
		this.clientNumber = clientNumber;
		this.productGroupCode = productGroupCode;
		this.quantityLong = quantityLong;
		this.quantityShot = quantityShot;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}

	public String getClientType() {
		return ClientType;
	}

	public void setClientType(String clientType) {
		ClientType = clientType;
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

	public BigDecimal getQuantityLong() {
		return quantityLong;
	}

	public void setQuantityLong(BigDecimal quantityLong) {
		this.quantityLong = quantityLong;
	}

	public BigDecimal getQuantityShot() {
		return quantityShot;
	}

	public void setQuantityShot(BigDecimal quantityShot) {
		this.quantityShot = quantityShot;
	}

	@Override
	public String toString() {
		return "Transaction [ClientType=" + ClientType + ", productGroupCode=" + productGroupCode + ", quantityLong="
				+ quantityLong + ", quantityShot=" + quantityShot + "]";
	}

}
