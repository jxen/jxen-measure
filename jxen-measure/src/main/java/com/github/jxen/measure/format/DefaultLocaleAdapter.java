package com.github.jxen.measure.format;

class DefaultLocaleAdapter implements LocaleAdapter {

	@Override
	public String getSuffix(Number number) {
		double value = Math.abs(number.doubleValue());
		if (value == 1) {
			return "";
		}
		return ".plural";
	}
}
