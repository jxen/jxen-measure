package com.github.jxen.measure.format;

/**
 * {@code LocaleAdapter} interface is Locale adapter contract.
 *
 * @author Denis Murashev
 * @since Measure 0.1
 */
public interface LocaleAdapter {

	/**
	 * @param number number
	 * @return suffix
	 */
	String getSuffix(Number number);
}
