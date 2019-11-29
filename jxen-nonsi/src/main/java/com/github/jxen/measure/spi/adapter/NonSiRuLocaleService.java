package com.github.jxen.measure.spi.adapter;

import com.github.jxen.measure.format.LocaleAdapter;

/**
 * {@code NonSiRuLocaleService} class is Locale SPI implementation for Russian Locale.
 *
 * @author Denis Murashev
 *
 * @since Non-SI Units 0.2
 */
public class NonSiRuLocaleService extends RuLocaleService {

	@Override
	public LocaleAdapter getAdapter() {
		return new NonSiRuLocaleAdapter();
	}
}
