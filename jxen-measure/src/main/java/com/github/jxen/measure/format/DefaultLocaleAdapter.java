package com.github.jxen.measure.format;

class DefaultLocaleAdapter implements LocaleAdapter {

	@Override
	public String name(String name, Number number) {
		if (Math.abs(number.doubleValue()) <= 1) {
			return name;
		}
		return name + ".plural";
	}
}
