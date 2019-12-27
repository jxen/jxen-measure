package com.github.jxen.measure.quantity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.jxen.measure.quantity.impl.AngleAmount;
import com.github.jxen.measure.quantity.impl.AreaAmount;
import com.github.jxen.measure.quantity.impl.DensityAmount;
import com.github.jxen.measure.quantity.impl.LengthAmount;
import com.github.jxen.measure.quantity.impl.MassAmount;
import com.github.jxen.measure.quantity.impl.Quantities;
import com.github.jxen.measure.unit.AmpereUnits;
import com.github.jxen.measure.unit.MeterUnits;
import com.github.jxen.measure.unit.NamedUnits;
import com.github.jxen.measure.unit.RadianUnits;
import com.github.jxen.measure.unit.MetricUnits;
import com.github.jxen.measure.unit.MiscUnits;
import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.quantity.ElectricPotential;
import javax.measure.quantity.Temperature;
import org.junit.jupiter.api.Test;

class QuantityImplTest {

	@Test
	void testAdd() {
		AngleAmount angle = new AngleAmount(1, RadianUnits.RADIAN);
		AngleAmount actual = AngleAmount.of(angle.add(angle));
		assertEquals(new AngleAmount(2.0, RadianUnits.RADIAN), actual);
	}

	@Test
	void testSubtract() {
		AreaAmount area = new AreaAmount(1, MeterUnits.SQUARE_METER);
		AreaAmount actual = AreaAmount.of(area.subtract(area));
		assertEquals(new AreaAmount(0.0, MeterUnits.SQUARE_METER), actual);
	}

	@Test
	void testDivideQuantity() {
		DensityAmount density = new DensityAmount(1, NamedUnits.KILOGRAM_PER_CUBIC_METER);
		Quantity<?> actual = density.divide(density);
		assertEquals(1, actual.getValue().doubleValue());
	}

	@Test
	void testDivideNumber() {
		LengthAmount length = new LengthAmount(2, MetricUnits.METER);
		LengthAmount actual = LengthAmount.of(length.divide(2.0));
		assertEquals(1, actual.getValue().doubleValue());
	}

	@Test
	void testMultiplyQuantity() {
		LengthAmount length = new LengthAmount(2, MetricUnits.METER);
		@SuppressWarnings("unchecked")
		AreaAmount actual = AreaAmount.of((Quantity<Area>) length.multiply(length));
		assertEquals(4, actual.getValue().doubleValue());
	}

	@Test
	void testMultiplyNumber() {
		DensityAmount density = new DensityAmount(2, NamedUnits.KILOGRAM_PER_CUBIC_METER);
		DensityAmount actual = DensityAmount.of(density.multiply(2.0));
		assertEquals(4, actual.getValue().doubleValue());
	}

	@Test
	void testNegate() {
		LengthAmount length = new LengthAmount(1, MetricUnits.METER);
		assertEquals(-1, length.negate().getValue().doubleValue());
	}

	@Test
	void testEqualsSame() {
		Quantity<ElectricPotential> voltage = Quantities.of(1, AmpereUnits.VOLT);
		assertEquals(voltage, voltage);
	}

	@Test
	void testNotEqualsCase1() {
		Quantity<Temperature> temperature = Quantities.of(1, MiscUnits.CELSIUS);
		assertNotEquals(temperature, MetricUnits.KELVIN);
	}

	@Test
	void testNotEqualsCase2() {
		MassAmount mass = new MassAmount(1, MetricUnits.KILOGRAM);
		assertNotEquals(mass, new MassAmount(1, NamedUnits.GRAM));
	}

	@Test
	void testNotEqualsCase3() {
		MassAmount mass = new MassAmount(1, MetricUnits.KILOGRAM);
		assertNotEquals(mass, new MassAmount(2, MetricUnits.KILOGRAM));
	}

	@Test
	void testNotEqualsCompareToCase1() {
		MassAmount mass = new MassAmount(1, MetricUnits.KILOGRAM);
		assertEquals(1, mass.compareTo(new MassAmount(1, NamedUnits.GRAM)));
	}

	@Test
	void testNotEqualsCompareToCase2() {
		MassAmount mass = new MassAmount(1, MetricUnits.KILOGRAM);
		assertEquals(0, mass.compareTo(new MassAmount(1, MetricUnits.KILOGRAM)));
	}

	@Test
	void testNotEqualsCompareToCase3() {
		MassAmount mass = new MassAmount(1, MetricUnits.KILOGRAM);
		assertEquals(-1, mass.compareTo(new MassAmount(2, MetricUnits.KILOGRAM)));
	}
}
