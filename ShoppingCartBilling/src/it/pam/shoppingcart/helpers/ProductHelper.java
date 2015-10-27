package it.pam.shoppingcart.helpers;


import it.pam.shoppingcart.products.Product;

import org.apache.log4j.Logger;

import com.google.inject.Injector;

public class ProductHelper {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(ProductHelper.class);

	public static <T extends Product> T newProduct(	final Injector injector,
	                                               	final Class<T> productClass,
	                                               	final String description,
	                                               	final double price) {
		T product = injector.getInstance(productClass);
		product.setDescription(description);
		product.setUnitPrice(MoneyHelper.newEuro(price));
		return product;
	}


}
