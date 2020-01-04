package com.github.jxen.measure.system;

import static com.github.jxen.measure.system.MeterUnits.SQUARE_METER;
import static com.github.jxen.measure.system.MetricUnits.CANDELA;
import static com.github.jxen.measure.system.MetricUnits.KELVIN;
import static com.github.jxen.measure.system.MetricUnits.KILOGRAM;
import static com.github.jxen.measure.system.MetricUnits.METER;
import static com.github.jxen.measure.system.MetricUnits.MOLE;
import static com.github.jxen.measure.system.MetricUnits.SECOND;
import static com.github.jxen.measure.system.NamedUnits.JOULE;
import static com.github.jxen.measure.system.RadianUnits.STERADIAN;
import static com.github.jxen.measure.unit.UnitUtil.unit;

import com.github.jxen.measure.annotation.AddUnit;
import com.github.jxen.measure.unit.AbstractUnit;
import java.math.BigDecimal;
import javax.measure.quantity.CatalyticActivity;
import javax.measure.quantity.Illuminance;
import javax.measure.quantity.LuminousFlux;
import javax.measure.quantity.RadiationDoseAbsorbed;
import javax.measure.quantity.RadiationDoseEffective;
import javax.measure.quantity.Radioactivity;
import javax.measure.quantity.Temperature;
import si.uom.quantity.Luminance;

/**
 * {@code AmpereUnits} class contains named units derived from SI base units.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.2
 */
public final class MiscUnits {

	/**
	 * <p>The degree Celsius (symbol: &deg;{@code C}) can refer to a specific temperature on the Celsius scale
	 * or a unit to indicate a difference between two temperatures or an uncertainty.
	 *
	 * <p>It is named after the Swedish astronomer Anders Celsius (1701-1744),
	 * who developed a similar temperature scale.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Celsius">Wikipedia: Celsius</a>
	 */
	@AddUnit
	public static final AbstractUnit<Temperature> CELSIUS = unit(KELVIN.shift(new BigDecimal("273.15"))
			.alternate("celsius"), Temperature.class);

	/**
	 * <p>The lumen (symbol: {@code lm}) is the SI derived unit of luminous flux,
	 * a measure of the total quantity of visible light emitted by a source per unit of time.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Lumen_(unit)">Wikipedia: Lumen (unit)</a>
	 */
	@AddUnit
	public static final AbstractUnit<LuminousFlux> LUMEN = unit(CANDELA.multiply(STERADIAN).alternate("lumen"),
			LuminousFlux.class);

	/**
	 * <p>The lux (symbol: {@code lx}) is the SI derived unit of illuminance and luminous emittance,
	 * measuring luminous flux per unit area.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Lux">Wikipedia: Lux</a>
	 */
	@AddUnit
	public static final AbstractUnit<Illuminance> LUX = unit(LUMEN.divide(METER.pow(2)).alternate("lux"),
			Illuminance.class);

	/**
	 * <p>The becquerel (symbol: {@code Bq}) is the SI derived unit of radioactivity.
	 * One becquerel is defined as the activity of a quantity of radioactive material
	 * in which one nucleus decays per second.
	 *
	 * <p>The becquerel is named after Henri Becquerel, who shared a Nobel Prize in Physics
	 * with Pierre and Marie Curie in 1903 for their work in discovering radioactivity.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Becquerel">Wikipedia: Becquerel</a>
	 */
	@AddUnit
	public static final AbstractUnit<Radioactivity> BECQUEREL = unit(SECOND.inverse().alternate("becquerel"),
			Radioactivity.class);

	/**
	 * <p>The gray (symbol: {@code Gy}) is a derived unit of ionizing radiation dose
	 * in the International System of Units (SI).
	 * It is defined as the absorption of one joule of radiation energy per kilogram of matter.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Gray_(unit)">Wikipedia: Gray_(unit)</a>
	 */
	@AddUnit
	public static final AbstractUnit<RadiationDoseAbsorbed> GRAY = unit(JOULE.divide(KILOGRAM).alternate("gray"),
			RadiationDoseAbsorbed.class);

	/**
	 * <p>The sievert (symbol: {@code Sv}) is a derived unit of ionizing radiation dose
	 * in the International System of Units (SI)
	 * and is a measure of the health effect of low levels of ionizing radiation on the human body.
	 *
	 * The sievert is named after Rolf Maximilian Sievert,
	 * a Swedish medical physicist renowned for work on radiation dose measurement
	 * and research into the biological effects of radiation.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Sievert">Wikipedia: Sievert</a>
	 */
	@AddUnit
	public static final AbstractUnit<RadiationDoseEffective> SIEVERT = unit(JOULE.divide(KILOGRAM).alternate("sievert"),
			RadiationDoseEffective.class);

	/**
	 * <p>The katal (symbol: {@code kat}) is the unit of catalytic activity in the International System of Units (SI).
	 * It is a derived SI unit for quantifying the catalytic activity of enzymes
	 * (that is, measuring the enzymatic activity level in enzyme catalysis) and other catalysts.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Katal">Wikipedia: Katal</a>
	 */
	@AddUnit
	public static final AbstractUnit<CatalyticActivity> KATAL = unit(MOLE.divide(SECOND).alternate("katal"),
			CatalyticActivity.class);

	/**
	 * The candela per square metre (symbol: {@code cd/m}<sup>2</sup>) is the derived SI unit of luminance.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Candela_per_square_metre"> Wikipedia: Candela per square metre</a>
	 */
	@AddUnit
	public static final AbstractUnit<Luminance> CANDELA_PER_SQUARE_METRE = unit(CANDELA.divide(SQUARE_METER),
			Luminance.class);

	private MiscUnits() {
	}
}
