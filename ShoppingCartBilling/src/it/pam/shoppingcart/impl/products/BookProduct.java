package it.pam.shoppingcart.impl.products;

import it.pam.shoppingcart.policies.ItemDiscountPolicy;

import com.google.inject.Inject;
import com.google.inject.name.Named;


public class BookProduct extends GenericProduct {

	private String description = "Book";

	@Inject
	public BookProduct(@Named(Category.BOOK) final ItemDiscountPolicy itemDiscountPolicy) {
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
