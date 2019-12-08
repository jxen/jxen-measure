package com.github.jxen.measure.spi.adapter;

import static java.util.Arrays.asList;

import com.github.jxen.math.common.Adapters;
import com.github.jxen.math.common.ArithmeticAware;
import com.github.jxen.measure.format.LocaleAdapter;
import java.util.HashSet;
import java.util.Set;

/**
 * {@code RuLocaleService} class is Locale adapter for Russian locale.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
class RuLocaleAdapter implements LocaleAdapter {

	private static final String PART = ".part";
	private static final String PLURAL = ".plural";

	private static final String[] FEMININE = {
			"candela",
			"minute",
			"minute_angle",
			"second",
			"second_angle",
			"tonne",
			"week",
	};

	private static final Set<String> FEMININE_NAMES = new HashSet<>(asList(FEMININE));

	@Override
	public String name(String name, Number number) {
		ArithmeticAware<?> adapter = Adapters.lookup(number);
		if (!adapter.isIntegral()) {
			return name + PART;
		}
		final long ten = 10;
		long value = number.longValue();
		long rem10 = value % ten;
		long rem100 = value % (ten * ten);
		final long eleven = 11;
		if (rem10 == 1 && rem100 != eleven) {
			return name;
		}
		final long five = 5;
		final long fifteen = 15;
		if (rem10 == 0 || rem10 >= five || rem100 >= eleven && rem100 < fifteen) {
			return name + PLURAL;
		}
		return name + PART;
	}

	@Override
	public String suffix(String suffix, String name, Number number) {
		ArithmeticAware<?> adapter = Adapters.lookup(number);
		if (!adapter.isIntegral()) {
			return suffix + PART + genderSuffix(name);
		}
		final long ten = 10;
		long value = number.longValue();
		long rem10 = value % ten;
		long rem100 = value % (ten * ten);
		final long eleven = 11;
		if (rem10 == 1 && rem100 != eleven) {
			return suffix + genderSuffix(name);
		}
		return suffix + PLURAL + genderSuffix(name);
	}

	private String genderSuffix(String name) {
		if (isFeminine(name)) {
			return ".f";
		}
		if (isNeuter(name)) {
			return ".n";
		}
		return "";
	}

	@Override
	public boolean isFeminine(String name) {
		return FEMININE_NAMES.contains(name);
	}
}
