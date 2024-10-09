package com.cts.eas.ipm.connector.drools.config;

import java.util.Objects;

public class RuleData {

    private String product;
    private Integer discount;
    private Integer price;
    
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "RuleData [product=" + product + ", discount=" + discount + ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(product, discount,price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RuleData other = (RuleData) obj;
		return Objects.equals(product, other.product) && discount == other.discount
				&& Objects.equals(price, other.price);
	}

}
