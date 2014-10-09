package it.pam.shoppingcart.impl.carts;

import it.pam.shoppingcart.carts.DiscountableCart;
import it.pam.shoppingcart.carts.DiscountableItem;
import it.pam.shoppingcart.helpers.MoneyHelper;
import it.pam.shoppingcart.policies.GeneralDiscountPolicy;

import java.util.List;

import org.assertj.core.util.Lists;
import org.joda.money.Money;

public class DefaultCart implements DiscountableCart {

	private final List<DiscountableItem> items = Lists.newArrayList();

	private Money total = MoneyHelper.zero();

	private Money finalPrice = MoneyHelper.zero();

	private Money totalDiscount = MoneyHelper.zero();

	private Money discount = MoneyHelper.zero();

	private GeneralDiscountPolicy discountPolicy = null;

	@Override
	public List<DiscountableItem> getItems() {
		return this.items;
	}


	@Override
	public Money getTotalDiscount() {
		return this.totalDiscount;
	}


	@Override
	public Money getFinalPrice() {
		return this.finalPrice;
	}


	@Override
	public void setFinalPrice(final Money finalPrice) {
		this.finalPrice = finalPrice;
	}


	@Override
	public void setTotalDiscount(final Money totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	@Override
	public void setDiscountPolicy(final GeneralDiscountPolicy generalDiscountPolicy) {
		this.discountPolicy = generalDiscountPolicy;

	}


	@Override
	public void applyDiscount() {
		if (this.discountPolicy != null) {
			this.discountPolicy.calculate(this);
		}

	}



	@Override
	public Money getGrossTotal() {
		return this.total;
	}


	@Override
	public void setGrossTotal(final Money total) {
		this.total = total;
	}


	@Override
	public Money getCartDiscount() {
		return this.discount;
	}


	@Override
	public void setCartDiscount(final Money discount) {
		this.discount = discount;
	}


	@Override
	public GeneralDiscountPolicy getDiscountPolicy() {
		return this.discountPolicy;
	}



}
