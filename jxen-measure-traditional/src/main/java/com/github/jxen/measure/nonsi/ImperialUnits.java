package com.github.jxen.measure.nonsi;

import static com.github.jxen.measure.nonsi.ImperialUnits.Holder.BUILDER;
import static com.github.jxen.measure.nonsi.ImperialUnits.Holder.R1_16;
import static com.github.jxen.measure.nonsi.ImperialUnits.Holder.R5_9;
import static com.github.jxen.measure.nonsi.ImperialUnits.Holder.RANKINE_SHIFT;
import static com.github.jxen.measure.unit.LmtUnits.GRAM;
import static com.github.jxen.measure.unit.LmtUnits.LITER;
import static com.github.jxen.measure.unit.MetricPrefix.milli;
import static com.github.jxen.measure.unit.MetricUnits.KELVIN;
import static com.github.jxen.measure.unit.MetricUnits.METER;
import static com.github.jxen.measure.unit.MetricUnits.SECOND;
import static com.github.jxen.measure.unit.TimeUnits.HOUR;

import com.github.jxen.math.rational.BigRational;
import com.github.jxen.math.rational.Rational;
import com.github.jxen.measure.unit.AbstractUnit;
import com.github.jxen.measure.unit.NaturalUnits;
import com.github.jxen.measure.unit.SystemOfUnitsImpl;
import javax.measure.Unit;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Area;
import javax.measure.quantity.Force;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Volume;
import javax.measure.spi.SystemOfUnits;

/**
 * {@code ImperialUnits} class represents British imperial unit system.
 *
 * @author Denis Murashev
 *
 * @since Non-SI Units 0.1
 */
public final class ImperialUnits {

	///////////////////////// Length British Imperial Units /////////////////////////

	/**
	 * <p>The inch (abbreviation: {@code in} or &Prime;) is a unit of length in the (British) imperial
	 * and United States customary systems of measurement. It is equal to <sup>1</sup>/<sub>36</sub> yard
	 * or <sup>1</sup>/<sub>12</sub> of a foot.
	 *
	 * <p>Derived from the Roman uncia ("twelfth"), the word inch is also sometimes used to translate similar units
	 * in other measurement systems, usually understood as deriving from the width of the human thumb.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Inch">Wikipedia: Inch</a>
	 */
	public static final AbstractUnit<Length> INCH = BUILDER.unit("inch", METER, new BigRational(254, 10_000),
			Length.class);

	/**
	 * <p>A thousandth of an inch is a derived unit of length in a system of units using inches.
	 * Equal to <sup>1</sup>/<sub>1000</sub> of an inch, it is normally referred to as a {@code thou}, a thousandth,
	 * or (particularly in the United States) a {@code mil}.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Thousandth_of_an_inch">Wikipedia: Thousandth of an inch</a>
	 */
	public static final AbstractUnit<Length> THOU = BUILDER.unit("thou", INCH, new Rational(1, 1000), Length.class);

	/**
	 * <p>The foot (pl. feet; abbreviation: {@code ft}; symbol: &prime;, the prime symbol) is a unit of length
	 * in the imperial and US customary systems of measurement.
	 *
	 * <p>Since the International Yard and Pound Agreement of 1959, one foot is defined as 0.3048 meter exactly.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Foot_(unit)">Wikipedia: Foot (unit)</a>
	 */
	public static final AbstractUnit<Length> FOOT = BUILDER.unit("foot", INCH, 12, Length.class);

	/**
	 * <p>The yard (abbreviation: {@code yd}) is an English unit of length,
	 * in both the British imperial and US customary systems of measurement, that comprises 3 feet or 36 inches.
	 *
	 * <p>Since 1959 it is by international agreement standardized as exactly 0.9144 meters.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Yard">Wikipedia: Yard</a>
	 */
	public static final AbstractUnit<Length> YARD = BUILDER.unit("yard", FOOT, 3, Length.class);

