package com.github.jxen.measure.quantity.impl;

import com.github.jxen.math.rational.BigRational;
import com.github.jxen.math.rational.Rational;
import com.github.jxen.measure.unit.AbstractUnit;
import javax.measure.Quantity;
import javax.measure.Quantity.Scale;
import javax.measure.Unit;
import javax.measure.spi.QuantityFactory;
import javax.measure.spi.ServiceProvider;
import javax.measure.spi.SystemOfUnits;

/**
 * {@code Quantities} class is responsible for management of {@link Quantity} entinies.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public final class Quantities {

  private Quantities() {
  }

  /**
   * Provides factory.
   *
   * @param quantity quantity
   * @param <Q> quantity type
   * @return quantity factory
   */
  public static <Q extends Quantity<Q>> QuantityFactory<Q> getFactory(Class<Q> quantity) {
    final SystemOfUnits systemOfUnits = ServiceProvider.current().getSystemOfUnitsService().getSystemOfUnits();
    return new QuantityFactory<>() {
      @Override
      public Quantity<Q> create(Number value, Unit<Q> unit, Scale scale) {
        throw new UnsupportedOperationException("Not implemented yet");
      }

      @Override
      public Quantity<Q> create(Number value, Unit<Q> unit) {
        return of(value, unit);
      }

      @Override
      public Unit<Q> getSystemUnit() {
        return systemOfUnits.getUnit(quantity);
      }
    };
  }

  /**
   * Creates quantity of given value and unit.
   *
   * @param value value
   * @param unit  unit
   * @param <Q> quantity type
   * @return quantity
   */
  public static <Q extends Quantity<Q>> Quantity<Q> of(Number value, Unit<Q> unit) {
    if (unit instanceof AbstractUnit) {
      return new QuantityImpl<>(value, (AbstractUnit<Q>) unit);
    }
    throw new UnsupportedOperationException("Unit class is not supported: " + unit.getClass());
  }

  /**
   * Checks if quantity is zero.
   *
   * @param quantity quantity
   * @return {@code true} if quantity is zero
   */
  public static boolean isZero(Quantity<?> quantity) {
    return quantity.getValue().doubleValue() == 0.0;
  }

  /**
   * Checks if quantity is positive.
   *
   * @param quantity quantity
   * @return {@code true} if quantity is positive
   */
  public static boolean isPositive(Quantity<?> quantity) {
    return quantity.getValue().doubleValue() > 0.0;
  }

  /**
   * Checks if quantity is negative.
   *
   * @param quantity quantity
   * @return {@code true} if quantity is negative
   */
  public static boolean isNegative(Quantity<?> quantity) {
    return quantity.getValue().doubleValue() < 0.0;
  }

  /**
   * Converts to {@code double}.
   *
   * @param quantity quantity
   * @param unit     unit
   * @param <Q> quantity type
   * @return double value
   */
  public static <Q extends Quantity<Q>> double toDouble(Quantity<Q> quantity, Unit<Q> unit) {
    return toDouble(quantity.to(unit));
  }

  /**
   * Converts to {@code double}.
   *
   * @param quantity quantity
   * @param <Q> quantity type
   * @return double value
   */
  public static <Q extends Quantity<Q>> double toDouble(Quantity<Q> quantity) {
    return quantity.getValue().doubleValue();
  }

  /**
   * Converts to {@code float}.
   *
   * @param quantity quantity
   * @param unit     unit
   * @param <Q> quantity type
   * @return float value
   */
  public static <Q extends Quantity<Q>> float toFloat(Quantity<Q> quantity, Unit<Q> unit) {
    return toFloat(quantity.to(unit));
  }

  /**
   * Converts to {@code float}.
   *
   * @param quantity quantity
   * @param <Q> quantity type
   * @return float value
   */
  public static <Q extends Quantity<Q>> float toFloat(Quantity<Q> quantity) {
    return quantity.getValue().floatValue();
  }

  /**
   * Converts to {@code long}.
   *
   * @param quantity quantity
   * @param unit     unit
   * @param <Q> quantity type
   * @return long value
   */
  public static <Q extends Quantity<Q>> long toLong(Quantity<Q> quantity, Unit<Q> unit) {
    return toLong(quantity.to(unit));
  }

  /**
   * Converts to {@code long}.
   *
   * @param quantity quantity
   * @param <Q> quantity type
   * @return long value
   */
  public static <Q extends Quantity<Q>> long toLong(Quantity<Q> quantity) {
    return quantity.getValue().longValue();
  }

  /**
   * Converts to {@code int}.
   *
   * @param quantity quantity
   * @param unit     unit
   * @param <Q> quantity type
   * @return int value
   */
  public static <Q extends Quantity<Q>> long toInt(Quantity<Q> quantity, Unit<Q> unit) {
    return toInt(quantity.to(unit));
  }

  /**
   * Converts to {@code int}.
   *
   * @param quantity quantity
   * @param <Q> quantity type
   * @return int value
   */
  public static <Q extends Quantity<Q>> long toInt(Quantity<Q> quantity) {
    return quantity.getValue().intValue();
  }

  /**
   * Converts to {@link Rational}.
   *
   * @param quantity quantity
   * @param unit     unit
   * @param <Q> quantity type
   * @return Rational value
   */
  public static <Q extends Quantity<Q>> Rational toRational(Quantity<Q> quantity, Unit<Q> unit) {
    return toRational(quantity.to(unit));
  }

  /**
   * Converts to {@link Rational}.
   *
   * @param quantity quantity
   * @param <Q> quantity type
   * @return Rational value
   */
  public static <Q extends Quantity<Q>> Rational toRational(Quantity<Q> quantity) {
    return Rational.valueOf(quantity.getValue());
  }

  /**
   * Converts to {@link BigRational}.
   *
   * @param quantity quantity
   * @param unit     unit
   * @param <Q> quantity type
   * @return BigRational value
   */
  public static <Q extends Quantity<Q>> BigRational toBigRational(Quantity<Q> quantity, Unit<Q> unit) {
    return toBigRational(quantity.to(unit));
  }

  /**
   * Converts to {@link BigRational}.
   *
   * @param quantity quantity
   * @param <Q> quantity type
   * @return BigRational value
   */
  public static <Q extends Quantity<Q>> BigRational toBigRational(Quantity<Q> quantity) {
    return BigRational.valueOf(quantity.getValue());
  }
}
