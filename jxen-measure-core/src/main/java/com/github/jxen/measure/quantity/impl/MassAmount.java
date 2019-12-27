package com.github.jxen.measure.quantity.impl;

import com.github.jxen.measure.unit.AbstractUnit;
import java.util.function.BiFunction;
import javax.measure.Quantity;
import javax.measure.quantity.Mass;

/**
 * {@code MassAmount} class represents {@link Quantity} of type {@link Mass}.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public class MassAmount extends AbstractQuantity<Mass> implements Mass {

	/**
	 * @param number value
	 * @param unit   unit
	 */
	public MassAmount(Number number, AbstractUnit<Mass> unit) {
		super(number, unit);
	}

	@Override
	protected BiFunction<Number, AbstractUnit<Mass>, Mass> factory() {
		return MassAmount::new;
	}
}
