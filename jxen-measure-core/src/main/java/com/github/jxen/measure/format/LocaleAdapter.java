package com.github.jxen.measure.format;

/**
 * {@code LocaleAdapter} interface is Locale adapter contract.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public interface LocaleAdapter {

	/**
	 * @param name   unit name
	 * @param number numeric value
	 * @return updated name
	 */
	default String name(String name, Number number) {
		return name;
	}

	/**
	 * @param suffix unit name suffix
	 * @param name   unit name
	 * @param number numeric value
	 * @return updated suffix
	 */
	default String suffix(String suffix, String name, Number number) {
		return suffix;
	}
}
