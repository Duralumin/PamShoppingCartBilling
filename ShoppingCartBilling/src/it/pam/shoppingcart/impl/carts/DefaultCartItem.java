package it.pam.shoppingcart.impl.carts;

import it.pam.shoppingcart.carts.DiscountableItem;
import it.pam.shoppingcart.helpers.MoneyHelper;
import it.pam.shoppingcart.policies.ItemDiscountPolicy;
import it.pam.shoppingcart.products.Product;

import org.joda.money.Money;

import com.sun.istack.internal.NotNull;

public class DefaultCartItem implements DiscountableItem {

	final Product product;
	int quantity;
	double discountPercentage;
	Money finalPrice = MoneyHelper.zero();

	public DefaultCartItem(@NotNull final Product product) {
		super();
		this.product = product;
	}


	@Override
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(final int quantity) {
		this.quantity = quantity;
	}


	@Override
	public double getDiscountPercentage() {
		return this.discountPercentage;
	}

	@Override
	public void setDiscountPercentage(final double discount) {
		this.discountPercentage = discount;
	}

	@Override
	public Money getFinalPrice() {
		return this.finalPrice;
	}

	@Override
	public void setFinalPrice(final Money finalPrice) {
		this.finalPrice = finalPrice;
	}

	public void applyDiscount() {
		this.product.getDiscountPolicy().calculate(this);

	}


	@Override
	public Money getUnitPrice() {
		return this.product.getUnitPrice();
	}



	@Override
	public String getDescription() {
		return this.product.getDescription();
	}



	public ItemDiscountPolicy getDiscountPolicy() {
		return this.product.getDiscountPolicy();
	}




}