	/**
	 * <p>The chain is a unit of length equal to 66 feet (22 yards). It is subdivided into 100 links or 4 rods.
	 * There are 10 chains in a furlong, and 80 chains in one statute mile. In metric terms, it is 20.1168 m long.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Chain_(unit)">Wikipedia: Chain (unit)</a>
	 */
	public static final AbstractUnit<Length> CHAIN = BUILDER.unit("chain", FOOT, 66, Length.class);

	/**
	 * <p>A furlong is a measure of distance in imperial units and U.S. customary units equal to one eighth of a mile,
	 * equivalent to 660 feet, 220 yards, 40 rods, or 10 chains.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Furlong">Wikipedia: Furlong</a>
	 */
	public static final AbstractUnit<Length> FURLONG = BUILDER.unit("furlong", FOOT, 660, Length.class);

	/**
	 * <p>The mile is an English unit of length of linear measure equal to 5,280 feet, or 1,760 yards,
	 * and standardised as exactly 1,609.344 metres by international agreement in 1959.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Mile">Wikipedia: Mile</a>
	 */
	public static final AbstractUnit<Length> MILE = BUILDER.unit("mile", YARD, 1760, Length.class);

	/**
	 * <p>A league is a unit of length.
	 * It was common in Europe and Latin America, but is no longer an official unit in any nation.
	 * The word originally meant the distance a person could walk in an hour.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/League_(unit)">Wikipedia: League (unit)</a>
	 */
	public static final AbstractUnit<Length> LEAGUE = BUILDER.unit("league", MILE, 3, Length.class);

	/**
	 * <p>A nautical mile is a unit of measurement used in both air and marine navigation,
	 * and for the definition of territorial waters. Historically, it was defined as one minute
	 * (<sup>1</sup>/<sub>60</sub> of a degree) of latitude along any line of longitude.
	 * Today the international nautical mile is defined as exactly 1852 metres.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Nautical_mile">Wikipedia: Nautical mile</a>
	 */
	public static final AbstractUnit<Length> NAUTICAL_MILE = BUILDER.unit("mile^nautical", FOOT, 6080, Length.class);

	/**
	 * <p>A cable length or length of cable is a nautical unit of measure equal to one tenth of a nautical mile
	 * or approximately 100 fathoms.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Cable_length">Wikipedia: Cable length</a>
	 */
	public static final AbstractUnit<Length> CABLE = BUILDER.unit("cable", NAUTICAL_MILE, new Rational(1, 10),
			Length.class);

	/**
	 * <p>The British Admiralty defined a fathom to be a thousandth of an imperial nautical mile (which was 6080 ft)
	 * or 6.08 feet (1.85 m).
	 * In practice the "warship fathom" of exactly 6 feet (1.8 m) was used in Britain and the United States.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Fathom">Wikipedia: Fathom</a>
	 */
	public static final AbstractUnit<Length> FATHOM = BUILDER.unit("fathom", NAUTICAL_MILE, new Rational(1, 1000),
			Length.class);

	/**
	 * <p>The rod or perch or pole (sometimes also lug) is a surveyor's tool
	 * and unit of length exactly equal to 5<sup>1</sup>/<sub>2</sub> yards, 16<sup>1</sup>/<sub>2</sub> feet,
	 * <sup>1</sup>/<sub>320</sub> of a statute mile, or one-fourth of a surveyor's chain (approximately 5.0292 meters).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Rod_(unit)">Wikipedia: Rod (unit)</a>
	 */
	public static final AbstractUnit<Length> ROD = BUILDER.unit("rod", YARD, new Rational(11, 2), Length.class);

	/**
	 * <p>The link (usually abbreviated as {@code l.}, {@code li.} or {@code lnk.}), sometimes called a Gunter's link,
	 * is a unit of length formerly used in many English-speaking countries.
	 * A link is exactly <sup>66</sup>/<sub>100</sub> of a foot, or exactly 7.92 inches or 20.1168 cm.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Link_(unit)">Wikipedia: Link (unit)</a>
	 */
	public static final AbstractUnit<Length> LINK = BUILDER.unit("link", FOOT, new Rational(66, 100), Length.class);

	///////////////////////// Area British Imperial Units /////////////////////////

