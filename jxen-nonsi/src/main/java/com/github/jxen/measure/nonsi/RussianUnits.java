package com.github.jxen.measure.nonsi;

import static com.github.jxen.measure.nonsi.ImperialUnits.CUBIC_INCH;
import static com.github.jxen.measure.nonsi.RussianUnits.Holder.BUILDER;
import static com.github.jxen.measure.nonsi.RussianUnits.Holder.R1_96;
import static com.github.jxen.measure.unit.MetricUnits.KILOGRAM;

import com.github.jxen.math.rational.BigRational;
import com.github.jxen.math.rational.Rational;
import com.github.jxen.measure.unit.AbstractUnit;
import com.github.jxen.measure.unit.SystemOfUnitsImpl;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;
import javax.measure.spi.SystemOfUnits;

/**
 * {@code RussianUnits} class represents old Russian unit system.
 *
 * @author Denis Murashev
 *
 * @see <a href="https://en.wikipedia.org/wiki/Obsolete_Russian_units_of_measurement">Obsolete Russian units of
 * measurement</a>
 *
 * @since Non-SI Units 0.1
 */
public final class RussianUnits {

	///////////////////////// Length obsolete Russian Units /////////////////////////

	/**
	 * Tochka (point). <sup>1</sup>/<sub>100</sub> inch.
	 */
	public static final AbstractUnit<Length> POINT = BUILDER.unit("point", ImperialUnits.INCH, new BigRational(1, 100),
			Length.class);

	/**
	 * Line. <sup>1</sup>/<sub>10</sub> inch.
	 */
	public static final AbstractUnit<Length> LINE = BUILDER.unit("line", ImperialUnits.INCH, new Rational(1, 10),
			Length.class);

	/**
	 * Inch.
	 *
	 * @see ImperialUnits#INCH
	 */
	public static final AbstractUnit<Length> INCH = BUILDER.unit(ImperialUnits.INCH, Length.class);

	/**
	 * Vershok (tip, top). 1<sup>3</sup>/<sub>4</sub> inches.
	 */
	public static final AbstractUnit<Length> VERSHOK = BUILDER.unit("vershok", INCH, new Rational(7, 4),
			Length.class);

	/**
	 * Pyad (Span, quarter). 7 inches.
	 */
	public static final AbstractUnit<Length> SPAN = BUILDER.unit("span", INCH, 7, Length.class);

	/**
	 * Foot.
	 *
	 * @see ImperialUnits#FOOT
	 */
	public static final AbstractUnit<Length> FOOT = BUILDER.unit(ImperialUnits.FOOT, Length.class);

	/**
	 * Arshin. 28 inches.
	 */
	public static final AbstractUnit<Length> ARSHIN = BUILDER.unit("arshin", INCH, 28, Length.class);

	/**
	 * Sazhen (fathom). 7 feet.
	 */
	public static final AbstractUnit<Length> FATHOM = BUILDER.unit("fathom", FOOT, 7, Length.class);

	/**
	 * Verst (turn of a plough). 3,500 feet.
	 */
	public static final AbstractUnit<Length> VERST = BUILDER.unit("verst", FATHOM, 500, Length.class);

	/**
	 * Mile. 24,500 feet.
	 */
	public static final AbstractUnit<Length> MILE = BUILDER.unit("mile", VERST, 7, Length.class);

	///////////////////////// Area obsolete Russian Units /////////////////////////

	/**
	 * Square line.
	 */
	public static final AbstractUnit<Area> SQUARE_LINE = BUILDER.unit(LINE.pow(2), Area.class);

	/**
	 * Square inch.
	 */
	public static final AbstractUnit<Area> SQUARE_INCH = BUILDER.unit(INCH.pow(2), Area.class);

	/**
	 * Square vershok.
	 */
	public static final AbstractUnit<Area> SQUARE_VERSHOK = BUILDER.unit(VERSHOK.pow(2), Area.class);

