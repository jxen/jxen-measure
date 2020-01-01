package com.github.jxen.measure.data;

import static com.github.jxen.measure.system.NamedUnits.KILOGRAM_PER_CUBIC_METER;

import java.util.EnumMap;
import java.util.Map;
import javax.measure.Quantity;
import si.uom.quantity.Density;

/**
 * {@code Densities} class provides dencities data.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.5
 */
public final class Densities {

	private static final Map<Substance, Quantity<Density>> VALUES = YamlUtil.fill(new EnumMap<>(Substance.class),
			Densities.class, KILOGRAM_PER_CUBIC_METER);

	private Densities() {
	}

	/**
	 * Provides density of given substance.
	 *
	 * @param substance substance
	 * @return density
	 */
	public static Quantity<Density> get(Substance substance) {
		return VALUES.get(substance);
	}
}
