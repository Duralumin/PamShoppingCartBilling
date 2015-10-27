package it.pam.shoppingcart.helpers;

import java.math.RoundingMode;

import org.apache.log4j.Logger;
import org.joda.money.Money;

import com.google.common.base.Preconditions;
import com.sun.istack.internal.NotNull;

public class DiscountHelper {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(DiscountHelper.class);

	public static Money calculatePercentageDiscount(@NotNull final Money unitPrice,
	                                                final double percentage,
	                                                @NotNull final RoundingMode roundingMode) {

		Preconditions.checkNotNull(unitPrice, "unit price can't be null");
		Preconditions.checkNotNull(roundingMode, "rounding mode can't be null");
		return unitPrice.multipliedBy((100 - percentage) / 100, roundingMode);

	}

	public static Money roundToNearest5c(final Money value) {
		double cents = 0.05d;

		Money divided = value.dividedBy(cents, RoundingMode.HALF_UP).rounded(0, RoundingMode.HALF_UP);
		Money result = divided.multipliedBy(cents, RoundingMode.HALF_UP);

		return result;
	}

}
