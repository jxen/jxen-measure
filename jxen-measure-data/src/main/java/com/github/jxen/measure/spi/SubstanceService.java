package com.github.jxen.measure.spi;

import com.github.jxen.measure.data.Substance;

/**
 * {@code LocaleService} interface is SPI for Locale support service for Measure project.
 *
 * @author Denis Murashev
 *
 * @param <T> substance enum class
 *
 * @since Measure 0.6
 */
public interface SubstanceService<T extends Enum<T> & Substance<T>> {

  /**
   * Provides enum class.
   *
   * @return supported substance enum class
   */
  Class<T> getEnumClass();
}
