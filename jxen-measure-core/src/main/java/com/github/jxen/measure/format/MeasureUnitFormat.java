package com.github.jxen.measure.format;

import com.github.jxen.measure.unit.AbstractUnit;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javax.measure.MeasurementException;
import javax.measure.Unit;
import javax.measure.format.UnitFormat;

/**
 * {@code MeasureUnitFormat} class is extension of {@link UnitFormat}.
 * Each extension of the class must have corresponding resource bundle with suffix "_unit".
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public abstract class MeasureUnitFormat implements UnitFormat {

	private static final String ERROR_NOT_IMPLEMENTED = "Not implemented yet";
	private static final String ERROR_NO_NAME = "Unit must have name";

	private final List<ResourceBundle> bundles = new ArrayList<>();

	/**
	 * Initializes resource bundles for unit names
	 */
	protected MeasureUnitFormat() {
		Class<?> type = getClass();
		while (type != MeasureUnitFormat.class) {
			String name = type.getName() + "_unit";
			bundles.add(ResourceBundle.getBundle(name));
			type = type.getSuperclass();
		}
	}

	@Override
	public Appendable format(Unit<?> unit, Appendable appendable) {
		Objects.requireNonNull(unit.getName(), ERROR_NO_NAME);
		try {
			if (unit instanceof AbstractUnit) {
				return format(1, (AbstractUnit<?>) unit, appendable);
			}
			return appendable.append(unit.getSymbol());
		} catch (IOException e) {
			throw new MeasurementException(e);
		}
	}

	@Override
	public String format(Unit<?> unit) {
		return format(unit, new StringBuilder()).toString();
	}

	/**
	 * @param value      value
	 * @param unit       unit
	 * @param appendable appendable
	 * @return appendable
	 */
	protected Appendable format(Number value, AbstractUnit<?> unit, Appendable appendable) {
		Objects.requireNonNull(unit.getName(), ERROR_NO_NAME);
		try {
			return appendable.append(getString(value, unit));
		} catch (IOException e) {
			throw new MeasurementException(e);
		}
	}

	/**
	 * @param value value
	 * @param unit  unit
	 * @return string representation
	 */
	protected String format(Number value, AbstractUnit<?> unit) {
		return format(value, unit, new StringBuilder()).toString();
	}

	@Override
	public void label(Unit<?> unit, String label) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isLocaleSensitive() {
		return true;
	}

	@Override
	public Unit<?> parse(CharSequence csq, ParsePosition pos) {
		throw new UnsupportedOperationException(ERROR_NOT_IMPLEMENTED);
	}

	@Override
	public Unit<?> parse(CharSequence csq) {
		throw new UnsupportedOperationException(ERROR_NOT_IMPLEMENTED);
	}

	abstract UnitNameHelper.Formatter getFormatter(List<ResourceBundle> bundles);

	private String getString(Number value, AbstractUnit<?> unit) {
		return getFormatter(bundles).format(value, unit.getName());
	}
}
