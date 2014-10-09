package it.pam.shoppingcart.products;

import it.pam.shoppingcart.policies.ItemDiscountPolicy;

import org.joda.money.Money;

public interface Product {

	Money getUnitPrice();

	String getDescription();

	ItemDiscountPolicy getDiscountPolicy();

	void setDescription(String string);

	void setUnitPrice(Money newEuro);

}
