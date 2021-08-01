package com.github.jxen.measure.format;

import com.github.jxen.measure.data.Substance;
import java.util.ResourceBundle;

/**
 * {@code SubstanceFormat} class is used to display substance names.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.6
 */
public class SubstanceFormat {

  /**
   * Formats given substance.
   *
   * @param substance substance
   * @return localized name
   */
  public final String format(Substance<?> substance) {
    String key = "substance." + substance.getName();
    return getBundle(substance).getString(key);
  }

  private ResourceBundle getBundle(Substance<?> substance) {
    return ResourceBundle.getBundle(substance.getClass().getName());
  }
}
