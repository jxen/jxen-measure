package com.github.jxen.measure.nonsi;

import static com.github.jxen.measure.nonsi.UsCustomaryUnits.Holder.BUILDER;
import static com.github.jxen.measure.unit.MetricUnits.METER;
import static com.github.jxen.measure.unit.TimeUnits.HOUR;

import com.github.jxen.math.rational.Rational;
import com.github.jxen.measure.unit.AbstractUnit;
import com.github.jxen.measure.unit.SystemOfUnitsImpl;
import javax.measure.Unit;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Volume;
import javax.measure.spi.SystemOfUnits;

/**
 * {@code UsCustomaryUnits} class represents United States customary unit system.
 *
 * @author Denis Murashev
 *
 * @since Non-SI Units 0.2
 */
public final class UsCustomaryUnits {

	///////////////////////// Length US Customary Units /////////////////////////

	/**
	 * Inch.
	 *
	 * @see ImperialUnits#INCH
	 */
	public static final AbstractUnit<Length> INCH = BUILDER.unit(ImperialUnits.INCH, Length.class);

	/**
	 * Foot.
	 *
	 * @see ImperialUnits#FOOT
	 */
	public static final AbstractUnit<Length> FOOT = BUILDER.unit(ImperialUnits.FOOT, Length.class);

	/**
	 * The United States survey foot is defined as exactly <sup>1200</sup>/<sub>3937</sub> meters.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Foot_(unit)#US_survey_foot">US survey foot</a>
	 */
	public static final Unit<Length> FOOT_SURVEY = BUILDER.unit("foot_survey", METER, new Rational(1200, 3937),
			Length.class);

	/**
	 * Yard.
	 *
	 * @see ImperialUnits#YARD
	 */
	public static final AbstractUnit<Length> YARD = BUILDER.unit(ImperialUnits.YARD, Length.class);

	/**
	 * Mile.
	 *
	 * @see ImperialUnits#MILE
	 */
	public static final AbstractUnit<Length> MILE = BUILDER.unit(ImperialUnits.MILE, Length.class);

	/**
	 * <p>A nautical mile is a unit of measurement used in both air and marine navigation,
	 * and for the definition of territorial waters. Historically, it was defined as one minute
	 * (<sup>1</sup>/<sub>60</sub> of a degree) of latitude along any line of longitude.
	 * Today the international nautical mile is defined as exactly 1852 metres.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Nautical_mile">Wikipedia: Nautical mile</a>
	 */
	public static final AbstractUnit<Length> NAUTICAL_MILE = BUILDER.unit("mile^nautical", METER, 1852, Length.class);

	///////////////////////// Area US Customary Units /////////////////////////

	/**
	 * Square foot.
	 *
	 * @see ImperialUnits#SQUARE_FOOT
	 */
	public static final AbstractUnit<Area> SQUARE_FOOT = BUILDER.unit(ImperialUnits.SQUARE_FOOT, Area.class);

	/**
	 * Square chain.
	 *
	 * @see ImperialUnits#CHAIN
	 */
	public static final AbstractUnit<Area> SQUARE_CHAIN = BUILDER.unit(ImperialUnits.CHAIN.pow(2), Area.class);

	/**
	 * Acre.
	 *
	 * @see ImperialUnits#ACRE
	 */
	public static final AbstractUnit<Area> ACRE = BUILDER.unit(ImperialUnits.ACRE, Area.class);

	/**
	 * <p>In U.S. land surveying under the Public Land Survey System (PLSS),
	 * a section is an area nominally one square mile (2.6 square kilometers), containing 640 acres (260 hectares)
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Section_(United_States_land_surveying)">Wikipedia:
	 * Section (United States land surveying)</a>
	 */
	public static final AbstractUnit<Area> SECTION = BUILDER.unit(ImperialUnits.SQUARE_MILE.alternate("section"),
			Area.class);

	/**
	 * <p>In U.S. land surveying under the Public Land Survey System (PLSS),
	 * a section is an area nominally one square mile (2.6 square kilometers), containing 640 acres (260 hectares)
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Survey_township">Wikipedia: Survey township</a>
	 */
	public static final AbstractUnit<Area> TOWNSHIP = BUILDER.unit("township", SECTION, 36, Area.class);

