package it.pam.shoppingcart.helpers;

import it.pam.shoppingcart.impl.products.BookProduct;
import it.pam.shoppingcart.impl.products.GroceryProduct;
import it.pam.shoppingcart.impl.products.OtherProduct;
import it.pam.shoppingcart.impl.sessions.ShoppingSession;

import org.apache.log4j.Logger;

import com.google.inject.Injector;

public class OfTestHelper {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(OfTestHelper.class);
	public final static String CHOCOLATE_DESC = "Chocolate";
	public final static String WINE_DESC = "Wine";
	public final static String BOOK_DESC = "Book";
	public final static String APPLE_DESC = "Apple";
	public final static String COFFEE_DESC = "Coffee 500g";
	public final static String PASTA_DESC = "Pasta 1kg";
	public final static String CAKE_DESC = "Cake";
	public static ShoppingSession makeSession3(final Injector injector) {
		ShoppingSession session = injector.getInstance(ShoppingSession.class);

		OtherProduct chocolate = ProductHelper.newProduct(injector, OtherProduct.class, CHOCOLATE_DESC, 2.10);
		session.addProduct(chocolate, 10);

		OtherProduct wine = ProductHelper.newProduct(injector, OtherProduct.class, WINE_DESC, 10.5);
		session.addProduct(wine, 1);

		BookProduct book = ProductHelper.newProduct(injector, BookProduct.class, BOOK_DESC, 15.05);
		session.addProduct(book, 1);

		OtherProduct apple = ProductHelper.newProduct(injector, OtherProduct.class, APPLE_DESC, 0.5);
		session.addProduct(apple, 5);
		session.refresh();
		return session;
	}
	public static ShoppingSession makeSession2(final Injector injector) {
		ShoppingSession session = injector.getInstance(ShoppingSession.class);

		GroceryProduct coffee = ProductHelper.newProduct(injector, GroceryProduct.class, COFFEE_DESC, 3.21);
		session.addProduct(coffee, 1);

		GroceryProduct pasta = ProductHelper.newProduct(injector, GroceryProduct.class, PASTA_DESC, 4.29);
		session.addProduct(pasta, 1);

		OtherProduct cake = ProductHelper.newProduct(injector, OtherProduct.class, CAKE_DESC, 2.35);
		session.addProduct(cake, 1);
		session.refresh();
		return session;
	}
	public static ShoppingSession makeSession1(final Injector injector) {
		ShoppingSession session = injector.getInstance(ShoppingSession.class);

		GroceryProduct pasta = ProductHelper.newProduct(injector, GroceryProduct.class, PASTA_DESC, 4.29);

		session.addProduct(pasta, 1);

		BookProduct book = ProductHelper.newProduct(injector, BookProduct.class, BOOK_DESC, 10.12);

		session.addProduct(book, 1);

		session.refresh();
		return session;
	}
}
