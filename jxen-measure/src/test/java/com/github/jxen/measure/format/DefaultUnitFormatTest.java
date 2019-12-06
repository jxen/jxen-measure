package com.github.jxen.measure.format;

import static com.github.jxen.measure.unit.MechanicalUnits.METER_PER_SECOND;
import static com.github.jxen.measure.unit.MechanicalUnits.METER_PER_SECOND_SQUARED;
import static com.github.jxen.measure.unit.MechanicalUnits.SQUARE_METER;
import static com.github.jxen.measure.unit.MetricUnits.METER;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.jxen.measure.unit.MetricPrefix;
import com.github.jxen.measure.unit.MetricUnits;
import com.github.jxen.measure.unit.NaturalUnits;
import java.io.IOException;
import java.util.Locale;
import javax.measure.MeasurementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultUnitFormatTest {

	@BeforeEach
	void setUp() {
		Locale.setDefault(Locale.US);
	}

	@Test
	void testCreate() {
		assertDoesNotThrow(() -> new DefaultUnitFormat("empty"));
	}

	@Test
	void testFormatMeter() {
		assertEquals("m", new DefaultUnitFormat().format(MetricUnits.METER));
	}

	@Test
	void testFormatKilometer() {
		assertEquals("km", new DefaultUnitFormat().format(MetricPrefix.kilo(MetricUnits.METER)));
	}

	@Test
	void testFormatSquareMeter() {
		assertEquals("m\u00B2", new DefaultUnitFormat().format(SQUARE_METER));
	}

	@Test
	void testFormatMeterPerSecond() {
		assertEquals("m\u2044s", new DefaultUnitFormat().format(METER_PER_SECOND));
	}

	@Test
	void testFormatMeterPerSquareSecond() {
		assertEquals("m\u2044s\u00B2", new DefaultUnitFormat().format(METER_PER_SECOND_SQUARED));
	}

	@Test
	void testFormatGravity() {
		assertEquals("[unit.gravity]", new DefaultUnitFormat().format(NaturalUnits.STANDARD_GRAVITY));
	}

	@Test
	void testLabel() {
		assertThrows(UnsupportedOperationException.class, () -> new DefaultUnitFormat().label(null, null));
	}

	@Test
	void testLocaleSensitive() {
		assertTrue(new DefaultUnitFormat().isLocaleSensitive());
	}

	@Test
	void testParse2() {
		assertThrows(UnsupportedOperationException.class, () -> new DefaultUnitFormat().parse(null, null));
	}

	@Test
	void testParse() {
		assertThrows(UnsupportedOperationException.class, () -> new DefaultUnitFormat().parse(null));
	}

	@Test
	void testFailureCase1() {
		assertThrows(MeasurementException.class,
				() -> new DefaultUnitFormat().format(METER, new BrokenAppendable()));
	}

	@Test
	void testFailureCase2() {
		assertThrows(MeasurementException.class,
				() -> new DefaultUnitFormat().format(1, METER, new BrokenAppendable()));
	}

	private static class BrokenAppendable implements Appendable {

		@Override
		public Appendable append(CharSequence csq) throws IOException {
			throw new IOException();
		}

		@Override
		public Appendable append(CharSequence csq, int start, int end) throws IOException {
			throw new IOException();
		}

		@Override
		public Appendable append(char c) throws IOException {
			throw new IOException();
		}
	}
}
