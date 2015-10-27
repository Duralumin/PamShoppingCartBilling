package it.pam.shoppingcart.impl.products;

import it.pam.shoppingcart.policies.ItemDiscountPolicy;

import com.google.inject.Inject;


public class OtherProduct extends GenericProduct {

	private String description = "other";

	@Inject
	public OtherProduct(final ItemDiscountPolicy itemDiscountPolicy) {
		super(itemDiscountPolicy);
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(final String description) {
		this.description = description;
	}







}