	/**
	 * Square foot.
	 */
	public static final AbstractUnit<Area> SQUARE_FOOT = BUILDER.unit(FOOT.pow(2), Area.class);

	/**
	 * Square arshin.
	 */
	public static final AbstractUnit<Area> SQUARE_ARSHIN = BUILDER.unit(ARSHIN.pow(2), Area.class);

	/**
	 * Square fathom.
	 */
	public static final AbstractUnit<Area> SQUARE_FATHOM = BUILDER.unit(FATHOM.pow(2), Area.class);

	/**
	 * Dessyatina.
	 */
	public static final AbstractUnit<Area> DESSYATINA = BUILDER.unit("dessyatina", SQUARE_FATHOM, 2400, Area.class);

	/**
	 * Square verst.
	 */
	public static final AbstractUnit<Area> SQUARE_VERST = BUILDER.unit(VERST.pow(2), Area.class);

	///////////////////////// Liquid Volume obsolete Russian Units /////////////////////////

	/**
	 * Shkalik (shot, measure). 3<sup>3</sup>/<sub>4</sub> cu in.
	 */
	public static final AbstractUnit<Volume> SHKALIK = BUILDER.unit("shkalik", CUBIC_INCH, new Rational(3, 3, 4),
			Volume.class);

	/**
	 * Charka (wine glass). 7<sup>1</sup>/<sub>2</sub> cu in.
	 */
	public static final AbstractUnit<Volume> CHARKA = BUILDER.unit("charka", CUBIC_INCH, new Rational(7, 1, 2),
			Volume.class);

	/**
	 * Stakan (cup, glass). 15<sup>5</sup>/<sub>8</sub> cu in.
	 */
	public static final AbstractUnit<Volume> CUP = BUILDER.unit("cup", CUBIC_INCH, new Rational(15, 5, 8),
			Volume.class);

	/**
	 * Vodka bottle. 37<sup>1</sup>/<sub>2</sub> cu in.
	 */
	public static final AbstractUnit<Volume> VODKA_BOTTLE = BUILDER.unit("bottle^vodka", CUBIC_INCH,
			new Rational(37, 1, 2), Volume.class);

	/**
	 * Wine bottle. 46<sup>7</sup>/<sub>8</sub> cu in.
	 */
	public static final AbstractUnit<Volume> WINE_BOTTLE = BUILDER.unit("bottle^wine", CUBIC_INCH,
			new Rational(46, 7, 8), Volume.class);

	/**
	 * Stof (mug, flagon). 75 cu in.
	 */
	public static final AbstractUnit<Volume> STOF = BUILDER.unit("stof", CUBIC_INCH, 75, Volume.class);

	/**
	 * Chetvert' (quarter of bucket). 187.5 cu in.
	 */
	public static final AbstractUnit<Volume> QUARTER = BUILDER.unit("quarter", CUBIC_INCH, 187.5, Volume.class);

	/**
	 * Vedro (bucket). 750 cu in.
	 */
	public static final AbstractUnit<Volume> BUCKET = BUILDER.unit("bucket", CUBIC_INCH, 750, Volume.class);

	/**
	 * Bochka (barrel). 30,000 cu in.
	 */
	public static final AbstractUnit<Volume> BARREL = BUILDER.unit("bochka", CUBIC_INCH, 30_000, Volume.class);

	///////////////////////// Dry Volume obsolete Russian Units /////////////////////////

	/**
	 * Dry part. Dry measure.
	 */
	public static final AbstractUnit<Volume> DRY_PART = BUILDER.unit("part^dry", CUBIC_INCH, new Rational(20, 3),
			Volume.class);

	/**
	 * Glass. Dry measure.
	 */
	public static final AbstractUnit<Volume> DRY_GLASS = BUILDER.unit("cup^dry", CUBIC_INCH, new Rational(50, 3),
			Volume.class);

