package it.pam.shoppingcart.impl.policies;

import it.pam.shoppingcart.carts.DiscountableItem;
import it.pam.shoppingcart.policies.ItemDiscountPolicy;

import java.math.RoundingMode;

import org.apache.log4j.Logger;

public class DefaultProductDiscountPolicy implements ItemDiscountPolicy {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(DefaultProductDiscountPolicy.class);

	static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_EVEN;

	@Override
	public void calculate(final DiscountableItem item) {
		item.setDiscountPercentage(0);
		item.setFinalPrice(item.getUnitPrice().multipliedBy(item.getQuantity()));

	}


}
