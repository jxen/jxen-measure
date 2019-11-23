package com.github.jxen.measure.quantity;

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
		return new QuantityFactory<Q>() {
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
		return new QuantityImpl<>(value, unit);
	}
}
