package com.github.jxen.measure.converter;

import com.github.jxen.math.common.Adapters;
import com.github.jxen.math.common.ArithmeticAware;
import java.util.Objects;
import javax.measure.UnitConverter;

final class MultiplyConverter extends AbstractConverter {

	private final Number factor;
	private final ArithmeticAware<?> adapter;

	MultiplyConverter(Number factor) {
		this.factor = factor;
		adapter = Adapters.lookup(factor);
	}

	@Override
	public boolean isLinear() {
		return true;
	}

	@Override
	public UnitConverter inverse() {
		return new MultiplyConverter(adapter.reciprocal());
	}

	@Override
	public Number convert(Number value) {
		return Adapters.lookup(value).multiply(factor);
	}

	@Override
	public double convert(double value) {
		return value * factor.doubleValue();
	}

	@Override
	public UnitConverter concatenate(UnitConverter converter) {
		if (converter instanceof MultiplyConverter) {
			MultiplyConverter c = (MultiplyConverter) converter;
			Number f = adapter.multiply(c.factor);
			return f.doubleValue() == 1 ? Converters.IDENTITY : new MultiplyConverter(f);
		}
		return super.concatenate(converter);
	}

	@Override
	public String toString() {
		return "MultiplyConverter(" + factor + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}
		MultiplyConverter that = (MultiplyConverter) o;
		return factor.equals(that.factor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(factor);
	}
}
