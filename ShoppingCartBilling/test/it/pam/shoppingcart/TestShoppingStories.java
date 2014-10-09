package it.pam.shoppingcart;

import static org.assertj.core.api.Assertions.*;
import it.pam.shoppingcart.carts.DiscountableCart;
import it.pam.shoppingcart.carts.DiscountableItem;
import it.pam.shoppingcart.helpers.MoneyHelper;
import it.pam.shoppingcart.helpers.OfTestHelper;
import it.pam.shoppingcart.impl.sessions.ShoppingSession;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestShoppingStories {


	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(TestShoppingStories.class);
	private Injector injector;

	@Before
	public void setUp() throws Exception {
		this.injector = Guice.createInjector(new ShoppingCartDefaultModule());

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


		ShoppingSession session = OfTestHelper.makeSession1(this.injector);

		DiscountableCart cart = session.getCart();

		assertThat(cart).isNotNull();
		assertThat(cart.getItems()).isNotNull().hasSize(2);

		DiscountableItem pastaItem = cart.getItems().get(0);

		assertThat(pastaItem).isNotNull();
		assertThat(pastaItem.getDescription()).isEqualTo(OfTestHelper.PASTA_DESC);
		assertThat(pastaItem.getQuantity()).isEqualTo(1);
		assertThat(pastaItem.getUnitPrice()).isEqualTo(MoneyHelper.newEuro(4.29d));
		assertThat(pastaItem.getDiscountPercentage()).isEqualTo(7.5d);
		assertThat(pastaItem.getFinalPrice()).isEqualTo(MoneyHelper.newEuro(3.97d));

		DiscountableItem bookItem = cart.getItems().get(1);

		assertThat(bookItem).isNotNull();
		assertThat(bookItem.getDescription()).isEqualTo(OfTestHelper.BOOK_DESC);
		assertThat(bookItem.getQuantity()).isEqualTo(1);
		assertThat(bookItem.getUnitPrice()).isEqualTo(MoneyHelper.newEuro(10.12d));
		assertThat(bookItem.getDiscountPercentage()).isEqualTo(12);
		assertThat(bookItem.getFinalPrice()).isEqualTo(MoneyHelper.newEuro(8.91d));

		assertThat(cart.getFinalPrice()).isEqualTo(MoneyHelper.newEuro(12.90d));
		assertThat(cart.getTotalDiscount()).isEqualTo(MoneyHelper.newEuro(1.53d));



	}


	/*
	 * Input 2:
	 *
	 * 1 Coffee 500g at 3.21
	 *
	 * 1 Pasta 1Kg at 4.29
	 *
	 * 1 Cake at 2.35
	 *
	 * Output 2:
	 *
	 * Coffee 500g 1 3.21 7.5% 2.97
	 *
	 * Pasta 1kg 1 4.29 7.5% 3.97
	 *
	 * Cake 1 2.35 0% 2.35
	 *
	 * Total 9.30
	 *
	 * (Total discounts 0.56)
	 */

	@Test
	public void secondCase() {

		ShoppingSession session = OfTestHelper.makeSession2(this.injector);

		DiscountableCart cart = session.getCart();

		assertThat(cart).isNotNull();
		assertThat(cart.getItems()).isNotNull().hasSize(3);

		// Coffee
		DiscountableItem coffeeItem = cart.getItems().get(0);

		assertThat(coffeeItem).isNotNull();
		assertThat(coffeeItem.getDescription()).isEqualTo(OfTestHelper.COFFEE_DESC);
		assertThat(coffeeItem.getQuantity()).isEqualTo(1);
		assertThat(coffeeItem.getUnitPrice()).isEqualTo(MoneyHelper.newEuro(3.21));
		assertThat(coffeeItem.getDiscountPercentage()).isEqualTo(7.5d);
		assertThat(coffeeItem.getFinalPrice()).isEqualTo(MoneyHelper.newEuro(2.97d));

		// Pasta
		DiscountableItem pastaItem = cart.getItems().get(1);

		assertThat(pastaItem).isNotNull();
		assertThat(pastaItem.getDescription()).isEqualTo(OfTestHelper.PASTA_DESC);
		assertThat(pastaItem.getQuantity()).isEqualTo(1);
		assertThat(pastaItem.getUnitPrice()).isEqualTo(MoneyHelper.newEuro(4.29d));
		assertThat(pastaItem.getDiscountPercentage()).isEqualTo(7.5d);
		assertThat(pastaItem.getFinalPrice()).isEqualTo(MoneyHelper.newEuro(3.97d));

		// Cake
		DiscountableItem cakeItem = cart.getItems().get(2);

		assertThat(cakeItem).isNotNull();
		assertThat(cakeItem.getDescription()).isEqualTo(OfTestHelper.CAKE_DESC);
		assertThat(cakeItem.getQuantity()).isEqualTo(1);
		assertThat(cakeItem.getUnitPrice()).isEqualTo(MoneyHelper.newEuro(2.35d));
		assertThat(cakeItem.getDiscountPercentage()).isEqualTo(0);
		assertThat(cakeItem.getFinalPrice()).isEqualTo(MoneyHelper.newEuro(2.35d));

		assertThat(cart.getFinalPrice()).isEqualTo(MoneyHelper.newEuro(9.30d));
		assertThat(cart.getTotalDiscount()).isEqualTo(MoneyHelper.newEuro(0.56d));

	}


	/*
	 * Input 3:
	 *
	 * 10 Chocolate at 2.1
	 *
	 * 1 Wine at 10.5
	 *
	 * 1 Book at 15.05
	 *
	 * 5 Apple at 0.5
	 *
	 *
	 * Output 3:
	 *
	 * Chocolate 10 2.10 0% 21.00
	 *
	 * Wine
	 *
	 * Book
	 *
	 * Apple
	 *
	 * Gross Total 47.24
	 *
	 * Volume Discount 5% 2.36
	 *
	 * Total 44.90
	 *
	 * (Total discounts 4.17)
	 *
	 * Quantity UnitPrice Discount Final Price
	 *
	 * 1 10.5 0% 10.50
	 *
	 * 1 15.05 12% 13.24
	 *
	 * 5 0.5 0% 10.50
	 */
	@Test
	public void thirdCase() {

		ShoppingSession session = OfTestHelper.makeSession3(this.injector);

		DiscountableCart cart = session.getCart();

		assertThat(cart).isNotNull();
		assertThat(cart.getItems()).isNotNull().hasSize(4);

		// Chocolate
		DiscountableItem chocolateItem = cart.getItems().get(0);

		assertThat(chocolateItem).isNotNull();
		assertThat(chocolateItem.getDescription()).isEqualTo(OfTestHelper.CHOCOLATE_DESC);
		assertThat(chocolateItem.getQuantity()).isEqualTo(10);
		assertThat(chocolateItem.getUnitPrice()).isEqualTo(MoneyHelper.newEuro(2.10));
		assertThat(chocolateItem.getDiscountPercentage()).isEqualTo(0);
		assertThat(chocolateItem.getFinalPrice()).isEqualTo(MoneyHelper.newEuro(21d));

		// Wine
		DiscountableItem wineItem = cart.getItems().get(1);

		assertThat(wineItem).isNotNull();
		assertThat(wineItem.getDescription()).isEqualTo(OfTestHelper.WINE_DESC);
		assertThat(wineItem.getQuantity()).isEqualTo(1);
		assertThat(wineItem.getUnitPrice()).isEqualTo(MoneyHelper.newEuro(10.5d));
		assertThat(wineItem.getDiscountPercentage()).isEqualTo(0);
		assertThat(wineItem.getFinalPrice()).isEqualTo(MoneyHelper.newEuro(10.5d));

		// Book
		DiscountableItem bookItem = cart.getItems().get(2);

		assertThat(bookItem).isNotNull();
		assertThat(bookItem.getDescription()).isEqualTo(OfTestHelper.BOOK_DESC);
		assertThat(bookItem.getQuantity()).isEqualTo(1);
		assertThat(bookItem.getUnitPrice()).isEqualTo(MoneyHelper.newEuro(15.05));
		assertThat(bookItem.getDiscountPercentage()).isEqualTo(12);
		assertThat(bookItem.getFinalPrice()).isEqualTo(MoneyHelper.newEuro(13.24));

		// Apple
		DiscountableItem appleItem = cart.getItems().get(3);

		assertThat(appleItem).isNotNull();
		assertThat(appleItem.getDescription()).isEqualTo(OfTestHelper.APPLE_DESC);
		assertThat(appleItem.getQuantity()).isEqualTo(5);
		assertThat(appleItem.getUnitPrice()).isEqualTo(MoneyHelper.newEuro(0.5));
		assertThat(appleItem.getDiscountPercentage()).isEqualTo(0);
		assertThat(appleItem.getFinalPrice()).isEqualTo(MoneyHelper.newEuro(2.5));

		assertThat(cart.getGrossTotal()).isEqualTo(MoneyHelper.newEuro(47.24));
		assertThat(cart.getFinalPrice()).isEqualTo(MoneyHelper.newEuro(44.90));
		assertThat(cart.getCartDiscount()).isEqualTo(MoneyHelper.newEuro(2.36));
		assertThat(cart.getTotalDiscount()).isEqualTo(MoneyHelper.newEuro(4.17));

	}



}
