

package it.pam.shoppingcart.helpers;

import static org.assertj.core.api.Assertions.*;

import org.joda.money.Money;
import org.junit.Test;



public class DiscountHelperTest {


	@Test
	public void roundToNearest5c() {


		Money value = MoneyHelper.newEuro(3.31);
		Money result = DiscountHelper.roundToNearest5c(value);
		assertThat(result).isEqualTo(MoneyHelper.newEuro(3.30));

		value = MoneyHelper.newEuro(3.33);
		result = DiscountHelper.roundToNearest5c(value);
		assertThat(result).isEqualTo(MoneyHelper.newEuro(3.35));

		value = MoneyHelper.newEuro(3.37);
		result = DiscountHelper.roundToNearest5c(value);
		assertThat(result).isEqualTo(MoneyHelper.newEuro(3.35));

		value = MoneyHelper.newEuro(3.38);
		result = DiscountHelper.roundToNearest5c(value);
		assertThat(result).isEqualTo(MoneyHelper.newEuro(3.40));
	}
}
