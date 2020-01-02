package com.github.jxen.measure.spi.adapter;

import com.github.jxen.measure.format.LocaleAdapter;

/**
 * {@code MiscEnLocaleService} class is Locale SPI implementation for English Locale.
 *
 * @author Denis Murashev
 *
 * @since Traditional Units 0.5
 */
public class MiscEnLocaleService extends EnLocaleService {

	@Override
	public LocaleAdapter getAdapter() {
		return new MiscEnLocaleAdapter();
	}
}
