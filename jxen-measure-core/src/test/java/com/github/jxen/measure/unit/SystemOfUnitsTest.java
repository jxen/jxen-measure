package com.github.jxen.measure.unit;

import static com.github.jxen.measure.unit.MetricUnits.METER;
import static com.github.jxen.measure.unit.Si.SYSTEM;
import static com.github.jxen.measure.unit.SystemOfUnitsImpl.unit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.jxen.measure.annotation.AddUnit;
import com.github.jxen.measure.dimension.Dimensions;
import com.github.jxen.measure.unit.SystemOfUnitsImpl.Builder;
import javax.measure.MeasurementException;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import org.junit.jupiter.api.Test;

class SystemOfUnitsTest {

	@Test
	void testGetName() {
		assertEquals("SI", SYSTEM.getName());
	}

	@Test
	void testGetUnitByType() {
		assertEquals(METER, SYSTEM.getUnit(Length.class));
	}

	@Test
	void testGetUnitByName() {
		assertEquals(METER, SYSTEM.getUnit("meter"));
	}

	@Test
	void testGetUnits() {
		assertFalse(SYSTEM.getUnits().isEmpty());
	}

	@Test
	void testGetUnitsLength() {
		assertFalse(SYSTEM.getUnits(Dimensions.LENGTH).isEmpty());
	}

	@Test
	void testFailureCase1() {
		assertThrows(MeasurementException.class, () -> SystemOfUnitsImpl.builder("test").add(TestUnits1.class));
	}

	@Test
	void testFailureCase2() {
		assertThrows(MeasurementException.class, () -> SystemOfUnitsImpl.builder("test").add(TestUnits2.class));
	}

	@Test
	void testFailureCase3() {
		assertThrows(MeasurementException.class, () -> SystemOfUnitsImpl.builder("test").add(TestUnits3.class));
	}

	@Test
	void testFailureCase4() {
		assertThrows(MeasurementException.class, () -> SystemOfUnitsImpl.builder("test").add(TestUnits4.class));
	}

	static final class TestUnits1 {
		@AddUnit
		public static final Unit<Length> UNIT = unit(METER, Length.class);
	}

	static final class TestUnits2 {
		@AddUnit
		public static final AbstractUnit UNIT = unit(METER, Length.class);
	}

	static final class TestUnits3 {
		@AddUnit
		public static final AbstractUnit<?> UNIT = unit(METER, Length.class);
	}

	static final class TestUnits4 {
		@AddUnit
		private static final AbstractUnit<Length> UNIT = unit(METER, Length.class);
	}
}
