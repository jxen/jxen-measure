package com.github.jxen.measure.format;

import com.github.jxen.measure.unit.AbstractUnit;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.measure.MeasurementException;
import javax.measure.Unit;
import javax.measure.format.UnitFormat;

/**
 * {@code MeasureUnitFormat} class is extension of {@link UnitFormat}.
 *
 * @author Denis Murashev
 * @since Measure 0.1
 */
public abstract class MeasureUnitFormat implements UnitFormat {

	private static final String ERROR_NOT_IMPLEMENTED = "Not implemented yet";
	private static final String ERROR_NO_NAME = "Unit must have name";

	private final List<ResourceBundle> bundles;

	/**
	 * @param defaultName default name
	 * @param names       resource bundle names
	 */
	protected MeasureUnitFormat(String defaultName, String... names) {
		bundles = Stream.concat(Stream.of(defaultName), Stream.of(names))
				.map(ResourceBundle::getBundle)
				.collect(Collectors.toList());
		Collections.reverse(bundles);
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
			// TODO Fix exception type
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
			// TODO Fix exception type
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

	/**
	 * @return {@link LocaleAdapter} for current unit format
	 */
	protected abstract LocaleAdapter getAdapter();

	private String getString(Number value, AbstractUnit<?> unit) {
		int index = unit.getName().indexOf(":");
		String unitKey = "unit.";
		if (index == -1) {
			return getString(unitKey + unit.getName() + getAdapter().getSuffix(value));
		}
		String prefix = getString("prefix." + unit.getName().substring(0, index));
		String name = getString(unitKey + unit.getName().substring(index + 1) + getAdapter().getSuffix(value));
		return prefix + name;
	}

	private String getString(String key) {
		for (ResourceBundle bundle : bundles) {
			if (bundle.containsKey(key)) {
				return bundle.getString(key);
			}
		}
		return forMissing(key);
	}

	private String forMissing(String key) {
		// TODO Make a reasonable solution
		return "[" + key + "]";
	}
}
