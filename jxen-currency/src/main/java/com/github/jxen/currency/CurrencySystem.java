package com.github.jxen.currency;

import com.github.jxen.measure.quantity.QuantityDecomposer;
import java.util.Arrays;
import javax.measure.MeasurementException;
import javax.measure.Unit;

/**
 * {@code CurrencySystem} class generally represents currency system with base unit and its fractions.
 * It uses {@link QuantityDecomposer} functionality.
 *
 * @author Denis Murashev
 *
 * @since Currency 0.1
 */
public class CurrencySystem extends QuantityDecomposer<Currency> {

	private final CurrencyUnit baseUnit;

	/**
	 * @param units units
	 */
	public CurrencySystem(CurrencyUnit... units) {
		super(Arrays.asList(units));
		this.baseUnit = units[0];
	}

	/**
	 * @return the baseUnit
	 */
	public CurrencyUnit getBaseUnit() {
		return baseUnit;
	}

	/**
	 * @param name name
	 * @return currency unit
	 */
	public CurrencyUnit forCode(String name) {
		for (Unit<Currency> unit : getUnits()) {
			if (unit.getName().equals(name)) {
				return (CurrencyUnit) unit;
			}
		}
		throw new MeasurementException("Unknown currency unit: " + name);
	}
}
