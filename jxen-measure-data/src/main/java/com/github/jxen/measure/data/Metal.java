package com.github.jxen.measure.data;

/**
 * {@code Metal} enum represents metal elements.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.6
 */
public enum Metal implements Substance<Metal> {

	/**
	 * Aluminium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Aluminium">Wikipedia: Aluminium</a>
	 */
	ALUMINIUM("Al", "aluminium"),

	/**
	 * Cadmium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Cadmium">Wikipedia: Cadmium</a>
	 */
	CADMIUM("Cd", "cadmium"),

	/**
	 * Chromium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Chromium">Wikipedia: Chromium</a>
	 */
	CHROMIUM("Cr", "chromium"),

	/**
	 * Cobalt.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Cobalt">Wikipedia: Cobalt</a>
	 */
	COBALT("Co", "cobalt"),

	/**
	 * Copper.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Copper">Wikipedia: Copper</a>
	 */
	COPPER("Cu", "copper"),

	/**
	 * Gallium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Gallium">Wikipedia: Gallium</a>
	 */
	GALLIUM("Ga", "gallium"),

	/**
	 * Gold.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Gold">Wikipedia: Gold</a>
	 */
	GOLD("Au", "gold"),

	/**
	 * Hafnium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Hafnium">Wikipedia: Hafnium</a>
	 */
	HAFNIUM("Hf", "hafnium"),

	/**
	 * Indium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Indium">Wikipedia: Indium</a>
	 */
	INDIUM("In", "indium"),

	/**
	 * Iridium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Iridium">Wikipedia: Iridium</a>
	 */
	IRIDIUM("Ir", "iridium"),

	/**
	 * Iron.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Iron">Wikipedia: Iron</a>
	 */
	IRON("Fe", "iron"),

	/**
	 * Lead.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Lead">Wikipedia: Lead</a>
	 */
	LEAD("Pb", "lead"),

	/**
	 * Manganese.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Manganese">Wikipedia: Manganese</a>
	 */
	MANGANESE("Mn", "manganese"),

	/**
	 * Mercury.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Mercury_(element)">Wikipedia: Mercury (element)</a>
	 */
	MERCURY("Hg", "mercury"),

	/**
	 * Molybdenum.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Molybdenum">Wikipedia: Molybdenum</a>
	 */
	MOLYBDENUM("Mo", "molybdenum"),

	/**
	 * Nickel.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Nickel">Wikipedia: Nickel</a>
	 */
	NICKEL("Ni", "nickel"),

	/**
	 * Niobium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Niobium">Wikipedia: Niobium</a>
	 */
	NIOBIUM("Nb", "niobium"),

	/**
	 * Osmium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Osmium">Wikipedia: Osmium</a>
	 */
	OSMIUM("Os", "osmium"),

	/**
	 * Palladium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Palladium">Wikipedia: Palladium</a>
	 */
	PALLADIUM("Pd", "palladium"),

	/**
	 * Platinum.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Platinum">Wikipedia: Platinum</a>
	 */
	PLATINUM("Pt", "platinum"),

	/**
	 * Rhenium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Rhenium">Wikipedia: Rhenium</a>
	 */
	RHENIUM("Re", "rhenium"),

	/**
	 * Rhodium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Rhodium">Wikipedia: Rhodium</a>
	 */
	RHODIUM("Rh", "rhodium"),

	/**
	 * Ruthenium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Ruthenium">Wikipedia: Ruthenium</a>
	 */
	RUTHENIUM("Ru", "ruthenium"),

	/**
	 * Silver.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Silver">Wikipedia: Silver</a>
	 */
	SILVER("Ag", "silver"),

	/**
	 * Tantalum.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Tantalum">Wikipedia: Tantalum</a>
	 */
	TANTALUM("Ta", "tantalum"),

	/**
	 * Technetium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Technetium">Wikipedia: Technetium</a>
	 */
	TECHNETIUM("Tc", "technetium"),

	/**
	 * Thallium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Thallium">Wikipedia: Thallium</a>
	 */
	THALLIUM("Tl", "thallium"),

	/**
	 * Tin.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Tin">Wikipedia: Tin</a>
	 */
	TIN("Sn", "tin"),

	/**
	 * Titanium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Titanium">Wikipedia: Titanium</a>
	 */
	TITANIUM("Ti", "titanium"),

	/**
	 * Tungsten.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Tungsten">Wikipedia: Tungsten</a>
	 */
	TUNGSTEN("W", "tungsten"),

	/**
	 * Vanadium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Vanadium">Wikipedia: Vanadium</a>
	 */
	VANADIUM("V", "vanadium"),

	/**
	 * Zinc.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Zinc">Wikipedia: Zinc</a>
	 */
	ZINC("Zn", "zinc"),

	/**
	 * Zirconium.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Zirconium">Wikipedia: Zirconium</a>
	 */
	ZIRCONIUM("Zr", "zirconium");

	private final String code;
	private final String name;

	Metal(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getName() {
		return name;
	}
}