	/**
	 * <p>A square inch is a unit of area, equal to the area of a square with sides of one inch.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Square_inch">Wikipedia: Square inch</a>
	 */
	public static final AbstractUnit<Area> SQUARE_INCH = BUILDER.unit(INCH.pow(2), Area.class);

	/**
	 * <p>The square foot (abbreviated {@code sq ft}, {@code sf}, or {@code ft}<sup>2</sup>;
	 * also denoted by &prime;<sup>2</sup>) is an imperial unit and U.S. customary unit (non-SI, non-metric) of area,
	 * used mainly in the United States and partially in Bangladesh, Canada, Ghana, Hong Kong, India, Malaysia, Nepal,
	 * Pakistan, Singapore and the United Kingdom.
	 *
	 * <p>is defined as the area of a square with sides of 1 foot.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Square_foot">Wikipedia: Square foot</a>
	 */
	public static final AbstractUnit<Area> SQUARE_FOOT = BUILDER.unit(FOOT.pow(2), Area.class);

	/**
	 * <p>The square yard is an imperial unit of area,
	 * formerly used in most of the English-speaking world but now generally replaced by the square meter,
	 * however it is still in widespread use in the U.S., Canada, the U.K. and India.
	 *
	 * <p>It is defined as the area of a square with sides of one yard (three feet, 0.9144 metres) in length.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Square_yard">Wikipedia: Square yard</a>
	 */
	public static final AbstractUnit<Area> SQUARE_YARD = BUILDER.unit(YARD.pow(2), Area.class);

	/**
	 * <p>As a unit of area, a square perch (the perch being standardized to equal 16<sup>1</sup>/<sub>2</sub> feet,
	 * or 5<sup>1</sup>/<sub>2</sub> yards) is equal to a square rod,
	 * 30<sup>1</sup>/<sub>4</sub> square yards (25.29 square metres) or <sup>1</sup>/<sub>160</sub> acre.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Rod_(unit)#Area_and_volume">Wikipedia: Rod_(unit)#Area_and_volume</a>
	 */
	public static final AbstractUnit<Area> SQUARE_ROD = BUILDER.unit(ROD.pow(2), Area.class);

	/**
	 * <p>Rood is an English unit of area equal to one quarter of an acre] or 10,890 square feet (1,012 m<sup>2</sup>).
	 * A rectangle that is one furlong (i.e., 10 chains, or 40 rods) in length and one rod in width is one rood in area,
	 * as is any space comprising 40 perches (a perch being one square rod).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Rood_(unit)">Wikipedia: Rood (unit)</a>
	 */
	public static final AbstractUnit<Area> ROOD = BUILDER.unit(FURLONG.multiply(ROD).alternate("rood"), Area.class);

	/**
	 * <p>The acre is a unit of land area used in the imperial and US customary systems.
	 * It is traditionally defined as the area of one chain by one furlong (66 by 660 feet).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Acre">Wikipedia: Acre</a>
	 */
	public static final AbstractUnit<Area> ACRE = BUILDER.unit("acre", ROOD, 4, Area.class);

	/**
	 * <p>The square mile (abbreviated as {@code sq mi} and sometimes as {@code mi}<sup>2</sup>) is an imperial
	 * and US unit of measure for an area equal to the area of a square with a side length of one statute mile.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Square_mile">Wikipedia: Square mile</a>
	 */
	public static final AbstractUnit<Area> SQUARE_MILE = BUILDER.unit(MILE.pow(2), Area.class);

	///////////////////////// Volume British Imperial Units /////////////////////////

	/**
	 * <p>The cubic inch (symbol {@code in}<sup>3</sup>) is a unit of measurement for volume in the Imperial units
	 * and United States customary units systems.
	 *
	 * <p>It is the volume of a cube with each of its three dimensions (length, width, and depth) being one inch long.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Cubic_inch">Wikipedia: Cubic inch</a>
	 */
	public static final AbstractUnit<Volume> CUBIC_INCH = BUILDER.unit(INCH.pow(3), Volume.class);

