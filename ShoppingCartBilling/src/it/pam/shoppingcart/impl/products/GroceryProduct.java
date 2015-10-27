package it.pam.shoppingcart.impl.products;

import it.pam.shoppingcart.policies.ItemDiscountPolicy;

import com.google.inject.Inject;
import com.google.inject.name.Named;


public class GroceryProduct extends GenericProduct {

	private String description = "Grocery";

	@Inject
	public GroceryProduct(@Named(Category.GROCERY) final ItemDiscountPolicy itemDiscountPolicy) {
		super(itemDiscountPolicy);
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}







}
