package com.qa.ims.persistence.domain;

public class OrderItem {
	private Long orderItemID;
	private Long orderID;
	private Long itemID;
	
	//Remove this one later!
	private String deliveryReason;
	
	public OrderItem(Long orderID, Long itemID, String deliveryReason) {
		this.setOrderID(orderID);
		this.setItemID(itemID);
		this.setDeliveryReason(deliveryReason);
	}
	
	public OrderItem(Long orderItemID, Long orderID, Long itemID, String deliveryReason) {
		this.setOrderItemID(orderItemID);
		this.setOrderID(orderID);
		this.setItemID(itemID);
		this.setDeliveryReason(deliveryReason);
	}

	public Long getOrderItemID() {
		return orderItemID;
	}

	public void setOrderItemID(Long orderItemID) {
		this.orderItemID = orderItemID;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public String getDeliveryReason() {
		return deliveryReason;
	}

	public void setDeliveryReason(String deliveryReason) {
		this.deliveryReason = deliveryReason;
	}
	
	@Override
	public String toString() {
		return "orderItem id: " + orderItemID + " order ID:" + orderID + " itemID:" + itemID + " delivery reasom:" + deliveryReason;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderItemID == null) ? 0 : orderItemID.hashCode());
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (getOrderItemID() == null) {
			if (other.getOrderItemID() != null)
				return false;
		} else if (!getOrderItemID().equals(other.getOrderItemID()))
			return false;
		if (getOrderID() == null) {
			if (other.getOrderID() != null)
				return false;
		} else if (!getOrderID().equals(other.getOrderID()))
			return false;
		if (getItemID() == null) {
			if (other.getItemID() != null)
				return false;
		} else if (!getItemID().equals(other.getItemID()))
			return false;
		
		if (getDeliveryReason() == null) {
			if (other.getDeliveryReason() != null)
				return false;
		} else if (!getDeliveryReason().equals(other.getDeliveryReason()))
			return false;
		
		return true;
	}
}