	/**
	 * <p>The cubic foot (symbol {@code ft}<sup>3</sup>) is an imperial and US customary (non-metric) unit of volume,
	 * used in the United States, and partially in Canada, and the United Kingdom.
	 *
	 * <p>It is defined as the volume of a cube with sides of one foot (0.3048 m) in length.
	 * Its volume is 28.3168 liters.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Cubic_foot">Wikipedia: Cubic foot</a>
	 */
	public static final AbstractUnit<Volume> CUBIC_FOOT = BUILDER.unit(FOOT.pow(3), Volume.class);

	/**
	 * <p>A cubic yard (symbol {@code yd}<sup>3</sup>3) is an Imperial / U.S. customary (non-SI non-metric) unit
	 * of volume, used in the United States.
	 *
	 * <p>It is defined as the volume of a cube with sides of 1 yard (3 feet, 36 inches, 0.9144 meters) in length.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Cubic_yard">Wikipedia: Cubic yard</a>
	 */
	public static final AbstractUnit<Volume> CUBIC_YARD = BUILDER.unit(YARD.pow(3), Volume.class);

	///////////////////////// Dry & Wet Volume British Imperial Units /////////////////////////

	/**
	 * <p>A fluid ounce (abbreviated {@code fl oz}, or {@code oz fl}) is a unit of volume (also called capacity)
	 * typically used for measuring liquids.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Fluid_ounce">Wikipedia: Fluid ounce</a>
	 */
	public static final AbstractUnit<Volume> FLUID_OUNCE = BUILDER.unit("ounce^fluid", milli(LITER),
			new BigRational(284_130_625, 10_000_000), Volume.class);

	/**
	 * <p>The gill or teacup is a unit of measurement for volume equal to a quarter of a pint.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Gill_(unit)">Wikipedia: Gill (unit)</a>
	 */
	public static final AbstractUnit<Volume> GILL = BUILDER.unit("gill", FLUID_OUNCE, 5, Volume.class);

	/**
	 * <p>The pint (symbol {@code pt}) is a unit of volume or capacity in the imperial measurement systems.
	 * It is traditionally one eighth of a gallon.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Pint">Wikipedia: Pint</a>
	 */
	public static final AbstractUnit<Volume> PINT = BUILDER.unit("pint", GILL, 4, Volume.class);

	/**
	 * <p>The quart (abbreviation {@code qt.}) is an English unit of volume equal to a quarter gallon.
	 * It is divided into two pints.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Quart">Wikipedia: Quart</a>
	 */
	public static final AbstractUnit<Volume> QUART = BUILDER.unit("quart", PINT, 2, Volume.class);

	/**
	 * <p>The gallon is a unit of measurement for volume and fluid capacity
	 * in the British imperial systems of measurement.
	 *
	 * <p>The imperial gallon defined as 4.54609 litres, which is used in the United Kingdom, Canada,
	 * and some Caribbean nations.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Gallon">Wikipedia: Gallon</a>
	 */
	public static final AbstractUnit<Volume> GALLON = BUILDER.unit("gallon", QUART, 4, Volume.class);

	/**
	 * <p>A peck is an imperial unit of dry volume, equivalent to 2 dry gallons or 8 dry quarts(9.09 liters).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Peck">Wikipedia: Peck</a>
	 */
	public static final AbstractUnit<Volume> PECK = BUILDER.unit("peck", GALLON, 2, Volume.class);

	/**
	 * <p>A bushel (abbreviation: {@code bsh.} or {@code bu.}) is an imperial unit of volume
	 * based upon an earlier measure of dry capacity.
	 * The bushel is equal to 4 pecks or 8 dry gallons and was used mostly for agricultural products such as wheat.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Bushel">Wikipedia: Bushel</a>
	 */
	public static final AbstractUnit<Volume> BUSHEL = BUILDER.unit("bushel", PECK, 4, Volume.class);

	/**
	 * <p>Fluid barrels vary depending on what is being measured and where.
	 * In the UK a beer barrel is 36 imperial gallons (164 L).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Barrel_(unit)">Wikipedia: Barrel (unit)</a>
	 */
	public static final AbstractUnit<Volume> BARREL = BUILDER.unit("barrel", GALLON, 36, Volume.class);

