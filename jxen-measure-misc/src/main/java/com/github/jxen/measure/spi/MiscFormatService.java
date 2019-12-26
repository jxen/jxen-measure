package com.github.jxen.measure.spi;

import com.github.jxen.measure.format.MeasureUnitFormat;
import com.github.jxen.measure.format.MiscAlternativeUnitFormat;
import com.github.jxen.measure.format.MiscDefaultUnitFormat;
import com.github.jxen.measure.format.MiscFullUnitFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MiscFormatService extends DefaultFormatService {

	private static final String DEFAULT = "default";
	private static final String ALT = "alt";
	private static final String FULL = "full";
	private static final Set<String> NAMES = new HashSet<>(Arrays.asList(DEFAULT, ALT, FULL));

	@Override
	public MeasureUnitFormat getUnitFormat(String name) {
		if (FULL.equalsIgnoreCase(name)) {
			return new MiscFullUnitFormat();
		}
		if (ALT.equalsIgnoreCase(name)) {
			return new MiscAlternativeUnitFormat();
		}
		return new MiscDefaultUnitFormat();
	}

	@Override
	public Set<String> getAvailableFormatNames(FormatType type) {
		return NAMES;
	}
}
