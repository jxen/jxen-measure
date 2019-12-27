package com.github.jxen.measure.quantity.impl;

import javax.measure.Quantity;
import javax.measure.Unit;
import si.uom.quantity.Density;

/**
 * {@code DensityAmount} class represents {@link Quantity} of type {@link Density}.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public class DensityAmount extends QuantityImpl<Density> implements Density {

	/**
	 * @param number number
	 * @param unit   unit
	 */
	public DensityAmount(Number number, Unit<Density> unit) {
		super(number, unit);
	}

	/**
	 * @param quantity quantity
	 * @return density
	 */
	public static DensityAmount of(Quantity<Density> quantity) {
		return new DensityAmount(quantity.getValue(), quantity.getUnit());
	}
}
