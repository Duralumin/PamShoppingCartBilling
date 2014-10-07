package it.pam.shoppingcart;

import static org.assertj.core.api.Assertions.*;

import java.util.Currency;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.joda.money.CurrencyUnit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ShoppingStoryTest {

	private static final Currency EURO_ITALIAN = Currency.getInstance(Locale.ITALIAN);

	private static final Logger LOG = Logger.getLogger(ShoppingStoryTest.class);

	@Mock
	Bill bill;

	CurrencyUnit usd = CurrencyUnit.of(Locale.ITALIAN);


	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}


	/*
	 * Input 1:
	 *
	 * 1 Pasta 1kg at 4.29
	 *
	 * 1 Book at 10.12
	 *
	 *
	 * Output
	 *
	 * Output 1:
	 *
	 * Pasta 1kg | 1 | 4.29| 7.5%| 3.97 |
	 *
	 * Book | 1 | 10.12| 12% | 8.91|
	 *
	 * Total | 12.90|
	 *
	 * (Total discounts 1.53)
	 *
	 * Quantity UnitPrice Discount Final Price
	 */
	@Test void firstCase() {

		assertThat(this.bill).isNotNull();
		assertThat(this.bill.getProducts()).isNotNull().hasSize(2);
		BillItem pasta = this.bill.getProducts().get(0);
		assertThat(pasta).isNotNull();
		assertThat(pasta.getQuantity()).isEqualTo(1);
		assertThat(pasta.getUnitPrice()).isEqualTo(Money.of)





	}


}
