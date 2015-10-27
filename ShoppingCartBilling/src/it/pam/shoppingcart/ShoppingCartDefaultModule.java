package it.pam.shoppingcart;

import it.pam.shoppingcart.carts.DiscountableCart;
import it.pam.shoppingcart.impl.carts.DefaultCart;
import it.pam.shoppingcart.impl.policies.BookDiscountPolicy;
import it.pam.shoppingcart.impl.policies.DefaultProductDiscountPolicy;
import it.pam.shoppingcart.impl.policies.GroceryDiscountPolicy;
import it.pam.shoppingcart.impl.policies.Volume40EuroDiscountPolicy;
import it.pam.shoppingcart.impl.products.Category;
import it.pam.shoppingcart.policies.GeneralDiscountPolicy;
import it.pam.shoppingcart.policies.ItemDiscountPolicy;

import org.apache.log4j.Logger;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class ShoppingCartDefaultModule extends AbstractModule {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(ShoppingCartDefaultModule.class);

	@Override
	protected void configure() {
		bind(ItemDiscountPolicy.class).to(DefaultProductDiscountPolicy.class);
		bind(GeneralDiscountPolicy.class).to(Volume40EuroDiscountPolicy.class);

		bind(DiscountableCart.class).to(DefaultCart.class);

		bind(ItemDiscountPolicy.class).to(DefaultProductDiscountPolicy.class);
		bind(ItemDiscountPolicy.class).annotatedWith(Names.named(Category.BOOK)).to(BookDiscountPolicy.class);
		bind(ItemDiscountPolicy.class).annotatedWith(Names.named(Category.GROCERY)).to(GroceryDiscountPolicy.class);

	}
}
