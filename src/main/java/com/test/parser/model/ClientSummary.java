package com.test.parser.model;

import java.util.ArrayList;
import java.util.List;

public class ClientSummary {
	
	List <ProductSummary> productSummary;
	
	public ClientSummary() {
		productSummary = new ArrayList<ProductSummary>();
	}

	public List<ProductSummary> getProductSummary() {
		return productSummary;
	}

	public void setProductSummary(List<ProductSummary> productSummary) {
		this.productSummary = productSummary;
	}

}
