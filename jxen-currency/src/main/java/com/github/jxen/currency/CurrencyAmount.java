package com.github.jxen.currency;

import com.github.jxen.math.common.Adapters;
import com.github.jxen.measure.quantity.impl.QuantityImpl;
import javax.measure.Quantity;

/**
 * {@code CurrencyAmount} class represents quantity of currency.
 *
 * @author Denis Murashev
 *
 * @since Currency 0.1
 */
public class CurrencyAmount extends QuantityImpl<Currency> {

	/**
	 * @param number number
	 * @param unit   unit
	 */
	public CurrencyAmount(Number number, CurrencyUnit unit) {
		super(round(number, unit), unit);
	}

	private static Number round(Number value, CurrencyUnit unit) {
		if (value.doubleValue() == 0.0) {
			return value;
		}
		Number one = Adapters.lookup(value).div(value);
		Number min = Adapters.lookup(one).multiply(unit.getMinimal());
		long n = Math.round(Adapters.lookup(value).div(min).doubleValue());
		return Adapters.lookup(min).multiply(n);
	}

	/**
	 * @param quantity quantity
	 * @return currency amount
	 */
	public static CurrencyAmount of(Quantity<Currency> quantity) {
		return new CurrencyAmount(quantity.getValue(), (CurrencyUnit) quantity.getUnit());
	}
}
