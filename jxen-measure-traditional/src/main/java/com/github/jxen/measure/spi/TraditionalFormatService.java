package com.github.jxen.measure.spi;

import com.github.jxen.measure.format.MeasureUnitFormat;
import com.github.jxen.measure.format.TraditionalAlternativeUnitFormat;
import com.github.jxen.measure.format.TraditionalDefaultUnitFormat;
import com.github.jxen.measure.format.TraditionalFullUnitFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class TraditionalFormatService extends DefaultFormatService {

	private static final String DEFAULT = "default";
	private static final String ALT = "alt";
	private static final String FULL = "full";
	private static final Set<String> NAMES = new HashSet<>(Arrays.asList(DEFAULT, ALT, FULL));

	@Override
	public MeasureUnitFormat getUnitFormat(String name) {
		if (FULL.equalsIgnoreCase(name)) {
			return new TraditionalFullUnitFormat();
		}
		if (ALT.equalsIgnoreCase(name)) {
			return new TraditionalAlternativeUnitFormat();
		}
		return new TraditionalDefaultUnitFormat();
	}

	@Override
	public Set<String> getAvailableFormatNames(FormatType type) {
		return NAMES;
	}
}
