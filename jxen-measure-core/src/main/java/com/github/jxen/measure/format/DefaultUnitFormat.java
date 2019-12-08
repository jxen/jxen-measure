package com.github.jxen.measure.format;

import com.github.jxen.measure.format.UnitNameHelper.DefaultFormatter;
import java.util.List;
import java.util.ResourceBundle;

/**
 * {@code DefaultUnitFormat} class is extension of {@link MeasureUnitFormat}.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public class DefaultUnitFormat extends MeasureUnitFormat {

	private static final String DEFAULT_BUNDLE_NAME = "unit";

	/**
	 * Initializes default unit format.
	 */
	public DefaultUnitFormat() {
		super(DEFAULT_BUNDLE_NAME);
	}

	/**
	 * @param names resource bundle names
	 */
	protected DefaultUnitFormat(String... names) {
		super(DEFAULT_BUNDLE_NAME, names);
	}

	@Override
	protected UnitNameHelper.Formatter getFormatter(List<ResourceBundle> bundles) {
		return new DefaultFormatter((n, v) -> n, bundles);
	}
}
