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

	private static final LocaleAdapter DEFAULT_ADAPTER = new LocaleAdapter() {
	};

	@Override
	protected UnitNameHelper.Formatter getFormatter(List<ResourceBundle> bundles) {
		return new DefaultFormatter(DEFAULT_ADAPTER, bundles);
	}
}
