package it.pam.shoppingcart.policies;

import it.pam.shoppingcart.carts.DiscountableCart;

import java.math.RoundingMode;


public interface GeneralDiscountPolicy {


	static final RoundingMode DEFAULT_GENERAL_ROUDING_MODE = RoundingMode.HALF_EVEN;

	public void calculate(DiscountableCart cart);

	public String getDescription();

	public double getPercentage();



}
