package com.github.jxen.measure.spi;

import javax.measure.spi.FormatService;
import javax.measure.spi.SystemOfUnitsService;

/**
 * {@code MiscServiceProvider} class is default service provider for Measure project.
 *
 * @author Denis Murashev
 *
 * @since Misc Units 0.1
 */
public class MiscServiceProvider extends MeasureServiceProvider {

  private static final SystemOfUnitsService SYSTEM_OF_UNIT_SERVICE = new MiscSystemOfUnitsService();

  private static final FormatService FORMAT_SERVICE = new MiscFormatService();

  @Override
  public SystemOfUnitsService getSystemOfUnitsService() {
    return SYSTEM_OF_UNIT_SERVICE;
  }

  @Override
  public FormatService getFormatService() {
    return FORMAT_SERVICE;
  }
}
