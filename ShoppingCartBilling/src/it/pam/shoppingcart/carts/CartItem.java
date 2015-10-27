package it.pam.shoppingcart.carts;

import org.joda.money.Money;

public interface CartItem {

	public String getDescription();

	public int getQuantity();

	public Money getUnitPrice();

}
