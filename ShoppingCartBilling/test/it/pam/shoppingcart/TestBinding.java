package it.pam.shoppingcart;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import it.pam.shoppingcart.impl.carts.DefaultCartItem;
import it.pam.shoppingcart.impl.policies.BookDiscountPolicy;
import it.pam.shoppingcart.impl.products.BookProduct;
import it.pam.shoppingcart.policies.ItemDiscountPolicy;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestBinding {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(TestBinding.class);
	private Injector injector;

	@Before
	public void setUp() throws Exception {
		this.injector = Guice.createInjector(new ShoppingCartDefaultModule());

	}

	@Test
	public void bindPolicy() {
		BookProduct bookProduct = this.injector.getInstance(BookProduct.class);

		ItemDiscountPolicy bookDiscountPolicy = bookProduct.getDiscountPolicy();
		assertThat(bookDiscountPolicy, instanceOf(BookDiscountPolicy.class));

		DefaultCartItem defaultCartItem = new DefaultCartItem(bookProduct);
		defaultCartItem.applyDiscount();
		assertThat(defaultCartItem.getDiscountPercentage(), equalTo(12d));


	}


}
