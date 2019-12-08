package com.github.jxen.measure.unit;

import static com.github.jxen.measure.dimension.Dimensions.AMOUNT_OF_SUBSTANCE;
import static com.github.jxen.measure.dimension.Dimensions.ELECTRIC_CURRENT;
import static com.github.jxen.measure.dimension.Dimensions.LENGTH;
import static com.github.jxen.measure.dimension.Dimensions.LUMINOUS_INTENSITY;
import static com.github.jxen.measure.dimension.Dimensions.MASS;
import static com.github.jxen.measure.dimension.Dimensions.TEMPERATURE;
import static com.github.jxen.measure.dimension.Dimensions.TIME;
import static com.github.jxen.measure.unit.SystemOfUnitsImpl.unit;

import com.github.jxen.measure.annotation.AddUnit;
import javax.measure.quantity.AmountOfSubstance;
import javax.measure.quantity.ElectricCurrent;
import javax.measure.quantity.Length;
import javax.measure.quantity.LuminousIntensity;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Time;

/**
 * {@code MetricUnits} class contains SI units.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public final class MetricUnits {

	/**
	 * <p>The ampere (symbol: {@code A}) is the base unit of electric current in the International System of Units (SI).
	 *
	 * <p>It is named after Andr&eacute;-Marie Amp&egrave;re (1775-1836).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Ampere">Wikipedia: Ampere</a>
	 */
	@AddUnit
	public static final AbstractUnit<ElectricCurrent> AMPERE = unit("ampere", ELECTRIC_CURRENT, ElectricCurrent.class);

	/**
	 * <p>The candela (symbol: {@code cd}) is the base unit of luminous intensity in the International System of Units
	 * (SI)
	 *
	 * <p>That is, luminous power per unit solid angle emitted by a point light source in a particular direction.
	 *
	 * @see <a href="http://en.wikipedia.org/wiki/Candela">Wikipedia: Candela</a>
	 */
	@AddUnit
	public static final AbstractUnit<LuminousIntensity> CANDELA = unit("candela", LUMINOUS_INTENSITY,
			LuminousIntensity.class);

	/**
	 * <p>The kelvin is the base unit of temperature in the International System of Units (SI),
	 * having the unit symbol {@code K}.
	 *
	 * <p>It is named after the Belfast-born, Glasgow University engineer and physicist William Thomson,
	 * 1st Baron Kelvin (1824-1907).
	 *
	 * @see <a href="http://en.wikipedia.org/wiki/Kelvin">Wikipedia: Kelvin</a>
	 */
	@AddUnit
	public static final AbstractUnit<Temperature> KELVIN = unit("kelvin", TEMPERATURE, Temperature.class);

	/**
	 * <p>The kilogram (also kilogramme) is the base unit of mass in the metric system,
	 * formally the International System of Units (SI), having the unit symbol {@code kg}.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Kilogram">Wikipedia: Kilogram</a>
	 */
	@AddUnit
	public static final AbstractUnit<Mass> KILOGRAM = unit("kilogram", MASS, Mass.class);

	/**
	 * The meter (or metre) is the base unit of length in the International System of Units (SI).
	 * The SI unit symbol is {@code m}.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Metre">Wikipedia: Metre</a>
	 */
	@AddUnit
	public static final AbstractUnit<Length> METER = unit("meter", LENGTH, Length.class);

	/**
	 * The mole (symbol: {@code mol}) is the base unit of amount of substance ("number of substance")
	 * in the International System of Units or System International (SI).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Mole_(unit)">Wikipedia: Mole (unit)</a>
	 */
	@AddUnit
	public static final AbstractUnit<AmountOfSubstance> MOLE = unit("mole", AMOUNT_OF_SUBSTANCE,
			AmountOfSubstance.class);

	/**
	 * The second (symbol: {@code s}) is the base unit of time in the International System of Units (SI).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Second">Wikipedia: Second</a>
	 */
	@AddUnit
	public static final AbstractUnit<Time> SECOND = unit("second", TIME, Time.class);

	private MetricUnits() {
	}
}