	///////////////////////// Mass British Imperial Units /////////////////////////

	/**
	 * <p>A grain is a unit of measurement of mass, and in the troy weight, avoirdupois, and Apothecaries' system,
	 * equal to exactly 64.79891 milligrams.
	 *
	 * <p>It is nominally based upon the mass of a single virtual ideal seed of a cereal.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Grain_(unit)">Wikipedia: Grain_(unit)</a>
	 */
	public static final AbstractUnit<Mass> GRAIN = BUILDER.unit("grain", GRAM, new BigRational(6_479_891, 100_000_000),
			Mass.class);

	/**
	 * <p>The pound or pound-mass is a unit of mass used in the imperial, United States customary
	 * and other systems of measurement. Various definitions have been used;
	 * the most common today is the international avoirdupois pound,
	 * which is legally defined as exactly 0.45359237 kilograms,
	 * and which is divided into 16 avoirdupois ounces.
	 *
	 * <p>The international standard symbol for the avoirdupois pound is {@code lb}
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Pound_(mass)#Avoirdupois_pound">Wikipedia: Avoirdupois pound</a>
	 */
	public static final AbstractUnit<Mass> POUND = BUILDER.unit("pound", GRAIN, 7000, Mass.class);

	/**
	 * <p>The ounce (abbreviated {@code oz}) is a unit of mass in most British derived customary systems of measurement.
	 * The common avoirdupois ounce (approximately 28.3 g) is <sup>1</sup>/<sub>16</sub> of a common avoirdupois pound;
	 * this is the United States customary and British imperial ounce.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Ounce">Wikipedia: Ounce</a>
	 */
	public static final AbstractUnit<Mass> OUNCE = BUILDER.unit("ounce", POUND, R1_16, Mass.class);

	/**
	 * <p>The dram (alternative British spelling drachm; apothecary abbreviated symbol {@code dr})
	 * is a unit of mass in the avoirdupois system.
	 *
	 * <p>In the avoirdupois system, the dram is the mass of <sup>1</sup>/<sub>256</sub> pound
	 * or <sup>1</sup>/<sub>16</sub> ounce. The dram weighs <sup>875</sup>/<sub>32</sub> grains,
	 * or exactly 1.7718451953125 grams.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Dram_(unit)">Wikipedia: Dram (unit)</a>
	 */
	public static final AbstractUnit<Mass> DRAM = BUILDER.unit("dram", OUNCE, R1_16, Mass.class);

	/**
	 * <p>The stone or stone weight (abbreviation: {@code st.}) is an English and imperial unit of mass
	 * now equal to 14 pounds (6.35029318 kg).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Stone_(unit)">Wikipedia: Stone (unit)</a>
	 */
	public static final AbstractUnit<Mass> STONE = BUILDER.unit("stone", POUND, 14, Mass.class);

	/**
	 * <p>The hundredweight (abbreviation: {@code cwt}), formerly also known as the centum weight or quintal,
	 * is an English, imperial unit of weight or mass of various values.
	 *
	 * <p>The long or imperial hundredweight of 8 stone or 112 pounds (50.802345 kg)
	 * is in informal use in the imperial system.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Hundredweight">Wikipedia: Hundredweight</a>
	 */
	public static final AbstractUnit<Mass> CWT = BUILDER.unit("hundredweight", POUND, 112, Mass.class);

	/**
	 * <p>The long ton is a unit of measure.
	 * In the United Kingdom the (Imperial) ton is Statute measure, defined as 2,240 lb (1,016 kg).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Ton">Wikipedia: Ton</a>
	 */
	public static final AbstractUnit<Mass> TON = BUILDER.unit("ton", POUND, 2240, Mass.class);

	///////////////////////// Speed British Imperial Units /////////////////////////

