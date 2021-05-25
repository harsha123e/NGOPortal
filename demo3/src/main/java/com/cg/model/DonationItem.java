package com.cg.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DonationItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemId;
	private DonationType item;
	private String itemDescription;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public DonationType getItem() {
		return item;
	}
	public void setItem(DonationType item) {
		this.item = item;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
}
