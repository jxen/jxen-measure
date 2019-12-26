package com.github.jxen.measure.spi.adapter;

import com.github.jxen.math.common.Adapters;
import com.github.jxen.math.common.ArithmeticAware;
import com.github.jxen.measure.format.LocaleAdapter;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.yaml.snakeyaml.Yaml;

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

	private final Set<String> feminineNames = new HashSet<>();
	private final Set<String> neuterNames = new HashSet<>();

	RuLocaleAdapter() {
		Class<?> type = getClass();
		while (type != Object.class) {
			InputStream inputStream = type.getResourceAsStream(type.getSimpleName() + ".yaml");
			if (inputStream != null) {
				Map<String, List<String>> map = new Yaml().load(inputStream);
				feminineNames.addAll(Optional.ofNullable(map.get("feminine")).orElse(Collections.emptyList()));
				neuterNames.addAll(Optional.ofNullable(map.get("neuter")).orElse(Collections.emptyList()));
			}
			type = type.getSuperclass();
		}
	}

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
		if (feminineNames.contains(name)) {
			return ".f";
		}
		if (neuterNames.contains(name)) {
			return ".n";
		}
		return "";
	}
}
