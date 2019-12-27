package com.github.jxen.measure.quantity.impl;

import static com.github.jxen.measure.quantity.impl.Quantities.of;

import com.github.jxen.math.common.Adapters;
import com.github.jxen.math.common.ArithmeticAware;
import java.util.Objects;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;

/**
 * {@code QuantityImpl} class represents generic {@link Quantity} implementation.
 *
 * @author Denis Murashev
 *
 * @param <Q> quantity type
 *
 * @since Measure 0.1
 */
public class QuantityImpl<Q extends Quantity<Q>> implements Quantity<Q>, Comparable<Quantity<Q>> {

	private static final String ERROR_NOT_IMPLEMENTED = "Not implemented yet";

	private final Number value;
	private final Unit<Q> unit;
	private final ArithmeticAware<?> adapter;
	private final Scale scale;

	/**
	 * @param value value
	 * @param unit  unit
	 * @param scale scale
	 */
	protected QuantityImpl(Number value, Unit<Q> unit, Scale scale) {
		this.value = value;
		this.unit = unit;
		adapter = Adapters.lookup(value);
		this.scale = scale;
	}

	/**
	 * @param value value
	 * @param unit  unit
	 */
	protected QuantityImpl(Number value, Unit<Q> unit) {
		this(value, unit, Scale.ABSOLUTE);
	}

	@Override
	public Quantity<Q> add(Quantity<Q> augend) {
		return of(adapter.plus(augend.to(unit).getValue()), unit);
	}

	@Override
	public Quantity<Q> subtract(Quantity<Q> subtrahend) {
		return of(adapter.minus(subtrahend.to(unit).getValue()), unit);
	}

	@Override
	public Quantity<?> divide(Quantity<?> divisor) {
		return of(adapter.div(divisor.getValue()), unit.divide(divisor.getUnit()));
	}

	@Override
	public Quantity<Q> divide(Number divisor) {
		return of(adapter.div(divisor), unit);
	}

	@Override
	public Quantity<?> multiply(Quantity<?> multiplier) {
		return of(adapter.multiply(multiplier.getValue()), unit.multiply(multiplier.getUnit()));
	}

	@Override
	public Quantity<Q> multiply(Number multiplier) {
		return of(adapter.multiply(multiplier), unit);
	}

	@Override
	public Quantity<Q> to(Unit<Q> unit) {
		return unit.equals(getUnit()) ? this : of(adjust(unit), unit);
	}

	@Override
	public Quantity<?> inverse() {
		return of(adapter.reciprocal(), unit.inverse());
	}

	@Override
	public Quantity<Q> negate() {
		return of(adapter.negate(), unit);
	}

	@Override
	public <T extends Quantity<T>> Quantity<T> asType(Class<T> type) {
		throw new UnsupportedOperationException(ERROR_NOT_IMPLEMENTED);
	}

	@Override
	public Number getValue() {
		return value;
	}

	@Override
	public Unit<Q> getUnit() {
		return unit;
	}

	@Override
	public Scale getScale() {
		return scale;
	}

	@Override
	public int compareTo(Quantity<Q> o) {
		Quantity<Q> other = unit.equals(o.getUnit()) ? o : o.to(unit);
		return Double.compare(value.doubleValue(), other.getValue().doubleValue());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}
		Quantity<?> quantity = (Quantity<?>) o;
		return value.equals(quantity.getValue())
				&& unit.equals(quantity.getUnit())
				&& scale.equals(quantity.getScale());
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, unit, scale);
	}

	@Override
	public String toString() {
		return String.format("%s%s", value, unit);
	}

	private Number adjust(Unit<Q> unit) {
		UnitConverter converter = getUnit().getConverterTo(unit);
		return converter.convert(getValue());
	}
}
