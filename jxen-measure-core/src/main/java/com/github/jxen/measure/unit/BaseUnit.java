package com.github.jxen.measure.unit;

import com.github.jxen.measure.converter.Converters;
import com.github.jxen.measure.dimension.Dimensions;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;

/**
 * {@code BaseUnit} class represents base unit.
 *
 * @author Denis Murashev
 *
 * @param <Q> Quantity type
 *
 * @since Measure 0.1
 */
final class BaseUnit<Q extends Quantity<Q>> extends AbstractUnit<Q> {

  private transient Dimension dimension;

  BaseUnit(String name, Dimension dimension) {
    super(name);
    this.dimension = Optional.ofNullable(dimension).orElse(Dimensions.DIMENSIONLESS);
  }

  BaseUnit(String name) {
    this(name, Dimensions.DIMENSIONLESS);
  }

  @Override
  public UnitConverter getSystemConverter() {
    return Converters.IDENTITY;
  }

  @Override
  public Dimension getDimension() {
    return dimension;
  }

  @Override
  public Map<? extends Unit<?>, Integer> getBaseUnits() {
    Map<Unit<Q>, Integer> map = new HashMap<>();
    map.put(this, 1);
    return map;
  }

  @Override
  public boolean isSystemUnit() {
    return true;
  }

  @Override
  public AbstractUnit<Q> toSystemUnit() {
    return this;
  }
}
