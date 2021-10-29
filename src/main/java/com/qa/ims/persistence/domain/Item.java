package com.qa.ims.persistence.domain;

public class Item {
	
	private Long itemId;
	private String itemName;
	private Double itemValue;
	
	public Item(String itemName, Double itemValue) {
		this.setItemName(itemName);
		this.setItemValue(itemValue);
	}
	
	public Item(Long id, String productName, Double productValue) {
		this.setItemtId(id);
		this.setItemName(productName);
		this.setItemValue(productValue);
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemtId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String productName) {
		this.itemName = productName;
	}

	public double getItemValue() {
		return itemValue;
	}

	public void setItemValue(Double itemValue) {
		this.itemValue = itemValue;
	}
	
	@Override
	public String toString() {
		return "id:" + itemId + " Item Name:" + itemName + " Item Value:" + itemValue;
	}
	
	//This skips some tests???
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemValue == null) ? 0 : itemValue.hashCode());
		
		return result;
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
		Item other = (Item) obj;
		if (getItemName() == null) {
			if (other.getItemName() != null)
				return false;
		} else if (!getItemName().equals(other.getItemName()))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (itemValue == null) {
			if (other.itemValue != null)
				return false;		
		} else if (!itemValue.equals(other.itemValue))
			return false;
		return true;
		
		//I hate everything about this code but it makes perfect sense aaaa
	}
	
	
}
