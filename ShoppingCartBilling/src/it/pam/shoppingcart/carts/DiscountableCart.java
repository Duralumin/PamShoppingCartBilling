package it.pam.shoppingcart.carts;

import it.pam.shoppingcart.policies.GeneralDiscountPolicy;

import java.util.List;

import org.joda.money.Money;

public interface DiscountableCart {

	public void setGrossTotal(Money price);

	public void setFinalPrice(Money price);

	public void setTotalDiscount(Money discount);

	public Money getGrossTotal();

	public Money getFinalPrice();

	public Money getTotalDiscount();

	List<DiscountableItem> getItems();

	public void setDiscountPolicy(GeneralDiscountPolicy generalDiscountPolicy);

	public GeneralDiscountPolicy getDiscountPolicy();

	public void applyDiscount();

	public void setCartDiscount(Money adjustedDiscountedTotal);

	public Money getCartDiscount();


}
