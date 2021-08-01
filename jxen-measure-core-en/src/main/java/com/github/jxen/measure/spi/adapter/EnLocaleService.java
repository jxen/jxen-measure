package com.github.jxen.measure.spi.adapter;

import com.github.jxen.measure.format.LocaleAdapter;
import com.github.jxen.measure.spi.LocaleService;
import java.util.Locale;

/**
 * {@code EnLocaleService} class is Locale SPI implementation for Russian Locale.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.2
 */
public class EnLocaleService implements LocaleService {

  @Override
  public Locale getLocale() {
    return Locale.ENGLISH;
  }

  @Override
  public LocaleAdapter getAdapter() {
    return new EnLocaleAdapter();
  }
}
