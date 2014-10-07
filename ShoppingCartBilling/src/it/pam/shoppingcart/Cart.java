package it.pam.shoppingcart;

import java.util.List;

import org.apache.log4j.Logger;
import org.assertj.core.util.Lists;
import org.joda.money.Money;

import com.google.inject.Inject;

public class Cart {

	@Inject
	DiscountPolicy discountPolicy;

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Cart.class);

	private final List<Product> products = Lists.newArrayList();

	private Money total;

	private Money discount;

	public List<Product> getProducts() {
		return this.products;
	}

	public Money getTotal() {
		return this.total;
	}

	public void setTotal(final Money total) {
		this.total = total;
	}

	public Money getDiscount() {
		return this.discount;
	}

}
