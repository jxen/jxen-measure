package com.github.jxen.measure.spi;

import com.github.jxen.measure.format.LocaleAdapter;
import java.util.Locale;

/**
 * {@code LocaleService} interface is SPI for Locale support service for Measure project.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.2
 */
public interface LocaleService {

  /**
   * Provides locale.
   *
   * @return the locale
   */
  Locale getLocale();

  /**
   * Provides adapter for locale.
   *
   * @return the adapter
   */
  LocaleAdapter getAdapter();
}
