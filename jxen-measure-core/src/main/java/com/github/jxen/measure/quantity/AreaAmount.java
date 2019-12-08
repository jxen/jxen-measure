package com.github.jxen.measure.quantity;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Area;

/**
 * {@code AreaAmount} class represents {@link Quantity} of type {@link Area}.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public class AreaAmount extends QuantityImpl<Area> implements Area {

	/**
	 * @param number value
	 * @param unit   unit
	 */
	public AreaAmount(Number number, Unit<Area> unit) {
		super(number, unit);
	}

	/**
	 * @param quantity quantity
	 * @return quantity as {@link AreaAmount}
	 */
	public static AreaAmount of(Quantity<Area> quantity) {
		return new AreaAmount(quantity.getValue(), quantity.getUnit());
	}
}
