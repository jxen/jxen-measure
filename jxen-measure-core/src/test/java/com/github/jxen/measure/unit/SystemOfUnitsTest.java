package com.github.jxen.measure.unit;

import static com.github.jxen.measure.unit.MetricUnits.METER;
import static com.github.jxen.measure.unit.MetricUnits.SYSTEM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.github.jxen.measure.dimension.Dimensions;
import com.github.jxen.measure.unit.SystemOfUnitsImpl.Builder;
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
	void testAddSame() {
		Builder builder = SystemOfUnitsImpl.builder("Test");
		builder.unit(METER, Length.class);
		builder.unit(METER, Length.class);
		assertEquals(1, builder.build().getUnits().size());
	}
}
