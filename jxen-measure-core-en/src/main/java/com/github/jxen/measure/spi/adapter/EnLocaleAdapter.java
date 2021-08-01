package com.github.jxen.measure.spi.adapter;

import com.github.jxen.measure.format.LocaleAdapter;

/**
 * {@code EnLocaleAdapter} class is Locale adapter for English locale.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.5
 */
class EnLocaleAdapter implements LocaleAdapter {

  @Override
  public String name(String name, Number number) {
    if (Math.abs(number.doubleValue()) <= 1) {
      return name;
    }
    return name + ".plural";
  }
}
