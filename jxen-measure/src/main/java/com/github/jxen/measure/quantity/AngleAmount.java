package com.github.jxen.measure.quantity;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Angle;

/**
 * {@code AngleAmount} class represents {@link Quantity} of type {@link Angle}.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public class AngleAmount extends QuantityImpl<Angle> implements Angle {

	/**
	 * @param number value
	 * @param unit   unit
	 */
	public AngleAmount(Number number, Unit<Angle> unit) {
		super(number, unit);
	}

	/**
	 * @param quantity quantity
	 * @return quantity as {@link AngleAmount}
	 */
	public static AngleAmount of(Quantity<Angle> quantity) {
		return new AngleAmount(quantity.getValue(), quantity.getUnit());
	}
}
