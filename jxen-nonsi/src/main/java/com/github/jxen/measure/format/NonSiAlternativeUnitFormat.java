package com.github.jxen.measure.format;

/**
 * {@code NonSiAlternativeUnitFormat} class is extension of {@link MeasureUnitFormat} for Non-SI units.
 *
 * @author Denis Murashev
 *
 * @since Non-SI Units 0.1
 */
public class NonSiAlternativeUnitFormat extends DefaultUnitFormat {

	/**
	 * Initializes Non-SI units format.
	 */
	public NonSiAlternativeUnitFormat() {
		super("nonsi", "nonsi-alt");
	}
}
