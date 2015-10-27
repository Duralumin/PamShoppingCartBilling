package it.pam.shoppingcart.visualizer;

import it.pam.shoppingcart.carts.DiscountableCart;

import org.apache.log4j.Logger;

import com.google.inject.Inject;

public class Viewer {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Viewer.class);
	private final Visualizer visualizer;

	@Inject
	public Viewer(final Visualizer visualizer) {

		this.visualizer = visualizer;

	}

	public void output(final DiscountableCart cart) {

		this.visualizer.output(cart);

	}


}