	/**
	 * <p>The foot per second (plural feet per second) is a unit of both speed (scalar) and velocity
	 * (vector quantity, which includes direction).
	 * It expresses the distance in feet (ft) traveled or displaced, divided by the time in seconds (s).
	 *
	 * <p>Abbreviations include {@code ft/s}, {@code fps}, and the scientific notation {@code ft s}<sup>-1</sup>.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Foot_per_second">Wikipedia: Foot per second</a>
	 */
	public static final AbstractUnit<Speed> FOOT_PER_SECOND = BUILDER.unit(FOOT.divide(SECOND), Speed.class);

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

	///////////////////////// Acceleration British Imperial Units /////////////////////////

	/**
	 * <p>The SI unit for acceleration quantities (standard name m/s&sup2;).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Metre_per_second_squared">Wikipedia: Metre per second squared</a>
	 */
	public static final AbstractUnit<Acceleration> FOOT_PER_SECOND_SQUARED = BUILDER.unit(FOOT.divide(SECOND.pow(2)),
			Acceleration.class);

	///////////////////////// Force British Imperial Units /////////////////////////

	/**
	 * <p>The pound of force or pound-force (symbol: {@code lbf}, sometimes {@code lb}<sub>f</sub>)
	 * is a unit of force used in some systems of measurement
	 * including English Engineering units and the Foot-pound-second system.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Pound_(force)">Wikipedia: Pound (force)</a>
	 */
	public static final Unit<Force> POUND_FORCE = BUILDER.unit(POUND.multiply(NaturalUnits.STANDARD_GRAVITY)
			.alternate("pound^force"), Force.class);

	/**
	 * <p>The poundal (symbol: {@code pdl}) is a unit of force that is part of the foot-pound-second system of units,
	 * in Imperial units introduced in 1877, and is from the specialized subsystem of English absolute
	 * (a coherent system).
	 *
	 * <p>The poundal is defined as the force necessary to accelerate 1 pound-mass at 1 foot per second per second.
	 * 1 pdl = 0.138254954376 N exactly.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Poundal">Wikipedia: Poundal</a>
	 */
	public static final AbstractUnit<Force> POUNDAL = BUILDER.unit(FOOT.multiply(FOOT_PER_SECOND_SQUARED)
			.alternate("poundal"), Force.class);

	///////////////////////// Temperature Units /////////////////////////

	/**
	 * <p>The Rankine scale is an absolute scale of thermodynamic temperature named after
	 * the Glasgow University engineer and physicist William John Macquorn Rankine, who proposed it in 1859.
	 * A unit of temperature equal to <sup>5</sup>/<sub>9</sub> {@code K} (standard name &deg;{@code R}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Rankine_scale">Wikipedia: Rankine scale</a>
	 */
	public static final AbstractUnit<Temperature> RANKINE = BUILDER.unit("rankine", KELVIN, R5_9, Temperature.class);

	/**
	 * <p>The Fahrenheit scale is a temperature scale based on one proposed in 1724
	 * by German physicist Daniel Gabriel Fahrenheit (1686-1736).
	 * It uses the degree Fahrenheit (symbol: &deg;{@code F}) as the unit.
	 *
	 * <p>On the Fahrenheit scale, the freezing point of water is 32 &deg;{@code F}
	 * and the boiling point is 212 &deg;{@code F} (at standard atmospheric pressure).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Fahrenheit">Wikipedia: Fahrenheit</a>
	 */
	public static final AbstractUnit<Temperature> FAHRENHEIT = BUILDER.unit(RANKINE.shift(RANKINE_SHIFT)
			.alternate("fahrenheit"), Temperature.class);

	///////////////////////// System of British Imperial Units /////////////////////////

	/**
	 * The instance of {@link SystemOfUnits}.
	 */
	public static final SystemOfUnits SYSTEM = BUILDER.build();

	private ImperialUnits() {
	}

	static final class Holder {

		static final SystemOfUnitsImpl.Builder BUILDER = SystemOfUnitsImpl.builder("Imperial");

		static final Rational R1_16 = new Rational(1, 16);

		static final Rational R5_9 = new Rational(5, 9);

		static final double RANKINE_SHIFT = 459.67;

		private Holder() {
		}
	}
}
