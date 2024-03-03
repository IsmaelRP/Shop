package com.example.demo.prices.domain.model;

import java.time.LocalDateTime;

import lombok.Getter;

public class PriceQuery {

	private int productId;
	private short brandId;
	private float price;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	public PriceQuery(int productId, short brandId, float price, LocalDateTime startDate, LocalDateTime endDate) {
		this.productId = productId;
		this.brandId = brandId;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getProductId() {
		return productId;
	}

	public short getBrandId() {
		return brandId;
	}

	public float getPrice() {
		return price;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}
	
	
	
}
