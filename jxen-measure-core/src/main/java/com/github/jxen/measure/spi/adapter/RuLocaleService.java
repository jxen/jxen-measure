package com.github.jxen.measure.spi.adapter;

import com.github.jxen.measure.format.LocaleAdapter;
import com.github.jxen.measure.spi.LocaleService;
import java.util.Locale;

/**
 * {@code RuLocaleService} class is Locale SPI implementation for Russian Locale.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.2
 */
public class RuLocaleService implements LocaleService {

	@Override
	public Locale getLocale() {
		return new Locale("ru", "RU");
	}

	@Override
	public LocaleAdapter getAdapter() {
		return new RuLocaleAdapter();
	}
}
