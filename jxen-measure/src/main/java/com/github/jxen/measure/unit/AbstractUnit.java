package com.github.jxen.measure.unit;

import static com.github.jxen.measure.converter.Converters.IDENTITY;
import static com.github.jxen.measure.converter.Converters.fromFactor;
import static com.github.jxen.measure.converter.Converters.fromOffset;

import com.github.jxen.math.common.Adapters;
import com.github.jxen.measure.format.DefaultUnitFormat;
import com.github.jxen.measure.format.UnitNameHelper;
import javax.measure.IncommensurableException;
import javax.measure.Prefix;
import javax.measure.Quantity;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.UnitConverter;

/**
 * {@code AbstractUnit} class represents base general {@link Unit} implementation.
 *
 * @author Denis Murashev
 *
 * @param <Q> Quantity type
 *
 * @since Measure 0.1
 */
public abstract class AbstractUnit<Q extends Quantity<Q>> implements Unit<Q> {

	private static final String ERROR_NOT_IMPLEMENTED = "Not implemented yet";
	private static final String ERROR_NOT_COMPATIBLE = "Units are not compatible";

	private final String name;

	/**
	 * @param name unit's name code
	 */
	protected AbstractUnit(String name) {
		this.name = name;
	}

	@Override
	public String getSymbol() {
		return new DefaultUnitFormat().format(this);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public final AbstractUnit<Q> getSystemUnit() {
		return toSystemUnit();
	}

	@Override
	public boolean isCompatible(Unit<?> that) {
		if (equals(that)) {
			return true;
		}
		if (that instanceof AbstractUnit) {
			if (getDimension().equals(that.getDimension())) {
				return true;
			}
			return getDimension().getBaseDimensions().equals(that.getDimension().getBaseDimensions());
		}
		return false;
	}

	@Override
	public <T extends Quantity<T>> Unit<T> asType(Class<T> type) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(ERROR_NOT_IMPLEMENTED);
	}

	@Override
	public UnitConverter getConverterTo(Unit<Q> that) {
		if (equals(that)) {
			return IDENTITY;
		}
		if (getSystemUnit().equals(that.getSystemUnit())) {
			UnitConverter thisToSystem = getSystemConverter();
			UnitConverter thatToSystem = that.getConverterTo(that.getSystemUnit());
			return thatToSystem.inverse().concatenate(thisToSystem);
		}
		try {
			return getConverterToAny(that);
		} catch (IncommensurableException e) {
			throw new UnconvertibleException(e);
		}
	}

	@Override
	public UnitConverter getConverterToAny(Unit<?> that) throws IncommensurableException {
		if (!isCompatible(that)) {
			throw new IncommensurableException(this + " is not compatible with " + that);
		}
		UnitConverter thisConverter = getConverter(this);
		UnitConverter thatConverter = getConverter((AbstractUnit<?>) that);
		return thatConverter.inverse().concatenate(thisConverter);
	}

	private static UnitConverter getConverter(AbstractUnit<?> unit) {
		return IDENTITY.concatenate(unit.getSystemConverter());
	}

	@Override
	public AbstractUnit<Q> alternate(String symbol) {
		return new AlternateUnit<>(symbol, this);
	}

	@Override
	public AbstractUnit<Q> shift(Number offset) {
		return transform(fromOffset(offset));
	}

	@Override
	public AbstractUnit<Q> shift(double offset) {
		return transform(fromOffset(offset));
	}

	@Override
	public AbstractUnit<Q> multiply(Number multiplier) {
		return transform(fromFactor(multiplier));
	}

	@Override
	public AbstractUnit<Q> multiply(double multiplier) {
		return transform(fromFactor(multiplier));
	}

	@Override
	public AbstractUnit<?> multiply(Unit<?> multiplier) {
		if (multiplier instanceof AbstractUnit) {
			String unitName = UnitNameHelper.multiply(this, multiplier);
			return ProductUnit.getProductInstance(this, (AbstractUnit<?>) multiplier).alternate(unitName);
		}
		throw new UnsupportedOperationException(ERROR_NOT_COMPATIBLE);
	}

	@Override
	public AbstractUnit<?> inverse() {
		return ProductUnit.getQuotientInstance(new ProductUnit<>(), this);
	}

	@Override
	public AbstractUnit<Q> divide(Number divisor) {
		return transform(fromFactor(Adapters.lookup(divisor).reciprocal()));
	}

	@Override
	public AbstractUnit<Q> divide(double divisor) {
		return transform(fromFactor(1.0 / divisor));
	}

	@Override
	public AbstractUnit<?> divide(Unit<?> divisor) {
		if (divisor instanceof AbstractUnit) {
			String unitName = UnitNameHelper.divide(this, divisor);
			return ProductUnit.getQuotientInstance(this, (AbstractUnit<?>) divisor).alternate(unitName);
		}
		throw new UnsupportedOperationException(ERROR_NOT_COMPATIBLE);
	}

	@Override
	public AbstractUnit<?> root(int n) {
		if (n > 0) {
			return ProductUnit.getRootInstance(this, n);
		}
		if (n == 0) {
			throw new ArithmeticException("Root's order of zero");
		}
		return new ProductUnit<>().divide(root(-n));
	}

	@Override
	public AbstractUnit<?> pow(int n) {
		if (n > 0) {
			return ProductUnit.getPowInstance(this, n).alternate(UnitNameHelper.pow(this, n));
		}
		if (n == 0) {
			return new ProductUnit<>();
		}
		return new ProductUnit<>().divide(pow(-n));
	}

	@Override
	public AbstractUnit<Q> transform(UnitConverter operation) {
		AbstractUnit<Q> systemUnit = getSystemUnit();
		UnitConverter converter = isSystemUnit() ? getSystemConverter().concatenate(operation) : operation;
		if (converter.equals(IDENTITY)) {
			return systemUnit;
		}
		return new TransformedUnit<>(this, converter);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public AbstractUnit<Q> prefix(Prefix prefix) {
		return transform(fromFactor(prefix.getValue())).alternate(UnitNameHelper.prefix(prefix, this));
	}

	/**
	 * @return converter to system unit
	 */
	public abstract UnitConverter getSystemConverter();

	/**
	 * @return checks if unit is system
	 */
	public boolean isSystemUnit() {
		return equals(toSystemUnit());
	}

	/**
	 * @return system unit
	 */
	protected abstract AbstractUnit<Q> toSystemUnit();
}
