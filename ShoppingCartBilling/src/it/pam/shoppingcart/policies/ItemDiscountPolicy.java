package it.pam.shoppingcart.policies;

import it.pam.shoppingcart.carts.DiscountableItem;

public interface ItemDiscountPolicy {

	void calculate(DiscountableItem item);



}
