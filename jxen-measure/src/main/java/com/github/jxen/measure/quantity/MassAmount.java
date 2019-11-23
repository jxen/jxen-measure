package com.github.jxen.measure.quantity;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Mass;

/**
 * {@code MassAmount} class represents {@link Quantity} of type {@link Mass}.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public class MassAmount extends QuantityImpl<Mass> implements Mass {

	/**
	 * @param number value
	 * @param unit   unit
	 */
	public MassAmount(Number number, Unit<Mass> unit) {
		super(number, unit);
	}

	/**
	 * @param quantity quantity
	 * @return quantity as {@link MassAmount}
	 */
	public static MassAmount of(Quantity<Mass> quantity) {
		return new MassAmount(quantity.getValue(), quantity.getUnit());
	}
}
