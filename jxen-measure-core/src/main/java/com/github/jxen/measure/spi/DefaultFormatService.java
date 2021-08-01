package com.github.jxen.measure.spi;

import com.github.jxen.measure.format.FullUnitFormat;
import com.github.jxen.measure.format.MeasureQuantityFormat;
import com.github.jxen.measure.format.MeasureUnitFormat;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.measure.spi.FormatService;

class DefaultFormatService implements FormatService {

  private static final String DEFAULT = "default";
  private static final String FULL = "full";
  private static final Set<String> NAMES = new HashSet<>(Arrays.asList(DEFAULT, FULL));

  @Override
  public MeasureQuantityFormat getQuantityFormat() {
    return new MeasureQuantityFormat(DecimalFormat.getInstance(), getUnitFormat());
  }

  @Override
  public MeasureQuantityFormat getQuantityFormat(String name) {
    return new MeasureQuantityFormat(DecimalFormat.getInstance(), getUnitFormat(name));
  }

  @Override
  public MeasureUnitFormat getUnitFormat() {
    return new MeasureUnitFormat();
  }

  @Override
  public MeasureUnitFormat getUnitFormat(String name) {
    if (FULL.equalsIgnoreCase(name)) {
      return new FullUnitFormat();
    }
    return new MeasureUnitFormat();
  }

  @Override
  public MeasureUnitFormat getUnitFormat(String name, String variant) {
    return variant == null || variant.isEmpty() ? getUnitFormat(name) : getUnitFormat(name + "_" + variant);
  }

  @Override
  public Set<String> getAvailableFormatNames(FormatType type) {
    return NAMES;
  }
}
