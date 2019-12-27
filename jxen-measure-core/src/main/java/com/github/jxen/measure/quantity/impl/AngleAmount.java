package com.github.jxen.measure.quantity.impl;

import com.github.jxen.measure.unit.AbstractUnit;
import java.util.function.BiFunction;
import javax.measure.Quantity;
import javax.measure.quantity.Angle;

/**
 * {@code AngleAmount} class represents {@link Quantity} of type {@link Angle}.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public class AngleAmount extends AbstractQuantity<Angle> implements Angle {

	/**
	 * @param number value
	 * @param unit   unit
	 */
	public AngleAmount(Number number, AbstractUnit<Angle> unit) {
		super(number, unit);
	}

	@Override
	protected BiFunction<Number, AbstractUnit<Angle>, Angle> factory() {
		return AngleAmount::new;
	}
}
