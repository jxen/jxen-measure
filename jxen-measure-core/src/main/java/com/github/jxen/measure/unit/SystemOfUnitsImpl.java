package com.github.jxen.measure.unit;

import com.github.jxen.measure.converter.Converters;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.spi.SystemOfUnits;

/**
 * {@code SystemOfUnitsImpl} class is implementation of {@link SystemOfUnits} interface.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public final class SystemOfUnitsImpl implements SystemOfUnits {

	private final String name;
	private final Set<Unit<?>> units;
	private final Map<String, Unit<?>> nameToUnit;
	private final Map<Class<? extends Quantity<?>>, Unit<?>> classToUnit;

	private SystemOfUnitsImpl(String name, Set<Unit<?>> units, Map<String, Unit<?>> nameToUnit,
			Map<Class<? extends Quantity<?>>, Unit<?>> classToUnit) {
		this.name = name;
		this.units = units;
		this.nameToUnit = nameToUnit;
		this.classToUnit = classToUnit;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <Q extends Quantity<Q>> Unit<Q> getUnit(Class<Q> quantityType) {
		return (Unit<Q>) classToUnit.get(quantityType);
	}

	@Override
	public Unit<?> getUnit(String string) {
		return nameToUnit.get(string);
	}

	@Override
	public Set<? extends Unit<?>> getUnits() {
		return units;
	}

	@Override
	public Set<? extends Unit<?>> getUnits(Dimension dimension) {
		return units.stream()
				.filter(u -> dimension.equals(u.getDimension()))
				.collect(Collectors.toSet());
	}

	/**
	 * @param name System of Units name
	 * @return Builder for new System of Units
	 */
	public static Builder builder(String name) {
		return new Builder(name);
	}

	/**
	 * {@code Builder} class is Builder for System of Units.
	 */
	public static final class Builder {

		private final String name;
		private final Set<Unit<?>> units = new HashSet<>();
		private final Map<String, Unit<?>> nameToUnit = new HashMap<>();
		private final Map<Class<? extends Quantity<?>>, Unit<?>> classToUnit = new HashMap<>();

		private Builder(String name) {
			this.name = name;
		}

		/**
		 * Adds unit to system.
		 *
		 * @param unit unit
		 * @param type type
		 * @param <Q> quantity type
		 * @return added unit
		 */
		@SuppressWarnings("unchecked")
		public <Q extends Quantity<Q>> AbstractUnit<Q> unit(AbstractUnit<?> unit, Class<Q> type) {
			units.add(unit);
			nameToUnit.putIfAbsent(unit.getName(), unit);
			classToUnit.putIfAbsent(type, unit);
			return (AbstractUnit<Q>) unit;
		}

		/**
		 * Adds base unit to the system.
		 *
		 * @param name      name
		 * @param dimension dimension
		 * @param type      type
		 * @param <Q> quantity type
		 * @return added unit
		 */
		public <Q extends Quantity<Q>> AbstractUnit<Q> unit(String name, Dimension dimension, Class<Q> type) {
			return unit(new BaseUnit<>(name, dimension), type);
		}

		/**
		 * Adds unit created with given factor.
		 *
		 * @param name   name
		 * @param unit   unit
		 * @param factor factor
		 * @param type   type
		 * @param <Q> quantity type
		 * @return added unit
		 */
		public <Q extends Quantity<Q>> AbstractUnit<Q> unit(String name, AbstractUnit<Q> unit, Number factor,
				Class<Q> type) {
			return unit(new TransformedUnit<>(unit, Converters.fromFactor(factor)).alternate(name), type);
		}

		/**
		 * @return built System of Units
		 */
		public SystemOfUnits build() {
			return new SystemOfUnitsImpl(name, Collections.unmodifiableSet(units), nameToUnit, classToUnit);
		}
	}
}
