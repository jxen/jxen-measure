package com.github.jxen.measure.data;

/**
 * {@code Substance} enum represents physical substances.
 *
 * @author Denis Murashev
 *
 * @param <T> substance class
 *
 * @since Measure 0.5
 */
public interface Substance<T extends Enum<T>> {

  /**
   * Provides substance code. Usually it's chemical formula.
   *
   * @return the substance code
   */
  String getCode();

  /**
   * Provides substance name.
   *
   * @return the substance name
   */
  String getName();
}
