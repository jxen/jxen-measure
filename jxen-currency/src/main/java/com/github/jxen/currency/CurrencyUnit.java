package com.github.jxen.currency;

import static com.github.jxen.measure.dimension.Dimensions.DIMENSIONLESS;

import com.github.jxen.math.common.Adapters;
import com.github.jxen.measure.converter.Converters;
import com.github.jxen.measure.quantity.impl.Quantities;
import com.github.jxen.measure.unit.AbstractUnit;
import java.util.Map;
import java.util.Objects;
import javax.measure.Dimension;
import javax.measure.Unit;
import javax.measure.UnitConverter;

/**
 * {@code CurrencyUnit} class represents currency unit of measurement.
 *
 * @author Denis Murashev
 *
 * @since Currency 0.1
 */
public class CurrencyUnit extends AbstractUnit<Currency> implements Comparable<CurrencyUnit> {

	/**
	 * System currency unit.
	 */
	public static final CurrencyUnit SYSTEM_UNIT = new CurrencyUnit("system.currency", 1);

	private final Number value;
	private final Number minimal;

	/**
	 * @param name    name
	 * @param value   value
	 * @param minimal minimal fraction of currency quantity
	 */
	public CurrencyUnit(String name, Number value, Number minimal) {
		super(name);
		this.value = value;
		this.minimal = minimal;
	}

	/**
	 * @param name  name
	 * @param value value
	 */
	public CurrencyUnit(String name, Number value) {
		this(name, value, 1);
	}

	/**
	 * @param name     name
	 * @param baseUnit base unit
	 * @param fraction fraction
	 */
	public CurrencyUnit(String name, CurrencyUnit baseUnit, Number fraction) {
		this(name, Adapters.lookup(baseUnit.value).multiply(fraction), Adapters.lookup(baseUnit.minimal).div(fraction));
	}

	/**
	 * @return the value
	 */
	public Number getValue() {
		return value;
	}

	/**
	 * @return the minimal fraction
	 */
	public Number getMinimal() {
		return minimal;
	}

	@Override
	public Dimension getDimension() {
		return DIMENSIONLESS;
	}

	@Override
	public Map<? extends Unit<?>, Integer> getBaseUnits() {
		throw new UnsupportedOperationException("Is not implemented yet");
	}

	@Override
	public UnitConverter getSystemConverter() {
		return Converters.fromFactor(value);
	}

	@Override
	protected AbstractUnit<Currency> toSystemUnit() {
		return SYSTEM_UNIT;
	}

	@Override
	public int compareTo(CurrencyUnit o) {
		return Double.compare(1, Quantities.of(1, o).to(this).getValue().doubleValue());
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
		CurrencyUnit that = (CurrencyUnit) o;
		return value.equals(that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
