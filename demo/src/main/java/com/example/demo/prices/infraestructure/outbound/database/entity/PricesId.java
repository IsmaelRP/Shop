package com.example.demo.prices.infraestructure.outbound.database.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class PricesId implements Serializable {

	private static final long serialVersionUID = 2730859487024839802L;

	private int productId;
	private short brandId;
	private int priceList;
	
	 public PricesId() {
	 }
	
	public PricesId(int productId, short brandId, int priceList) {
		this.productId = productId;
		this.brandId = brandId;
		this.priceList = priceList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brandId, priceList, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PricesId other = (PricesId) obj;
		return brandId == other.brandId && priceList == other.priceList && productId == other.productId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getProductId() {
		return productId;
	}

	public short getBrandId() {
		return brandId;
	}

	public int getPriceList() {
		return priceList;
	}

	
	
	
	
}
