package com.github.jxen.measure.quantity.impl;

import com.github.jxen.measure.unit.AbstractUnit;
import java.util.function.BiFunction;
import javax.measure.Quantity;
import javax.measure.quantity.Length;

/**
 * {@code LengthAmount} class represents {@link Quantity} of type {@link Length}.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public class LengthAmount extends AbstractQuantity<Length> implements Length {

	/**
	 * @param number value
	 * @param unit   unit
	 */
	public LengthAmount(Number number, AbstractUnit<Length> unit) {
		super(number, unit);
	}

	@Override
	protected BiFunction<Number, AbstractUnit<Length>, Length> factory() {
		return LengthAmount::new;
	}
}
