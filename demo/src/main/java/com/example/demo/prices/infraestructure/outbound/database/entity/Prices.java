package com.example.demo.prices.infraestructure.outbound.database.entity;

import java.time.LocalDateTime;

import com.example.demo.shared.CurrEnum;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "prices")
public class Prices {

	@EmbeddedId
	private PricesId id;	
	
	@Column(name = "priority")
	private short priority;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "curr")
	private CurrEnum curr;
	
	@Column(name = "start_date")
	private LocalDateTime startDate;
	
	@Column(name = "end_date")
	private LocalDateTime endDate;

	public PricesId getId() {
		return id;
	}

	public short getPriority() {
		return priority;
	}

	public float getPrice() {
		return price;
	}

	public CurrEnum getCurr() {
		return curr;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}
	
	
}
