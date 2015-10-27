package it.pam.shoppingcart.helpers;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class MoneyHelper {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(MoneyHelper.class);

	private static final CurrencyUnit EURO_ITALIAN = CurrencyUnit.of(Locale.ITALY);

	public static Money newEuro(final double amount) {
		return Money.of(EURO_ITALIAN, amount);
	}

	public static Money zero() {
		return Money.zero(EURO_ITALIAN);
	}
}
