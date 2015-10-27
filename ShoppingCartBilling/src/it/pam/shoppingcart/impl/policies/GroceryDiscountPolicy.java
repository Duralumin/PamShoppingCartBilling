package it.pam.shoppingcart.impl.policies;

import it.pam.shoppingcart.carts.DiscountableItem;
import it.pam.shoppingcart.helpers.DiscountHelper;
import it.pam.shoppingcart.policies.ItemDiscountPolicy;

import org.apache.log4j.Logger;
import org.joda.money.Money;

import com.sun.istack.internal.NotNull;

public class GroceryDiscountPolicy extends DefaultProductDiscountPolicy implements ItemDiscountPolicy {

	private static final double DISCOUNT_PERCENTAGE = 7.5;

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(BookDiscountPolicy.class);

	@Override
	public void calculate(@NotNull final DiscountableItem item) {
		item.setDiscountPercentage(DISCOUNT_PERCENTAGE);

		int quantity = item.getQuantity();
		Money unitPrice = item.getUnitPrice();

		Money finalPrice = DiscountHelper.calculatePercentageDiscount(unitPrice.multipliedBy(quantity),
		                                                              DISCOUNT_PERCENTAGE,
		                                                              DEFAULT_ROUNDING_MODE);


		item.setFinalPrice(finalPrice);
	}

}
