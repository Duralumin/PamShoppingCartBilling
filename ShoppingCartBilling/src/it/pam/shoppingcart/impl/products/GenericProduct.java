package it.pam.shoppingcart.impl.products;

import it.pam.shoppingcart.policies.ItemDiscountPolicy;
import it.pam.shoppingcart.products.Product;

import org.joda.money.Money;

import com.google.inject.Inject;

public abstract class GenericProduct implements Product {

	Money unitPrice;
	String description;
	final ItemDiscountPolicy itemDiscountPolicy;

	@Inject
	public GenericProduct(final ItemDiscountPolicy itemDiscountPolicy) {
		super();
		this.itemDiscountPolicy = itemDiscountPolicy;
	}

	@Override
	public Money getUnitPrice() {
		return this.unitPrice;
	}

	@Override
	public void setUnitPrice(final Money unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public ItemDiscountPolicy getDiscountPolicy() {
		return this.itemDiscountPolicy;
	}



}
