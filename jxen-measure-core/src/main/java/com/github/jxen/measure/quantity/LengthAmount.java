package com.github.jxen.measure.quantity;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;

/**
 * {@code LengthAmount} class represents {@link Quantity} of type {@link Length}.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public class LengthAmount extends QuantityImpl<Length> implements Length {

	/**
	 * @param number value
	 * @param unit   unit
	 */
	public LengthAmount(Number number, Unit<Length> unit) {
		super(number, unit);
	}

	/**
	 * @param quantity quantity
	 * @return quantity as {@link LengthAmount}
	 */
	public static LengthAmount of(Quantity<Length> quantity) {
		return new LengthAmount(quantity.getValue(), quantity.getUnit());
	}
}
