package com.github.jxen.measure.spi;

import com.github.jxen.measure.data.Metal;

/**
 * {@code MetalService} class is service provider for .
 *
 * @author Denis Murashev
 *
 * @since Measure 0.6
 */
public class MetalService implements SubstanceService<Metal> {

  @Override
  public Class<Metal> getEnumClass() {
    return Metal.class;
  }
}
