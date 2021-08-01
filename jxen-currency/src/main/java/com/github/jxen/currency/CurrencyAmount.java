package com.github.jxen.currency;

import com.github.jxen.math.common.Adapters;
import com.github.jxen.measure.quantity.impl.AbstractQuantity;
import com.github.jxen.measure.unit.AbstractUnit;
import java.util.function.BiFunction;
import javax.measure.Unit;

/**
 * {@code CurrencyAmount} class represents quantity of currency.
 *
 * @author Denis Murashev
 *
 * @since Currency 0.1
 */
public final class CurrencyAmount extends AbstractQuantity<Currency> implements Currency {

  /**
   * Initializes currency amount.
   *
   * @param number number
   * @param unit   unit
   */
  public CurrencyAmount(Number number, CurrencyUnit unit) {
    super(round(number, unit), unit);
  }

  /**
   * Initializes currency amount.
   *
   * @param number number
   * @param unit   unit
   */
  public CurrencyAmount(Number number, AbstractUnit<Currency> unit) {
    super(round(number, unit), unit);
  }

  private static Number round(Number value, Unit<Currency> unit) {
    if (value.doubleValue() == 0.0) {
      return value;
    }
    if (unit instanceof CurrencyUnit) {
      Number one = Adapters.lookup(value).div(value);
      Number min = ((CurrencyUnit) unit).getMinimal();
      long n = Math.round(value.doubleValue() / min.doubleValue());
      return Adapters.lookup(one).multiply(Adapters.lookup(min).multiply(n));
    }
    return value;
  }

  @Override
  protected BiFunction<Number, AbstractUnit<Currency>, Currency> factory() {
    return CurrencyAmount::new;
  }
}
