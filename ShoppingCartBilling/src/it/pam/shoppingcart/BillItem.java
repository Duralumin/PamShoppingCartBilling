package it.pam.shoppingcart;

import org.joda.money.Money;

public interface BillItem {

	int getQuantity();

	Money getUnitPrice();

	double getDiscount();

	Money getFinalPrice();

}
