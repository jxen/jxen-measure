package com.github.jxen.measure.quantity.impl;

import com.github.jxen.measure.unit.AbstractUnit;
import java.util.function.BiFunction;
import javax.measure.Quantity;
import javax.measure.quantity.Area;

/**
 * {@code AreaAmount} class represents {@link Quantity} of type {@link Area}.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public class AreaAmount extends AbstractQuantity<Area> implements Area {

	/**
	 * @param number value
	 * @param unit   unit
	 */
	public AreaAmount(Number number, AbstractUnit<Area> unit) {
		super(number, unit);
	}

	@Override
	protected BiFunction<Number, AbstractUnit<Area>, Area> factory() {
		return AreaAmount::new;
	}
}
