package com.github.jxen.measure.format;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 * {@code DefaultNumberFormat} class is default number format ({@link NumberFormat}) for Measure project.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.2
 */
public class DefaultNumberFormat extends NumberFormat {

	private static final long serialVersionUID = 7545614217280417444L;

	private static final int DEFAULT_DIGITS = 4;
	private static final double TEN = 10;
	private static final double ONE_TENTH = 1 / TEN;

	private final int digits;
	private final double max;

	/**
	 * @param digits number of digits to display
	 */
	public DefaultNumberFormat(int digits) {
		this.digits = digits;
		max = Math.pow(TEN, digits);
	}

	DefaultNumberFormat() {
		this(DEFAULT_DIGITS);
	}

	@Override
	public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
		double abs = Math.abs(number);
		if (abs > max || abs < ONE_TENTH) {
			return new DecimalFormat(exponential(digits - 1)).format(number, toAppendTo, pos);
		}
		int count = digits - (int) Math.floor(Math.log10(abs)) - 1;
		return new DecimalFormat(normal(count)).format(number, toAppendTo, pos);
	}

	@Override
	public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
		return DecimalFormat.getInstance().format(number, toAppendTo, pos);
	}

	@Override
	public Number parse(String source, ParsePosition parsePosition) {
		return DecimalFormat.getInstance().parse(source, parsePosition);
	}

	private String normal(int digits) {
		return prepare(digits).toString();
	}

	private String exponential(int digits) {
		return prepare(digits).append("E0").toString();
	}

	private StringBuilder prepare(int digits) {
		if (digits <= 0) {
			return new StringBuilder("0");
		}
		StringBuilder builder = new StringBuilder("0.");
		for (int i = 0; i < digits; i++) {
			builder.append('#');
		}
		return builder;
	}
}
