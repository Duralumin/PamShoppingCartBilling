package it.pam.shoppingcart.visualizer;

import it.pam.shoppingcart.carts.DiscountableCart;
import it.pam.shoppingcart.carts.DiscountableItem;

import java.util.List;

import org.apache.log4j.Logger;
import org.joda.money.Money;

import com.google.common.base.Strings;

public class SysoutVisualizer implements Visualizer {

	private static final int CELL_LENGTH = 18;
	private static final String SEPARATOR = "|";
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(SysoutVisualizer.class);

	@Override
	public void output(final DiscountableCart cart) {

		List<DiscountableItem> items = cart.getItems();
		String out = "";
		out = row(Strings.repeat("-", CELL_LENGTH * 5 + 5));
		out += cell("");
		out += cell("Quantity");
		out += cell("UnitPrice");
		out += cell("Discount");
		out += cell("FinalPrice");
		out = row(out);
		for (DiscountableItem item : items) {
			out += cell(item.getDescription());
			out += cell(item.getQuantity());
			out += cell(item.getUnitPrice());
			out += cellPercentage(item.getDiscountPercentage());
			out += cell(item.getFinalPrice());
			out = row(out);
		}

		if (cart.getCartDiscount().isPositive()) {
			out += cell("Gross Total");
			out += Strings.repeat(cell(""), 3);
			out += cell(cart.getGrossTotal());
			out = row(out);

			out += cell(cart.getDiscountPolicy().getDescription());
			out += Strings.repeat(cell(""), 2);
			out += cellPercentage(cart.getDiscountPolicy().getPercentage());
			out += cell(cart.getCartDiscount());
			out = row(out);
		}

		out += cell("Total");
		out += Strings.repeat(cell(""), 3);
		out += cell(cart.getFinalPrice());
		out = row(out);
		out = row(Strings.repeat("-", CELL_LENGTH * 5 + 5));

		out = row("(Total discounts " + cart.getTotalDiscount() + ")");

		out = row("");


	}

	public String row(final String out) {
		System.out.println(out);
		return "";
	}

	private String cell(final Money price) {
		return cell(price.toString());
	}

	private String cell(final int i) {
		return cell(Integer.valueOf(i).toString());
	}

	private String cellPercentage(final double d) {
		if (d == 0) {
			return cell("0%");
		}
		return cell(Double.valueOf(d).toString() + "%");
	}

	private String cell(final double d) {
		return cell(Double.valueOf(d).toString());
	}

	private String cell(final String string) {
		return Strings.padEnd(string, CELL_LENGTH, ' ') + SEPARATOR;
	}
}
