package it.pam.shoppingcart.carts;

import org.joda.money.Money;

public interface DiscountableItem extends CartItem {

	public void setFinalPrice(Money price);

	public Money getFinalPrice();

	public void setDiscountPercentage(double discount);

	public double getDiscountPercentage();

	public void applyDiscount();



}
