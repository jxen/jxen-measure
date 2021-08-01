package com.github.jxen.measure.format;

import com.github.jxen.measure.format.UnitNameHelper.DefaultFormatter;
import com.github.jxen.measure.format.UnitNameHelper.Formatter;
import com.github.jxen.measure.unit.AbstractUnit;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javax.measure.MeasurementException;
import javax.measure.Unit;
import javax.measure.format.UnitFormat;

/**
 * {@code MeasureUnitFormat} class is extension of {@link UnitFormat}.
 * Each extension of the class must have corresponding resource bundle with suffix "_unit".
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public class MeasureUnitFormat implements UnitFormat {

  /**
   * Default locale adaptor.
   */
  protected static final LocaleAdapter DEFAULT_ADAPTER = new LocaleAdapter() {
  };

  private static final String ERROR_NOT_IMPLEMENTED = "Not implemented yet";
  private static final String ERROR_NO_NAME = "Unit must have name";

  private final List<ResourceBundle> bundles = new ArrayList<>();

  /**
   * Initializes resource bundles for unit names.
   */
  public MeasureUnitFormat() {
    Class<?> type = getClass();
    while (type != Object.class) {
      String name = type.getName() + "_unit";
      bundles.add(ResourceBundle.getBundle(name));
      type = type.getSuperclass();
    }
  }

  @Override
  public Appendable format(Unit<?> unit, Appendable appendable) {
    Objects.requireNonNull(unit.getName(), ERROR_NO_NAME);
    try {
      if (unit instanceof AbstractUnit) {
        return format(1, (AbstractUnit<?>) unit, appendable);
      }
      return appendable.append(unit.getSymbol());
    } catch (IOException e) {
      throw new MeasurementException(e);
    }
  }

  @Override
  public String format(Unit<?> unit) {
    return format(unit, new StringBuilder()).toString();
  }

  /**
   * Formats value and unit.
   *
   * @param value      value
   * @param unit       unit
   * @param appendable appendable
   * @return appendable
   */
  protected final Appendable format(Number value, AbstractUnit<?> unit, Appendable appendable) {
    Objects.requireNonNull(unit.getName(), ERROR_NO_NAME);
    try {
      return appendable.append(getString(value, unit));
    } catch (IOException e) {
      throw new MeasurementException(e);
    }
  }

  /**
   * Formats value and unit.
   *
   * @param value value
   * @param unit  unit
   * @return string representation
   */
  protected final String format(Number value, AbstractUnit<?> unit) {
    return format(value, unit, new StringBuilder()).toString();
  }

  @Override
  public void label(Unit<?> unit, String label) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isLocaleSensitive() {
    return true;
  }

  @Override
  public Unit<?> parse(CharSequence csq, ParsePosition pos) {
    throw new UnsupportedOperationException(ERROR_NOT_IMPLEMENTED);
  }

  @Override
  public Unit<?> parse(CharSequence csq) {
    throw new UnsupportedOperationException(ERROR_NOT_IMPLEMENTED);
  }

  /**
   * Provides formatter used for unit representation.
   * The extension implementation can take additional local adapter.
   *
   * @param bundles bundles
   * @return formatter
   */
  protected Formatter getFormatter(List<ResourceBundle> bundles) {
    return new DefaultFormatter(DEFAULT_ADAPTER, bundles);
  }

  private String getString(Number value, AbstractUnit<?> unit) {
    return getFormatter(bundles).format(value, unit.getName());
  }
}