	///////////////////////// Volume US Customary Units /////////////////////////

	/**
	 * Cubic inch.
	 *
	 * @see ImperialUnits#CUBIC_INCH
	 */
	public static final AbstractUnit<Volume> CUBIC_INCH = BUILDER.unit(ImperialUnits.CUBIC_INCH, Volume.class);

	/**
	 * Cubic foot.
	 *
	 * @see ImperialUnits#CUBIC_FOOT
	 */
	public static final AbstractUnit<Volume> CUBIC_FOOT = BUILDER.unit(ImperialUnits.CUBIC_FOOT, Volume.class);

	/**
	 * Cubic yard.
	 *
	 * @see ImperialUnits#CUBIC_YARD
	 */
	public static final AbstractUnit<Volume> CUBIC_YARD = BUILDER.unit(ImperialUnits.CUBIC_YARD, Volume.class);

	/**
	 * <p>The acre-foot is a non-SI unit of volume commonly used in the United States
	 * in reference to large-scale water resources, such as reservoirs, aqueducts, canals, sewer flow capacity,
	 * irrigation water, and river flows.
	 *
	 * <p>An acre-foot equals approximately an 8 lane swimming pool, 25 meter long, 16 m wide and 3 m deep.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Acre-foot">Wikipedia: Acre-foot</a>
	 */
	public static final AbstractUnit<Volume> ACRE_FOOT = BUILDER.unit(ACRE.multiply(FOOT), Volume.class);

	///////////////////////// Fluid Volume US Customary Units /////////////////////////

	/**
	 * <p>The gallon is a unit of measurement for volume and fluid capacity in the US customary units
	 * systems of measurement.
	 *
	 * <p>the US gallon defined as 231 cubic inches (exactly 3.785411784 litres),
	 * which is used in the US and some Latin American and Caribbean countries.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Gallon">Wikipedia: Gallon</a>
	 */
	public static final AbstractUnit<Volume> GALLON = BUILDER.unit("gallon", CUBIC_INCH, 231, Volume.class);

	/**
	 * <p>The quart (abbreviation {@code qt.}) is an English unit of volume equal to a quarter gallon.
	 * It is divided into two pints.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Quart">Wikipedia: Quart</a>
	 */
	public static final AbstractUnit<Volume> QUART = BUILDER.unit("quart", GALLON, Rational.ONE_FOURTH, Volume.class);

	/**
	 * <p>The pint (symbol {@code pt}) is a unit of volume or capacity in the  United States customary measurement
	 * systems. It is traditionally one eighth of a gallon.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Pint">Wikipedia: Pint</a>
	 */
	public static final AbstractUnit<Volume> PINT = BUILDER.unit("pint", QUART, Rational.HALF, Volume.class);

	/**
	 * <p>The cup is a cooking measure of volume, commonly associated with cooking and serving sizes.
	 * It is traditionally equal to half a liquid pint in US customary units.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Cup_(unit)">Wikipedia: Cup (unit)</a>
	 */
	public static final AbstractUnit<Volume> CUP = BUILDER.unit("cup", PINT, Rational.HALF, Volume.class);

	/**
	 * <p>The gill or teacup is a unit of measurement for volume equal to a quarter of a pint.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Gill_(unit)">Wikipedia: Gill (unit)</a>
	 */
	public static final AbstractUnit<Volume> GILL = BUILDER.unit("gill", CUP, Rational.HALF, Volume.class);

	/**
	 * <p>A fluid ounce (abbreviated {@code fl oz}, or {@code oz fl}) is a unit of volume (also called capacity)
	 * typically used for measuring liquids.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Fluid_ounce">Wikipedia: Fluid ounce</a>
	 */
	public static final AbstractUnit<Volume> FLUID_OUNCE = BUILDER.unit("ounce^fluid", GILL, Rational.ONE_FOURTH,
			Volume.class);

