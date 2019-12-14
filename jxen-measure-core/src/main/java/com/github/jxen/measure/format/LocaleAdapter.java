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
	String name(String name, Number number);

	/**
	 * @param suffix unit name suffix
	 * @param name   unit name
	 * @param number numeric value
	 * @return updated suffix
	 */
	default String suffix(String suffix, String name, Number number) {
		return suffix;
	}

	/**
	 * @param name unit name
	 * @return {@code true} if given name is feminine name
	 * @since Measure 0.2
	 */
	default boolean isFeminine(String name) {
		return false;
	}

	/**
	 * @param name unit name
	 * @return {@code true} if given name is neuter name
	 * @since Measure 0.2
	 */
	default boolean isNeuter(String name) {
		return false;
	}
}