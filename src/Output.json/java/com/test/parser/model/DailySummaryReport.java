package com.test.parser.model;

import java.util.ArrayList;
import java.util.List;

public class DailySummaryReport {
	
	List<ClientSummary> clientSummary;
	
	public DailySummaryReport() {
		this.clientSummary = new ArrayList<ClientSummary>();
	}

	public List<ClientSummary> getClientSummary() {
		return clientSummary;
	}

	public void setClientSummary(List<ClientSummary> clientSummary) {
		this.clientSummary = clientSummary;
	}
}
