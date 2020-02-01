package com.github.jxen.measure.spi;

/**
 * {@code LocaleService} interface is SPI for Locale support service for Measure project.
 *
 * @author Denis Murashev
 *
 * @param <T> substance enum class
 *
 * @since Measure 0.6
 */
public interface SubstanceService<T extends Enum<T>> {

	/**
	 * @return supported substance enum class
	 */
	Class<T> getEnumClass();
}
