package it.pam.shoppingcart;

import it.pam.shoppingcart.helpers.OfTestHelper;
import it.pam.shoppingcart.impl.sessions.ShoppingSession;
import it.pam.shoppingcart.visualizer.Viewer;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestPrinter {


	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(TestPrinter.class);
	private Injector injector;

	@Before
	public void setUp() throws Exception {
		this.injector = Guice.createInjector(new ShoppingCartTestModule());

	}


	@Test
	public void firstCase() {

		System.out.println("Output 1");

		ShoppingSession session = OfTestHelper.makeSession1(this.injector);

		Viewer view = this.injector.getInstance(Viewer.class);

		view.output(session.getCart());

	}



	@Test
	public void secondCase() {

		System.out.println("Output 2");

		ShoppingSession session = OfTestHelper.makeSession2(this.injector);

		Viewer view = this.injector.getInstance(Viewer.class);

		view.output(session.getCart());


	}


	@Test
	public void thirdCase() {

		System.out.println("Output 3");

		ShoppingSession session = OfTestHelper.makeSession3(this.injector);

		Viewer view = this.injector.getInstance(Viewer.class);

		view.output(session.getCart());


	}



}
