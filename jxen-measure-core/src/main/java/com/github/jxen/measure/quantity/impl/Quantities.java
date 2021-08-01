package com.github.jxen.measure.quantity.impl;

import com.github.jxen.math.rational.BigRational;
import com.github.jxen.math.rational.Rational;
import com.github.jxen.measure.unit.AbstractUnit;
import javax.measure.Quantity;
import javax.measure.Quantity.Scale;
import javax.measure.Unit;
import javax.measure.spi.QuantityFactory;
import javax.measure.spi.ServiceProvider;
import javax.measure.spi.SystemOfUnits;

/**
 * {@code Quantities} class is responsible for management of {@link Quantity} entinies.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public final class Quantities {

	private Quantities() {
	}

	/**
	 * @param quantity quantity
	 * @param <Q> quantity type
	 * @return quantity factory
	 */
	public static <Q extends Quantity<Q>> QuantityFactory<Q> getFactory(Class<Q> quantity) {
		final SystemOfUnits systemOfUnits = ServiceProvider.current().getSystemOfUnitsService().getSystemOfUnits();
		return new QuantityFactory<>() {
			@Override
			public Quantity<Q> create(Number value, Unit<Q> unit, Scale scale) {
				throw new UnsupportedOperationException("Not implemented yet");
			}

			@Override
			public Quantity<Q> create(Number value, Unit<Q> unit) {
				return of(value, unit);
			}

			@Override
			public Unit<Q> getSystemUnit() {
				return systemOfUnits.getUnit(quantity);
			}
		};
	}

	/**
	 * @param value value
	 * @param unit  unit
	 * @param <Q> quantity type
	 * @return quantity
	 */
	public static <Q extends Quantity<Q>> Quantity<Q> of(Number value, Unit<Q> unit) {
		if (unit instanceof AbstractUnit) {
			return new QuantityImpl<>(value, (AbstractUnit<Q>) unit);
		}
		throw new UnsupportedOperationException("Unit class is not supported: " + unit.getClass());
	}

	/**
	 * @param quantity quantity
	 * @param unit     unit
	 * @param <Q> quantity type
	 * @return double value
	 */
	public static <Q extends Quantity<Q>> double toDouble(Quantity<Q> quantity, Unit<Q> unit) {
		return quantity.to(unit).getValue().doubleValue();
	}

	/**
	 * @param quantity quantity
	 * @param unit     unit
	 * @param <Q> quantity type
	 * @return float value
	 */
	public static <Q extends Quantity<Q>> float toFloat(Quantity<Q> quantity, Unit<Q> unit) {
		return quantity.to(unit).getValue().floatValue();
	}

	/**
	 * @param quantity quantity
	 * @param unit     unit
	 * @param <Q> quantity type
	 * @return long value
	 */
	public static <Q extends Quantity<Q>> long toLong(Quantity<Q> quantity, Unit<Q> unit) {
		return quantity.to(unit).getValue().longValue();
	}

	/**
	 * @param quantity quantity
	 * @param unit     unit
	 * @param <Q> quantity type
	 * @return int value
	 */
	public static <Q extends Quantity<Q>> long toInt(Quantity<Q> quantity, Unit<Q> unit) {
		return quantity.to(unit).getValue().intValue();
	}

	/**
	 * @param quantity quantity
	 * @param unit     unit
	 * @param <Q> quantity type
	 * @return Rational value
	 */
	public static <Q extends Quantity<Q>> Rational toRational(Quantity<Q> quantity, Unit<Q> unit) {
		return Rational.valueOf(quantity.to(unit).getValue());
	}

	/**
	 * @param quantity quantity
	 * @param unit     unit
	 * @param <Q> quantity type
	 * @return BigRational value
	 */
	public static <Q extends Quantity<Q>> BigRational toBigRational(Quantity<Q> quantity, Unit<Q> unit) {
		return BigRational.valueOf(quantity.to(unit).getValue());
	}
}
