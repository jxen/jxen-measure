package com.github.jxen.measure.unit;

import static com.github.jxen.measure.unit.LmtUnits.WATT;
import static com.github.jxen.measure.unit.MetricUnits.AMPERE;
import static com.github.jxen.measure.unit.MetricUnits.Holder.BUILDER;
import static com.github.jxen.measure.unit.MetricUnits.METER;
import static com.github.jxen.measure.unit.MetricUnits.SECOND;

import javax.measure.quantity.ElectricCapacitance;
import javax.measure.quantity.ElectricCharge;
import javax.measure.quantity.ElectricConductance;
import javax.measure.quantity.ElectricInductance;
import javax.measure.quantity.ElectricPotential;
import javax.measure.quantity.ElectricResistance;
import javax.measure.quantity.MagneticFlux;
import javax.measure.quantity.MagneticFluxDensity;

/**
 * {@code ElectromagneticUnits} class contains named units derived from SI base units.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.2
 */
public final class ElectromagneticUnits {

	/**
	 * <p>The coulomb (symbol: {@code C}) is the International System of Units (SI) unit of electric charge.
	 * It is the charge (symbol: Q or q) transported by a constant current of one ampere in one second.
	 *
	 * <p>It is named after the French physicist Charles Augustin de Coulomb (1736-1806).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Coulomb">Wikipedia: Coulomb</a>
	 */
	public static final AbstractUnit<ElectricCharge> COULOMB = BUILDER.unit(AMPERE.multiply(SECOND)
			.alternate("coulomb"), ElectricCharge.class);

	/**
	 * <p>The volt (symbol: {@code V}) is the derived unit for electric potential,
	 * electric potential difference (voltage), and electromotive force.
	 *
	 * <p>One volt is defined as the difference in electric potential between two points of a conducting wire
	 * when an electric current of one ampere dissipates one watt of power between those points.
	 *
	 * <p>It is named after the Italian physicist Alessandro Volta (1745-1827).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Volt">Wikipedia: Volt</a>
	 */
	public static final AbstractUnit<ElectricPotential> VOLT = BUILDER.unit(WATT.divide(AMPERE).alternate("volt"),
			ElectricPotential.class);

	/**
	 * <p>The farad (symbol: {@code F}) is the SI derived unit of electrical capacitance,
	 * the ability of a body to store an electrical charge.
	 *
	 * <p>One farad is defined as the capacitance across which, when charged with one coulomb,
	 * there is a potential difference of one volt.
	 * Equally, one farad can be described as the capacitance which stores a one-coulomb charge
	 * across a potential difference of one volt.
	 *
	 * <p>It is named after the English physicist Michael Faraday.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Farad">Wikipedia: Farad</a>
	 */
	public static final AbstractUnit<ElectricCapacitance> FARAD = BUILDER.unit(COULOMB.divide(VOLT).alternate("farad"),
			ElectricCapacitance.class);

	/**
	 * <p>The ohm (symbol: &Omega;) is the SI derived unit of electrical resistance.
	 *
	 * <p>The ohm is defined as an electrical resistance between two points of a conductor
	 * when a constant potential difference of one volt, applied to these points,
	 * produces in the conductor a current of one ampere, the conductor not being the seat of any electromotive force.
	 *
	 * <p>It is named after German physicist Georg Simon Ohm.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Ohm">Wikipedia: Ohm</a>
	 */
	public static final AbstractUnit<ElectricResistance> OHM = BUILDER.unit(VOLT.divide(AMPERE).alternate("ohm"),
			ElectricResistance.class);

	/**
	 * <p>The siemens (symbol: {@code S}) is the derived unit of electric conductance, electric susceptance,
	 * and electric admittance in the International System of Units (SI).
	 * Conductance, susceptance, and admittance are the reciprocals of resistance, reactance,
	 * and impedance respectively; hence one siemens is redundantly equal to the reciprocal of one ohm,
	 * and is also referred to as the mho. The 14th General Conference on Weights and Measures approved the addition
	 * of the siemens as a derived unit in 1971.
	 *
	 * <p>The unit is named after Ernst Werner von Siemens.
	 * In English, the same form siemens is used both for the singular and plural.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Siemens_(unit)">Wikipedia: Siemens (unit)</a>
	 */
	public static final AbstractUnit<ElectricConductance> SIEMENS = BUILDER.unit(AMPERE.divide(VOLT)
			.alternate("siemens"), ElectricConductance.class);

	/**
	 * <p>The weber (symbol: {@code Wb}) is the SI derived unit of magnetic flux.
	 * A flux density of one Wb/m2 (one weber per square metre) is one tesla.
	 *
	 * <p>The weber is named after the German physicist Wilhelm Eduard Weber (1804-1891).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Weber_(unit)">Wikipedia: Weber (unit)</a>
	 */
	public static final AbstractUnit<MagneticFlux> WEBER = BUILDER.unit(VOLT.multiply(SECOND).alternate("weber"),
			MagneticFlux.class);

	/**
	 * <p>The tesla (symbol: {@code T}) is a derived unit of the magnetic induction (also, magnetic flux density)
	 * in the International System of Units.
	 *
	 * <p>One tesla is equal to one weber per square meter.
	 * The unit was announced during the General Conference on Weights and Measures in 1960
	 * and is named in honour of Nikola Tesla.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Tesla_(unit)">Wikipedia: Tesla (unit)</a>
	 */
	public static final AbstractUnit<MagneticFluxDensity> TESLA = BUILDER.unit(WEBER.divide(METER.pow(2))
			.alternate("tesla"), MagneticFluxDensity.class);

	/**
	 * <p>The henry (symbol: {@code H}) is the SI derived unit of electrical inductance.
	 * If a current of 1 ampere flowing through the coil produces flux linkage of 1 weber turn,
	 * the coil has a self inductance of 1 henry.
	 *
	 * <p>The unit is named after Joseph Henry (1797-1878),
	 * the American scientist who discovered electromagnetic induction independently of
	 * and at about the same time as Michael Faraday (1791-1867) in England.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Henry_(unit)">Wikipedia: Henry (unit)</a>
	 */
	public static final AbstractUnit<ElectricInductance> HENRY = BUILDER.unit(WEBER.divide(AMPERE).alternate("henry"),
			ElectricInductance.class);

	private ElectromagneticUnits() {
	}
}
