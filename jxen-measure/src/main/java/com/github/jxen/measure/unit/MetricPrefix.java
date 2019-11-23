package com.github.jxen.measure.unit;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TEN;

import com.github.jxen.math.rational.BigRational;
import javax.measure.Prefix;
import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * {@code MetricPrefix} enumeration contains metric prefixes.
 *
 * @author Denis Murashev
 * @since Measure 0.1
 */
public enum MetricPrefix implements Prefix {

	/**
	 * Yotta.
	 */
	YOTTA("Y", 24),

	/**
	 * Zetta.
	 */
	ZETTA("Z", 21),

	/**
	 * Exa.
	 */
	EXA("E", 18),

	/**
	 * Peta.
	 */
	PETA("P", 15),

	/**
	 * Tera.
	 */
	TERA("T", 12),

	/**
	 * Giga.
	 */
	GIGA("G", 9),

	/**
	 * Mega.
	 */
	MEGA("M", 6),

	/**
	 * Kilo.
	 */
	KILO("kilo", 3),

	/**
	 * Hecto.
	 */
	HECTO("hecto", 2),

	/**
	 * Deka.
	 */
	DEKA("da", 1),

	/**
	 * Deci.
	 */
	DECI("deci", -1),

	/**
	 * Centi.
	 */
	CENTI("centi", -2),

	/**
	 * Milli.
	 */
	MILLI("milli", -3),

	/**
	 * Micro.
	 */
	MICRO("micro", -6),

	/**
	 * Nano.
	 */
	NANO("n", -9),

	/**
	 * Pico.
	 */
	PICO("p", -12),

	/**
	 * Femto.
	 */
	FEMTO("f", -15),

	/**
	 * Atto.
	 */
	ATTO("a", -18),

	/**
	 * Zepto.
	 */
	ZEPTO("z", -21),

	/**
	 * Yocto.
	 */
	YOCTO("y", -24);

	private final String prefix;
	private final int exponent;
	private final BigRational value;

	MetricPrefix(String prefix, int exponent) {
		this.prefix = prefix;
		this.exponent = exponent;
		value = exponent > 0 ? new BigRational(TEN.pow(exponent)) : new BigRational(ONE, TEN.pow(-exponent));
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>24</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e24)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> yotta(Unit<Q> unit) {
		return unit.prefix(YOTTA);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>21</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e21)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> zetta(Unit<Q> unit) {
		return unit.prefix(ZETTA);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>18</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e18)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> exa(Unit<Q> unit) {
		return unit.prefix(EXA);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>15</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e15)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> peta(Unit<Q> unit) {
		return unit.prefix(PETA);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>12</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e12)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> tera(Unit<Q> unit) {
		return unit.prefix(TERA);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>9</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e9)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> giga(Unit<Q> unit) {
		return unit.prefix(GIGA);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>6</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e6)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> mega(Unit<Q> unit) {
		return unit.prefix(MEGA);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>3</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e3)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> kilo(Unit<Q> unit) {
		return unit.prefix(KILO);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>2</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e2)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> hecto(Unit<Q> unit) {
		return unit.prefix(HECTO);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>1</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e1)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> deka(Unit<Q> unit) {
		return unit.prefix(DEKA);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>-1</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e-1)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> deci(Unit<Q> unit) {
		return unit.prefix(DECI);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>-2</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e-2)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> centi(Unit<Q> unit) {
		return unit.prefix(CENTI);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>-3</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e-3)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> milli(Unit<Q> unit) {
		return unit.prefix(MILLI);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>-6</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e-6)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> micro(Unit<Q> unit) {
		return unit.prefix(MICRO);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>-9</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e-9)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> nano(Unit<Q> unit) {
		return unit.prefix(NANO);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>-12</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e-12)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> pico(Unit<Q> unit) {
		return unit.prefix(PICO);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>-15</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e-15)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> femto(Unit<Q> unit) {
		return unit.prefix(FEMTO);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>-18</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e-18)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> atto(Unit<Q> unit) {
		return unit.prefix(ATTO);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>-21</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e-21)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> zepto(Unit<Q> unit) {
		return unit.prefix(ZEPTO);
	}

	/**
	 * Returns the specified unit multiplied by the factor <code>10<sup>-24</sup></code>
	 *
	 * @param <Q>  The type of the quantity measured by the unit.
	 * @param unit any unit.
	 * @return {@code unit.times(1e-24)}
	 */
	public static <Q extends Quantity<Q>> Unit<Q> yocto(Unit<Q> unit) {
		return unit.prefix(YOCTO);
	}

	@Override
	public String getName() {
		return prefix;
	}

	@Override
	public String getSymbol() {
		throw new UnsupportedOperationException("Is not implemented yet");
	}

	@Override
	public Number getValue() {
		return value;
	}

	@Override
	public int getExponent() {
		return exponent;
	}
}
