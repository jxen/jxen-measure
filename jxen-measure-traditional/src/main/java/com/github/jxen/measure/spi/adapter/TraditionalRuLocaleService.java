package com.github.jxen.measure.spi.adapter;

import com.github.jxen.measure.format.LocaleAdapter;

/**
 * {@code TraditionalRuLocaleService} class is Locale SPI implementation for Russian Locale.
 *
 * @author Denis Murashev
 *
 * @since Traditional Units 0.2
 */
public class TraditionalRuLocaleService extends RuLocaleService {

	@Override
	public LocaleAdapter getAdapter() {
		return new TraditionalRuLocaleAdapter();
	}
}
