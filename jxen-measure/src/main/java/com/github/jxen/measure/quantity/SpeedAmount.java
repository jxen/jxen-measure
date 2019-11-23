package com.github.jxen.measure.quantity;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Speed;

/**
 * {@code SpeedAmount} class represents {@link Quantity} of type {@link Speed}.
 *
 * @author Denis Murashev
 * @since Measure 0.1
 */
public class SpeedAmount extends QuantityImpl<Speed> {

	/**
	 * @param number value
	 * @param unit   unit
	 */
	public SpeedAmount(Number number, Unit<Speed> unit) {
		super(number, unit);
	}

	/**
	 * @param quantity quantity
	 * @return quantity as {@link SpeedAmount}
	 */
	public static SpeedAmount of(Quantity<Speed> quantity) {
		return new SpeedAmount(quantity.getValue(), quantity.getUnit());
	}
}
