package com.github.jxen.measure.dimension;

import java.util.HashMap;
import java.util.Map;
import javax.measure.Dimension;

enum BaseDimension implements Dimension {

	/**
	 * Length.
	 */
	LENGTH,

	/**
	 * Mass.
	 */
	MASS,

	/**
	 * Time.
	 */
	TIME,

	/**
	 * Currency.
	 */
	CURRENCY;

	private final Map<Dimension, Integer> base = new HashMap<>();

	BaseDimension() {
		base.put(this, 1);
	}

	@Override
	public Map<? extends Dimension, Integer> getBaseDimensions() {
		return base;
	}

	@Override
	public Dimension multiply(Dimension dimension) {
		return new ProductDimension().multiply(this).multiply(dimension);
	}

	@Override
	public Dimension divide(Dimension dimension) {
		return new ProductDimension().multiply(this).divide(dimension);
	}

	@Override
	public Dimension pow(int n) {
		return new ProductDimension().multiply(this).pow(n);
	}

	@Override
	public Dimension root(int n) {
		throw new ArithmeticException("Unsupported operation");
	}
}
