package it.pam.shoppingcart;

import java.util.List;

import org.apache.log4j.Logger;
import org.assertj.core.util.Lists;

public class Bill {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(Bill.class);

	private final List<BillItem> billItems = Lists.newArrayList();

	public List<BillItem> getProducts() {
		return this.billItems;
	}

}
