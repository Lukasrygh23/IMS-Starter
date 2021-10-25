package com.qa.ims.persistence.domain;

public class Product {
	
	private Long productId;
	private String productName;
	private Double productValue;
	
	public Product(String productName, Double productValue) {
		this.setProductName(productName);
		this.setProductValue(productValue);
	}
	
	public Product(Long id, String productName, Double productValue) {
		this.setProductId(id);
		this.setProductName(productName);
		this.setProductValue(productValue);
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductValue() {
		return productValue;
	}

	public void setProductValue(Double productValue) {
		this.productValue = productValue;
	}
	
	@Override
	public String toString() {
		return "id:" + productId + " Product Name:" + productName + " Product Value:" + productValue;
	}
	
	//Otherwise tests won't work right.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (getProductName() == null) {
			if (other.getProductName() != null)
				return false;
		} else if (!getProductName().equals(other.getProductName()))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productValue == null) {
			if (other.productValue != null)
				return false;		
		} else if (!productValue.equals(other.productValue))
			return false;
		return true;
		
		//I hate everything about this code but it makes perfect sense aaaa
	}
	
	
}
