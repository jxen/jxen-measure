package com.github.jxen.measure.dimension;

import javax.measure.Dimension;

/**
 * {@code Dimensions} class collects dimensions.
 *
 * @author Denis Murashev
 * @since Measure 0.1
 */
public final class Dimensions {

	/**
	 * Dimensionless.
	 */
	public static final Dimension DIMENSIONLESS = new ProductDimension();

	/**
	 * Length.
	 */
	public static final Dimension LENGTH = BaseDimension.LENGTH;

	/**
	 * Area.
	 */
	public static final Dimension AREA = LENGTH.pow(2);

	/**
	 * Volume.
	 */
	public static final Dimension VOLUME = LENGTH.pow(3);

	/**
	 * Mass.
	 */
	public static final Dimension MASS = BaseDimension.MASS;

	/**
	 * Time.
	 */
	public static final Dimension TIME = BaseDimension.TIME;

	/**
	 * Speed.
	 */
	public static final Dimension SPEED = LENGTH.divide(TIME);

	/**
	 * Density.
	 */
	public static final Dimension DENSITY = MASS.divide(VOLUME);

	private Dimensions() {
	}
}
