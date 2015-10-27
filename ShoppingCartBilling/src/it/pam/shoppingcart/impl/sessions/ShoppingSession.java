package it.pam.shoppingcart.impl.sessions;

import it.pam.shoppingcart.carts.DiscountableCart;
import it.pam.shoppingcart.carts.DiscountableItem;
import it.pam.shoppingcart.impl.carts.DefaultCartItem;
import it.pam.shoppingcart.policies.GeneralDiscountPolicy;
import it.pam.shoppingcart.products.Product;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.sun.istack.internal.NotNull;

public class ShoppingSession  {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(ShoppingSession.class);

	private final DiscountableCart cart;


	@Inject
	public ShoppingSession(@NotNull final GeneralDiscountPolicy generalDiscountPolicy, @NotNull final DiscountableCart cart) {
		super();
		Preconditions.checkNotNull(generalDiscountPolicy);
		Preconditions.checkNotNull(cart);
		this.cart = cart;
		this.cart.setDiscountPolicy(generalDiscountPolicy);
	}

	public void addProduct(@NotNull final Product product, final int quantity) {
		Preconditions.checkNotNull(product);

		DefaultCartItem item = new DefaultCartItem(product);
		item.setQuantity(quantity);
		this.cart.getItems().add(item);

	}

	public void removeItem(@NotNull final DefaultCartItem item) {
		Preconditions.checkNotNull(item);

		this.cart.getItems().remove(item);

	}

	private void refresh(final DiscountableItem item) {
		item.applyDiscount();

	}

	public void incrementQuantity(@NotNull final DefaultCartItem item) {
		Preconditions.checkNotNull(item);

		item.setQuantity(item.getQuantity() + 1);

	}

	public void decrementQuantity(@NotNull final DefaultCartItem item) {
		Preconditions.checkNotNull(item);

		int quantity = item.getQuantity();
		if (quantity > 0) {
			item.setQuantity(quantity - 1);
		}
	}

	public DiscountableCart getCart() {
		return this.cart;
	}

	public void refresh() {
		List<DiscountableItem> items = this.cart.getItems();
		for (DiscountableItem item : items) {
			refresh(item);
		}
		this.cart.applyDiscount();
	}



}
