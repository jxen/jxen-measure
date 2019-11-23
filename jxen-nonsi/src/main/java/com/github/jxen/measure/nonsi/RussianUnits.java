package com.github.jxen.measure.nonsi;

import static com.github.jxen.measure.nonsi.RussianUnits.BuilderHolder.BUILDER;
import static com.github.jxen.measure.nonsi.RussianUnits.BuilderHolder.R1_96;

import com.github.jxen.math.rational.BigRational;
import com.github.jxen.math.rational.Rational;
import com.github.jxen.measure.unit.AbstractUnit;
import com.github.jxen.measure.unit.SystemOfUnitsImpl;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.spi.SystemOfUnits;

/**
 * {@code RussianUnits} class represents old Russian unit system.
 *
 * @author Denis Murashev
 * @since Non-SI Units 0.1
 */
public final class RussianUnits {

	///////////////////////// Length Russian Units /////////////////////////

	/**
	 * Inch.
	 */
	public static final AbstractUnit<Length> INCH = BUILDER.unit(ImperialUnits.INCH, Length.class);

	/**
	 * Line.
	 */
	public static final AbstractUnit<Length> LINE = BUILDER.unit("line", INCH, new Rational(1, 10), Length.class);

	/**
	 * Point.
	 */
	public static final AbstractUnit<Length> POINT = BUILDER.unit("point", INCH, new BigRational(1, 100),
			Length.class);

	/**
	 * Vershok.
	 */
	public static final AbstractUnit<Length> VERSHOK = BUILDER.unit("vershok", INCH, new Rational(7, 4),
			Length.class);

	/**
	 * Span (Russian pyad).
	 */
	public static final AbstractUnit<Length> SPAN = BUILDER.unit("span", INCH, 7, Length.class);

	/**
	 * Foot.
	 */
	public static final AbstractUnit<Length> FOOT = BUILDER.unit(ImperialUnits.FOOT, Length.class);

	/**
	 * Arshin.
	 */
	public static final AbstractUnit<Length> ARSHIN = BUILDER.unit("arshin", INCH, 28, Length.class);

	/**
	 * Fathom.
	 */
	public static final AbstractUnit<Length> FATHOM = BUILDER.unit("fathom", FOOT, 7, Length.class);

	/**
	 * Versta.
	 */
	public static final AbstractUnit<Length> VERSTA = BUILDER.unit("versta", FATHOM, 500, Length.class);

	/**
	 * Mile.
	 */
	public static final AbstractUnit<Length> MILE = BUILDER.unit("mile", VERSTA, 7, Length.class);

	///////////////////////// Area Russian Units /////////////////////////

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
	 * Dessiatin.
	 */
	public static final AbstractUnit<Area> DESSIATIN = BUILDER.unit("dessiatin", SQUARE_FATHOM, 2400, Area.class);

	/**
	 * Square versta.
	 */
	public static final AbstractUnit<Area> SQUARE_VERSTA = BUILDER.unit(VERSTA.pow(2), Area.class);

	///////////////////////// Mass Russian Units /////////////////////////

	/**
	 * Russian pound.
	 */
	public static final AbstractUnit<Mass> POUND = BUILDER.unit("pound", TroyUnits.POUND, new BigRational(3511, 3200),
			Mass.class);

	/**
	 * Russian pood.
	 */
	public static final AbstractUnit<Mass> POOD = BUILDER.unit("pood", POUND, 40, Mass.class);

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
	public static final AbstractUnit<Mass> DOLIA = BUILDER.unit("dolia", ZOLOTNICK, R1_96, Mass.class);

	///////////////////////// System of Ancient Russian Units /////////////////////////

	/**
	 * The instance of {@link SystemOfUnits}.
	 */
	public static final SystemOfUnits SYSTEM = BUILDER.build();

	private RussianUnits() {
	}

	static final class BuilderHolder {

		static final SystemOfUnitsImpl.Builder BUILDER = SystemOfUnitsImpl.builder("Russian");

		static final BigRational R1_96 = new BigRational(1, 96);

		private BuilderHolder() {
		}
	}
}
