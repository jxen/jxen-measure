package com.github.jxen.measure.format;

import static java.util.stream.Collectors.joining;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import javax.measure.MeasurementException;
import javax.measure.Prefix;
import javax.measure.Unit;

/**
 * {@code UnitNameHelper} class helps with unit name creation and formatting.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.2
 */
public final class UnitNameHelper {

	private static final char PREFIX = ':';
	private static final char STAR = '*';
	private static final char DIV = '/';
	private static final char POW = '^';

	private static final String STAR_REGEX = "[*]";

	private UnitNameHelper() {
	}

	/**
	 * @param prefix prefix
	 * @param unit   unit
	 * @return unit name with prefix
	 */
	public static String prefix(Prefix prefix, Unit<?> unit) {
		UnitName name = parse(unit.getName());
		if (!name.denominator.isEmpty() || name.numerator.size() != 1) {
			throw new MeasurementException("Cannot add prefix to unit: " + unit);
		}
		if (Objects.nonNull(name.numerator.get(0).prefix)) {
			throw new MeasurementException("Cannot add two prefixes to unit: " + unit);
		}
		name.numerator.get(0).prefix = prefix.getName();
		return name.toString();
	}

	/**
	 * @param left  left unit
	 * @param right right unit
	 * @return name of product of units
	 */
	public static String multiply(Unit<?> left, Unit<?> right) {
		UnitName leftName = parse(left.getName());
		UnitName rightName = parse(right.getName());
		UnitName result = new UnitName();
		result.numerator.addAll(leftName.numerator);
		result.numerator.addAll(rightName.numerator);
		result.denominator.addAll(leftName.denominator);
		result.denominator.addAll(rightName.denominator);
		return result.toString();
	}

	/**
	 * @param left  left unit
	 * @param right right unit
	 * @return name of ratio of units
	 */
	public static String divide(Unit<?> left, Unit<?> right) {
		UnitName leftName = parse(left.getName());
		UnitName rightName = parse(right.getName());
		UnitName result = new UnitName();
		result.numerator.addAll(leftName.numerator);
		result.numerator.addAll(rightName.denominator);
		result.denominator.addAll(leftName.denominator);
		result.denominator.addAll(rightName.numerator);
		return result.toString();
	}

	/**
	 * @param unit unit
	 * @param n    exponent
	 * @return name of unit to the nth power
	 */
	public static String pow(Unit<?> unit, int n) {
		UnitName name = parse(unit.getName());
		name.numerator.forEach(p -> part(p, n));
		name.denominator.forEach(p -> part(p, n));
		return name.toString();
	}

	private static void part(Part part, int n) {
		if (Objects.isNull(part.suffix)) {
			part.suffix = String.valueOf(n);
		} else {
			try {
				int power = n * Integer.parseInt(part.suffix);
				part.suffix = String.valueOf(power);
			} catch (NumberFormatException e) {
				throw new MeasurementException(e);
			}
		}
	}

	private static UnitName parse(String unit) {
		UnitName unitName = new UnitName();
		int index = unit.indexOf(DIV);
		if (index == -1) {
			parse(unit, unitName.numerator);
		} else {
			parse(unit.substring(0, index), unitName.numerator);
			parse(unit.substring(index + 1), unitName.denominator);
		}
		return unitName;
	}

	private static void parse(String value, List<Part> parts) {
		String[] units = value.split(STAR_REGEX);
		for (String unit : units) {
			parts.add(Part.parse(unit));
		}
	}

	abstract static class Formatter {

		private static final String PREFIX = "prefix.";
		private static final String SUFFIX = "suffix.";

		private final LocaleAdapter adapter;
		private final List<ResourceBundle> bundles;

		Formatter(LocaleAdapter adapter, List<ResourceBundle> bundles) {
			this.adapter = adapter;
			this.bundles = bundles;
		}

		abstract String format(Number value, String unit);

		String format(Number value, Part part) {
			StringBuilder builder = new StringBuilder();
			if (Objects.nonNull(part.prefix)) {
				builder.append(getString(PREFIX + part.prefix));
			}
			builder.append(getString("unit." + adapter.name(part.name, value)));
			if (Objects.isNull(part.suffix)) {
				return builder.toString();
			}
			return MessageFormat.format(getString(SUFFIX + adapter.suffix(part.suffix, part.name, value)),
					builder.toString());
		}

		String formatDenom(Part part) {
			String prefix = Optional.ofNullable(part.prefix).map(v -> getString(PREFIX + v)).orElse("");
			String name = MessageFormat.format(getString("per." + part.name), prefix);
			if (Objects.isNull(part.suffix)) {
				return name;
			}
			return MessageFormat.format(getString(SUFFIX + part.suffix + ".denom"), name);
		}

		String getString(String key) {
			for (ResourceBundle bundle : bundles) {
				if (bundle.containsKey(key)) {
					return bundle.getString(key);
				}
			}
			return String.format("[%s]", key);
		}
	}

	static final class DefaultFormatter extends Formatter {

		DefaultFormatter(LocaleAdapter adapter, List<ResourceBundle> bundles) {
			super(adapter, bundles);
		}

		@Override
		String format(Number value, String unit) {
			StringBuilder builder = new StringBuilder();
			UnitName name = parse(unit);
			final String bullet = "\u2022"; // bullet symbol
			builder.append(name.numerator.stream().map(p -> format(value, p)).collect(joining(bullet)));
			if (!name.denominator.isEmpty()) {
				builder.append(DIV);
				builder.append(name.denominator.stream().map(p -> format(value, p)).collect(joining(bullet)));
			}
			return builder.toString();
		}
	}

	static final class FullFormatter extends Formatter {

		FullFormatter(LocaleAdapter adapter, List<ResourceBundle> bundles) {
			super(adapter, bundles);
		}

		@Override
		String format(Number value, String unit) {
			UnitName name = parse(unit);
			if (name.numerator.size() > 1) {
				return "?";
			}
			if (name.denominator.isEmpty()) {
				return format(value, name.numerator.get(0));
			}
			if (name.denominator.size() > 1) {
				return "?/?";
			}
			char space = '\u202F'; // unbreakable space
			return format(value, name.numerator.get(0)) + space + formatDenom(name.denominator.get(0));
		}
	}

	private static final class UnitName {

		private final List<Part> numerator = new ArrayList<>();
		private final List<Part> denominator = new ArrayList<>();

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(numerator.stream().map(Part::toString).collect(joining(String.valueOf(STAR))));
			if (!denominator.isEmpty()) {
				builder.append(DIV).append(denominator.stream().map(Part::toString)
						.collect(joining(String.valueOf(STAR))));
			}
			return builder.toString();
		}
	}

	private static final class Part {

		private String prefix;
		private final String name;
		private String suffix;

		private Part(String prefix, String name, String suffix) {
			this.prefix = prefix;
			this.name = name;
			this.suffix = suffix;
		}

		static Part parse(String unit) {
			int start = unit.indexOf(PREFIX);
			String prefix = start == -1 ? null : unit.substring(0, start);
			int end = unit.indexOf(POW);
			String suffix = end == -1 ? null : unit.substring(end + 1);
			start++;
			String name = end == -1 ? unit.substring(start) : unit.substring(start, end);
			return new Part(prefix, name, suffix);
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			if (prefix != null) {
				builder.append(prefix).append(PREFIX);
			}
			builder.append(name);
			if (suffix != null) {
				builder.append(POW).append(suffix);
			}
			return builder.toString();
		}
	}
}
