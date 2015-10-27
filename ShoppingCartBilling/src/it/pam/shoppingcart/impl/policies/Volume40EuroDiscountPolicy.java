package it.pam.shoppingcart.impl.policies;

import it.pam.shoppingcart.carts.DiscountableCart;
import it.pam.shoppingcart.carts.DiscountableItem;
import it.pam.shoppingcart.helpers.DiscountHelper;
import it.pam.shoppingcart.helpers.MoneyHelper;
import it.pam.shoppingcart.policies.GeneralDiscountPolicy;

import java.util.List;

import org.apache.log4j.Logger;
import org.joda.money.Money;

import com.google.common.base.Preconditions;
import com.sun.istack.internal.NotNull;

public class Volume40EuroDiscountPolicy implements GeneralDiscountPolicy {

	private static final String DESCRIPTION = "Volume Discount";
	private static final double DISCOUNT_PERCENTAGE = 5;
	private static final Money DISCOUNT_LIMIT_AMOUNT = MoneyHelper.newEuro(40);
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Volume40EuroDiscountPolicy.class);

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public double getPercentage() {
		return DISCOUNT_PERCENTAGE;
	}

	@Override
	public void calculate(@NotNull final DiscountableCart cart) {

		Preconditions.checkNotNull(cart);

		List<DiscountableItem> items = cart.getItems();
		Money grossTotal = MoneyHelper.zero();
		Money undiscountedTotal = MoneyHelper.zero();
		for (DiscountableItem item : items) {
			grossTotal = grossTotal.plus(item.getFinalPrice());
			undiscountedTotal = undiscountedTotal.plus(item.getUnitPrice().multipliedBy(item.getQuantity()));
		}


		cart.setGrossTotal(grossTotal);

		Money cartDiscountedTotal;
		if (grossTotal.isGreaterThan(DISCOUNT_LIMIT_AMOUNT)) {
			cartDiscountedTotal = DiscountHelper.calculatePercentageDiscount(	grossTotal,
			                                                                 	DISCOUNT_PERCENTAGE,
			                                                                 	DEFAULT_GENERAL_ROUDING_MODE);
		} else {
			cartDiscountedTotal = grossTotal;
		}

		cart.setCartDiscount(grossTotal.minus(cartDiscountedTotal));


		Money roundedDiscountedTotal = DiscountHelper.roundToNearest5c(cartDiscountedTotal);
		cart.setFinalPrice(roundedDiscountedTotal);

		cart.setTotalDiscount(undiscountedTotal.minus(cartDiscountedTotal));

	}
}
