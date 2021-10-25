package com.qa.ims.persistence.domain;

public class Order {

	private Long orderID;
	private Long customerID;
	private String deliveryReason;
	
	public Order(Long customerID, String deliveryReason) {
		this.setCustomerID(customerID);
		this.setDeliveryReason(deliveryReason);
	}
	
	public Order(Long orderID, Long customerID, String deliveryReason) {
		this.setOrderId(orderID);
		this.setCustomerID(customerID);
		this.setDeliveryReason(deliveryReason);
	}

	public Long getOrderId() {
		return orderID;
	}

	public void setOrderId(Long orderId) {
		this.orderID = orderId;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}
	
	public String getDeliveryReason() {
		return deliveryReason;
	}

	public void setDeliveryReason(String deliveryReason) {
		this.deliveryReason = deliveryReason;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());	
		result = prime * result + ((deliveryReason == null) ? 0 : deliveryReason.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null) 
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (getCustomerID() == null) {
			if (other.getCustomerID() != null)
				return false;
		} else if (!getCustomerID().equals(other.getCustomerID()))
			return false;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		if (deliveryReason == null) {
			if (other.deliveryReason != null)
				return false;
		} else if(!deliveryReason.equals(other.deliveryReason))
			return false;
		
		return true;
	}
	
}
