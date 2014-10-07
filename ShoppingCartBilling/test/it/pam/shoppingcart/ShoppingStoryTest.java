package it.pam.shoppingcart;

import static org.assertj.core.api.Assertions.*;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ShoppingStoryTest {


	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(ShoppingStoryTest.class);

	@Mock
	Cart cart;

	private static final CurrencyUnit EURO_ITALIAN = CurrencyUnit.of(Locale.ITALIAN);


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
	@Test
	public void firstCase() {



		assertThat(this.cart).isNotNull();
		assertThat(this.cart.getProducts()).isNotNull().hasSize(2);

		Product pasta = this.cart.getProducts().get(0);

		assertThat(pasta).isNotNull();
		assertThat(pasta.getQuantity()).isEqualTo(1);
		assertThat(pasta.getUnitPrice()).isEqualTo(doubleToEuro(4.29d));
		assertThat(pasta.getDiscount()).isEqualTo(7.5d);
		assertThat(pasta.getFinalPrice()).isEqualTo(doubleToEuro(3.97d));

		Product book = this.cart.getProducts().get(1);

		assertThat(book).isNotNull();
		assertThat(book.getQuantity()).isEqualTo(1);
		assertThat(book.getUnitPrice()).isEqualTo(doubleToEuro(10.12d));
		assertThat(book.getDiscount()).isEqualTo(12);
		assertThat(book.getFinalPrice()).isEqualTo(doubleToEuro(8.91d));

		assertThat(this.cart.getTotal()).isEqualTo(doubleToEuro(12.90d));
		assertThat(this.cart.getDiscount()).isEqualTo(doubleToEuro(1.53d));



	}


	private Money doubleToEuro(final double value) {
		return Money.of(EURO_ITALIAN, value);
	}


}
