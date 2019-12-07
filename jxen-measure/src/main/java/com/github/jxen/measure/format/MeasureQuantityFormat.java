package com.github.jxen.measure.format;

import com.github.jxen.measure.unit.AbstractUnit;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.List;
import java.util.stream.Collectors;
import javax.measure.MeasurementException;
import javax.measure.Quantity;
import javax.measure.format.QuantityFormat;

/**
 * {@code MeasureQuantityFormat} class is extension of {@link QuantityFormat}.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public class MeasureQuantityFormat implements QuantityFormat {

	private static final String ERROR_NOT_IMPLEMENTED = "Not implemented yet";

	private static final String DELIMITER = "\u202F";

	private final NumberFormat numberFormat;
	private final MeasureUnitFormat unitFormat;

	/**
	 * @param numberFormat number format
	 * @param unitFormat   unit format
	 */
	public MeasureQuantityFormat(NumberFormat numberFormat, MeasureUnitFormat unitFormat) {
		this.numberFormat = numberFormat;
		this.unitFormat = unitFormat;
	}

	/**
	 * @param numberFormat number format
	 */
	public MeasureQuantityFormat(NumberFormat numberFormat) {
		this(numberFormat, new DefaultUnitFormat());
	}

	/**
	 * @param unitFormat unit format
	 */
	public MeasureQuantityFormat(MeasureUnitFormat unitFormat) {
		this(new DefaultNumberFormat(), unitFormat);
	}

	/**
	 * Default formatter.
	 */
	public MeasureQuantityFormat() {
		this(new DefaultNumberFormat(), new DefaultUnitFormat());
	}

	@Override
	public Appendable format(Quantity<?> quantity, Appendable appendable) {
		try {
			appendable.append(numberFormat.format(quantity.getValue()));
			String unit = quantity.getUnit() instanceof AbstractUnit
					? unitFormat.format(quantity.getValue(), (AbstractUnit<?>) quantity.getUnit())
					: unitFormat.format(quantity.getUnit());
			if (!unit.matches("[^\\p{L}]")) {
				appendable.append(DELIMITER);
			}
			appendable.append(unit);
			return appendable;
		} catch (IOException e) {
			// TODO Fix exception type
			throw new MeasurementException(e);
		}
	}

	@Override
	public String format(Quantity<?> quantity) {
		return format(quantity, new StringBuilder()).toString();
	}

	/**
	 * Formats given quantity.
	 *
	 * @param quantities list of quantities
	 * @param appendable appendable
	 * @param <Q> quantity type
	 * @return appendable with formatted string
	 */
	public <Q extends Quantity<Q>> Appendable format(List<Quantity<Q>> quantities, Appendable appendable) {
		try {
			appendable.append(quantities.stream().map(this::format).collect(Collectors.joining(" ")));
		} catch (IOException e) {
			throw new MeasurementException("Error formatting String", e);
		}
		return appendable;
	}

	/**
	 * Formats given quantity.
	 *
	 * @param quantities list of quantities
	 * @param <Q> quantity type
	 * @return formatted string
	 */
	public <Q extends Quantity<Q>> String format(List<Quantity<Q>> quantities) {
		return format(quantities, new StringBuilder()).toString();
	}

	@Override
	public Quantity<?> parse(CharSequence csq, ParsePosition pos) {
		throw new UnsupportedOperationException(ERROR_NOT_IMPLEMENTED);
	}

	@Override
	public Quantity<?> parse(CharSequence csq) {
		throw new UnsupportedOperationException(ERROR_NOT_IMPLEMENTED);
	}
}