	/**
	 * Garnets (pot). 200 cu in.
	 */
	public static final AbstractUnit<Volume> GARNETS = BUILDER.unit("pot", CUBIC_INCH, 200, Volume.class);

	/**
	 * Vedro (dry bucket). 800 cu in.
	 */
	public static final AbstractUnit<Volume> DRY_BUCKET = BUILDER.unit("bucket^dry", CUBIC_INCH, 800, Volume.class);

	/**
	 * Chetverik (quarter of one eighth). 1,600 cu in.
	 */
	public static final AbstractUnit<Volume> CHETVERIK = BUILDER.unit("chetverik", CUBIC_INCH, 1600, Volume.class);

	/**
	 * Osmina (dry one eighth). 6,400 cu in.
	 */
	public static final AbstractUnit<Volume> EIGHTH = BUILDER.unit("eighth", CUBIC_INCH, 6400, Volume.class);

	/**
	 * Chetvert' (dry quarter). 12,800 cu in.
	 */
	public static final AbstractUnit<Volume> DRY_QUARTER = BUILDER.unit("quarter^dry", CUBIC_INCH, 12_800,
			Volume.class);

	///////////////////////// Mass obsolete Russian Units /////////////////////////

	/**
	 * Russian pood.
	 */
	public static final AbstractUnit<Mass> POOD = BUILDER.unit("pood", KILOGRAM, 16.380_496_4, Mass.class);

	/**
	 * Russian pound.
	 */
	public static final AbstractUnit<Mass> POUND = BUILDER.unit("pound", POOD, new BigRational(1, 40), Mass.class);

	/**
	 * Russian lot.
	 */
	public static final AbstractUnit<Mass> LOT = BUILDER.unit("lot", POUND, new BigRational(1, 32), Mass.class);

	/**
	 * Zolotnick.
	 */
	public static final AbstractUnit<Mass> ZOLOTNICK = BUILDER.unit("zolotnik", POUND, R1_96, Mass.class);

	/**
	 * Dolya.
	 */
	public static final AbstractUnit<Mass> DOLYA = BUILDER.unit("dolya", ZOLOTNICK, R1_96, Mass.class);

	///////////////////////// Mass Apothecaries' obsolete Russian Units /////////////////////////

	/**
	 * Russian apothecaries' pound.
	 */
	public static final AbstractUnit<Mass> POUND_AP = BUILDER.unit("pound^apothecary", ZOLOTNICK, 84, Mass.class);

	/**
	 * Russian apothecaries' ounce.
	 */
	public static final AbstractUnit<Mass> OUNCE_AP = BUILDER.unit("ounce^apothecary", POUND_AP, new Rational(1, 12),
			Mass.class);

	/**
	 * Russian apothecaries' dram.
	 */
	public static final AbstractUnit<Mass> DRAM_AP = BUILDER.unit("dram^apothecary", OUNCE_AP, Rational.ONE_EIGHTH,
			Mass.class);

	/**
	 * Russian apothecaries' scruple.
	 */
	public static final AbstractUnit<Mass> SCRUPLE_AP = BUILDER.unit("scruple^apothecary", DRAM_AP, Rational.ONE_THIRD,
			Mass.class);

	/**
	 * Russian apothecaries' grain.
	 */
	public static final AbstractUnit<Mass> GRAIN_AP = BUILDER.unit("grain^apothecary", SCRUPLE_AP, new Rational(1, 20),
			Mass.class);

	///////////////////////// System of obsolete Russian Units /////////////////////////

	/**
	 * The instance of {@link SystemOfUnits}.
	 */
	public static final SystemOfUnits SYSTEM = BUILDER.build();

	private RussianUnits() {
	}

	static final class Holder {

		static final SystemOfUnitsImpl.Builder BUILDER = SystemOfUnitsImpl.builder("Russian obsolete");

		static final BigRational R1_96 = new BigRational(1, 96);

		private Holder() {
		}
	}
}