	/**
	 * <p>A tablespoon is a large spoon used for serving.
	 *
	 * <p>By extension, the term is also used as a cooking measure of volume.
	 * In this capacity, it is most commonly abbreviated {@code tbsp.} or {@code T.},
	 * and occasionally referred to as a tablespoonful to distinguish it from the utensil.
	 * The unit of measurement varies by region: a United States tablespoon is approximately 14.8 mL (0.50 US fl oz).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Tablespoon">Wikipedia: Tablespoon</a>
	 */
	public static final AbstractUnit<Volume> TABLESPOON = BUILDER.unit("spoon^table", FLUID_OUNCE, Rational.HALF,
			Volume.class);

	/**
	 * <p>As a unit of culinary measure, one teaspoon in the United States is <sup>1</sup>/<sub>3</sub> tablespoon,
	 * that is, exactly 4.92892159375 mL; it is exactly 1<sup>1</sup>/<sub>3</sub> US fluid drams,
	 * <sup>1</sup>/<sub>6</sub> US fl oz.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Teaspoon">Wikipedia: Teaspoon</a>
	 */
	public static final AbstractUnit<Volume> TEASPOON = BUILDER.unit("spoon^tea", TABLESPOON, Rational.ONE_THIRD,
			Volume.class);

	/**
	 * <p>A fluid ounce (abbreviated {@code fl oz}, or {@code oz fl}) is a unit of volume (also called capacity)
	 * typically used for measuring liquids.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Dram_(unit)#Dram_(volume)">Wikipedia: Dram (volume)</a>
	 */
	public static final AbstractUnit<Volume> FLUID_DRAM = BUILDER.unit("dram^fluid", FLUID_OUNCE,
			Rational.ONE_EIGHTH, Volume.class);

	/**
	 * <p>The minim (abbreviated {@code min}) is a unit of volume in the US customary system of measurement.
	 * Specifically it is <sup>1</sup>/<sub>60</sub> of a fluid drachm or <sup>1</sup>/<sub>480</sub> of a fluid ounce.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Minim_(unit)">Wikipedia: Minim (unit)</a>
	 */
	public static final AbstractUnit<Volume> MINIM = BUILDER.unit("minim", FLUID_DRAM, new Rational(1, 60),
			Volume.class);

	/**
	 * <p>Fluid barrels vary depending on what is being measured and where.
	 * In the US most fluid barrels (apart from oil) are 31.5 US gallons (26 imp gal; 119 L).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Barrel_(unit)">Wikipedia: Barrel (unit)</a>
	 */
	public static final AbstractUnit<Volume> BARREL = BUILDER.unit("barrel", GALLON, 31.5, Volume.class);

	/**
	 * <p>A hogshead (abbreviated {@code hhd}) is a large cask of liquid (or, less often, of a food commodity).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Hogshead">Wikipedia: Hogshead</a>
	 */
	public static final AbstractUnit<Volume> HOGSHEAD = BUILDER.unit("hogshead", BARREL, 2, Volume.class);

	///////////////////////// Dry Volume US Customary Units /////////////////////////

	/**
	 * <p>A bushel (abbreviation: {@code bsh.} or {@code bu.}) is an US customary unit of volume
	 * based upon an earlier measure of dry capacity.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Bushel">Wikipedia: Bushel</a>
	 */
	public static final AbstractUnit<Volume> BUSHEL = BUILDER.unit("bushel", CUBIC_INCH, 2150.42, Volume.class);

	/**
	 * <p>A peck is an imperial unit of dry volume, equivalent to 2 dry gallons or 8 dry quarts(8.81 liters).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Peck">Wikipedia: Peck</a>
	 */
	public static final AbstractUnit<Volume> PECK = BUILDER.unit("peck", BUSHEL, Rational.ONE_FOURTH, Volume.class);

	/**
	 * <p>The gallon is a unit of measurement for volume and implicitly dry capacity in the US customary units
	 * systems of measurement.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Dry_gallon">Wikipedia: Dry gallon</a>
	 */
	public static final AbstractUnit<Volume> DRY_GALLON = BUILDER.unit("gallon^dry", PECK, Rational.HALF, Volume.class);

	/**
	 * <p>The quart (abbreviation {@code qt.}) is an English unit of volume equal to a quarter gallon.
	 * It is divided into two pints.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Quart">Wikipedia: Quart</a>
	 */
	public static final AbstractUnit<Volume> DRY_QUART = BUILDER.unit("quart^dry", DRY_GALLON, Rational.ONE_FOURTH,
			Volume.class);

