package com.github.jxen.measure.format;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

/**
 * {@code FullUnitFormat} class is extension of {@link MeasureUnitFormat}.
 *
 * @author Denis Murashev
 * @since Measure 0.1
 */
public class FullUnitFormat extends MeasureUnitFormat {

	private static final String DEFAULT_BUNDLE_NAME = "unit-full";

	private static final LocaleAdapter DEFAULT_ADAPTER = new DefaultLocaleAdapter();

	private static final Map<Locale, LocaleAdapter> ADAPTERS = new HashMap<>();

	static {
		ADAPTERS.put(new Locale("ru", "RU"), new RuLocaleAdapter());
	}

	/**
	 * Initializes default unit format.
	 */
	public FullUnitFormat() {
		super(DEFAULT_BUNDLE_NAME);
	}

	/**
	 * @param names resource bundle names
	 */
	protected FullUnitFormat(String... names) {
		super(DEFAULT_BUNDLE_NAME, names);
	}

	/**
	 * @param locale  locale
	 * @param adapter adapter
	 */
	public static void addAdapter(Locale locale, LocaleAdapter adapter) {
		ADAPTERS.put(locale, adapter);
	}

	@Override
	protected LocaleAdapter getAdapter() {
		return Optional.ofNullable(ADAPTERS.get(Locale.getDefault())).orElse(DEFAULT_ADAPTER);
	}
}
