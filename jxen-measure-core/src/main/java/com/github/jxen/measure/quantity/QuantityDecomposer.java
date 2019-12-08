package com.github.jxen.measure.quantity;

import com.github.jxen.math.common.Adapters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import javax.measure.MeasurementException;
import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * {@code QuantityDecomposer} class is able to decompose quantity by the set of units.
 *
 * @author Denis Murashev
 *
 * @param <Q> Quantity type
 *
 * @since Measure 0.1
 */
public class QuantityDecomposer<Q extends Quantity<Q>> {

	private final NavigableSet<Unit<Q>> units;

	/**
	 * @param units  units
	 */
	public QuantityDecomposer(Collection<Unit<Q>> units) {
		this.units = new TreeSet<>(QuantityDecomposer::compare);
		this.units.addAll(units);
	}

	private static <Q extends Quantity<Q>, E extends Unit<Q>> int compare(E a, E b) {
		return Double.compare(1, Quantities.of(1, a).to(b).getValue().doubleValue());
	}

	/**
	 * @return the units
	 */
	public NavigableSet<Unit<Q>> getUnits() {
		return units;
	}

	/**
	 * Evaluates decomposition for given quantity.
	 *
	 * @param quantity quantity
	 * @return decomposition
	 */
	public List<Quantity<Q>> decompose(Quantity<Q> quantity) {
		if (quantity.getValue().doubleValue() < 0) {
			throw new MeasurementException("Operation is not supported for negative values");
		}
		if (quantity.getValue().doubleValue() == 0) {
			return Collections.emptyList();
		}
		List<Quantity<Q>> list = new ArrayList<>();
		Quantity<Q> amount = quantity;
		for (Unit<Q> u : units) {
			Quantity<Q> q = amount.to(u);
			if (q.getValue().doubleValue() == 0) {
				break;
			}
			if (u == units.last()) {
				if (q.getValue().doubleValue() > 0) {
					list.add(q);
				}
			} else {
				Number v = Adapters.lookup(q.getValue()).floor();
				if (v.doubleValue() > 0) {
					Quantity<Q> o = Quantities.of(v, u);
					if (o.getValue().doubleValue() > 0) {
						list.add(o);
						amount = amount.subtract(o);
					}
				}
			}
		}
		return list;
	}
}
