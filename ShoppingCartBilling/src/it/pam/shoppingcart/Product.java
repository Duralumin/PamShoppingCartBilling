package it.pam.shoppingcart;

import org.joda.money.Money;

public interface Product {

	int getQuantity();

	Money getUnitPrice();

	double getDiscount();

	Money getFinalPrice();

}