	/**
	 * <p>The pint (symbol {@code pt}) is a unit of volume or capacity in the  United States customary measurement
	 * systems. It is traditionally one eighth of a gallon.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Pint">Wikipedia: Pint</a>
	 */
	public static final AbstractUnit<Volume> DRY_PINT = BUILDER.unit("pint^dry", DRY_QUART, Rational.HALF,
			Volume.class);

	///////////////////////// Mass US Customary Units /////////////////////////

	/**
	 * Grain.
	 *
	 * @see ImperialUnits#GRAIN
	 */
	public static final AbstractUnit<Mass> GRAIN = BUILDER.unit(ImperialUnits.GRAIN, Mass.class);

	/**
	 * Dram.
	 *
	 * @see ImperialUnits#DRAM
	 */
	public static final AbstractUnit<Mass> DRAM = BUILDER.unit(ImperialUnits.DRAM, Mass.class);

	/**
	 * Ounce.
	 *
	 * @see ImperialUnits#OUNCE
	 */
	public static final AbstractUnit<Mass> OUNCE = BUILDER.unit(ImperialUnits.OUNCE, Mass.class);

	/**
	 * Pound.
	 *
	 * @see ImperialUnits#POUND
	 */
	public static final AbstractUnit<Mass> POUND = BUILDER.unit(ImperialUnits.POUND, Mass.class);

	/**
	 * <p>The hundredweight (abbreviation: {@code cwt}), formerly also known as the centum weight or quintal,
	 * is an American unit of weight or mass of various values.
	 *
	 * <p>The short hundredweight or cental of 100 pounds (45.359237 kg) is used in the United States.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Hundredweight">Wikipedia: Hundredweight</a>
	 */
	public static final AbstractUnit<Mass> CWT = BUILDER.unit("hundredweight", POUND, 100, Mass.class);

	/**
	 * <p>The short ton is a unit of measure.
	 * In the United States and Canada a ton is defined to be 2,000 pounds (907 kg).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Ton">Wikipedia: Ton</a>
	 */
	public static final AbstractUnit<Mass> TON = BUILDER.unit("ton", POUND, 2000, Mass.class);

	///////////////////////// Speed US Customary Units /////////////////////////

	/**
	 * <p>Foot per second.
	 *
	 * @see ImperialUnits#FOOT_PER_SECOND
	 */
	public static final AbstractUnit<Speed> FOOT_PER_SECOND = BUILDER.unit(ImperialUnits.FOOT_PER_SECOND, Speed.class);

	/**
	 * <p>Miles per hour ({@code mph}, {@code MPH} or {@code mi/h}) is a British imperial
	 * and United States customary unit of speed expressing the number of statute miles covered in one hour.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Miles_per_hour">Wikipedia: Miles per hour</a>
	 */
	public static final AbstractUnit<Speed> MILE_PER_HOUR = BUILDER.unit(MILE.divide(HOUR), Speed.class);

	/**
	 * <p>The knot is a unit of speed equal to one nautical mile per hour, exactly 1.852 km/h
	 * (approximately 1.15078 mph or 0.514 m/s).
	 *
	 * <p>The ISO standard symbol for the knot is {@code kn}.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Knot_(unit)">Wikipedia: Knot (unit)</a>
	 */
	public static final AbstractUnit<Speed> KNOT = BUILDER.unit(NAUTICAL_MILE.divide(HOUR).alternate("knot"),
			Speed.class);

	///////////////////////// Temperature Units /////////////////////////

	/**
	 * Degree Fahrenheit.
	 *
	 * @see ImperialUnits#FAHRENHEIT
	 */
	public static final AbstractUnit<Temperature> FAHRENHEIT = BUILDER.unit(ImperialUnits.FAHRENHEIT,
			Temperature.class);

	///////////////////////// System of US Customary Units /////////////////////////

	/**
	 * The instance of {@link SystemOfUnits}.
	 */
	public static final SystemOfUnits SYSTEM = BUILDER.build();

	private UsCustomaryUnits() {
	}

	static final class Holder {

		static final SystemOfUnitsImpl.Builder BUILDER = SystemOfUnitsImpl.builder("US Customary");

		private Holder() {
		}
	}
}
