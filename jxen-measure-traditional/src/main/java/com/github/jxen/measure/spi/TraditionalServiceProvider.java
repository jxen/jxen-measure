package com.github.jxen.measure.spi;

import javax.measure.spi.FormatService;
import javax.measure.spi.SystemOfUnitsService;

/**
 * {@code TraditionalServiceProvider} class is default service provider for Measure project.
 *
 * @author Denis Murashev
 *
 * @since Traditional Units 0.1
 */
public class TraditionalServiceProvider extends MeasureServiceProvider {

	private static final SystemOfUnitsService SYSTEM_OF_UNIT_SERVICE = new TraditionalSystemOfUnitsService();

	private static final FormatService FORMAT_SERVICE = new TraditionalFormatService();

	@Override
	public SystemOfUnitsService getSystemOfUnitsService() {
		return SYSTEM_OF_UNIT_SERVICE;
	}

	@Override
	public FormatService getFormatService() {
		return FORMAT_SERVICE;
	}
}
