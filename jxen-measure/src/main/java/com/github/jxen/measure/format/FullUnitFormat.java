package com.github.jxen.measure.format;

import com.github.jxen.measure.format.UnitNameHelper.FullFormatter;
import com.github.jxen.measure.spi.LocaleService;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.ServiceLoader;

/**
 * {@code FullUnitFormat} class is extension of {@link MeasureUnitFormat}.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public class FullUnitFormat extends MeasureUnitFormat {

	private static final String DEFAULT_BUNDLE_NAME = "unit-full";

	private static final LocaleAdapter DEFAULT_ADAPTER = new DefaultLocaleAdapter();

	private static final Map<Locale, LocaleAdapter> ADAPTERS = new HashMap<>();

	static {
		for (LocaleService service : ServiceLoader.load(LocaleService.class)) {
			ADAPTERS.putIfAbsent(service.getLocale(), service.getAdapter());
		}
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

	@Override
	protected UnitNameHelper.Formatter getFormatter(List<ResourceBundle> bundles) {
		LocaleAdapter adapter = Optional.ofNullable(ADAPTERS.get(Locale.getDefault())).orElse(DEFAULT_ADAPTER);
		return new FullFormatter(adapter, bundles);
	}
}
