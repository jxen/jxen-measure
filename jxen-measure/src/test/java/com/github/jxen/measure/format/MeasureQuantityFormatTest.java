package com.github.jxen.measure.format;

import static com.github.jxen.measure.quantity.Quantities.of;
import static com.github.jxen.measure.unit.MetricPrefix.centi;
import static com.github.jxen.measure.unit.MetricUnits.METER;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.jxen.math.rational.Rational;
import com.github.jxen.math.rational.format.RationalFormat;
import com.github.jxen.measure.quantity.AngleAmount;
import com.github.jxen.measure.quantity.LengthAmount;
import com.github.jxen.measure.quantity.Quantities;
import com.github.jxen.measure.quantity.QuantityDecomposer;
import com.github.jxen.measure.unit.ElectromagneticUnits;
import com.github.jxen.measure.unit.MechanicalUnits;
import com.github.jxen.measure.unit.MetricPrefix;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.measure.MeasurementException;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.format.QuantityFormat;
import javax.measure.quantity.Length;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MeasureQuantityFormatTest {

	@BeforeEach
	void setUp() {
		Locale.setDefault(Locale.US);
	}

	@Test
	void testFormatZero() {
		QuantityFormat format = new MeasureQuantityFormat(new DecimalFormat("0.#"), new DefaultUnitFormat());
		assertEquals("0\u202Fm", format.format(new LengthAmount(0, METER)));
	}

	@Test
	void testFormatShort1() {
		QuantityFormat format = new MeasureQuantityFormat(new DecimalFormat("0.#"), new DefaultUnitFormat());
		assertEquals("1\u202Fcm", format.format(new LengthAmount(1, MetricPrefix.centi(METER))));
	}

	@Test
	void testFormatShort2() {
		QuantityFormat format = new MeasureQuantityFormat(new DecimalFormat("0.#"), new DefaultUnitFormat());
		assertEquals("2\u202F\u00B5m", format.format(new LengthAmount(2, MetricPrefix.micro(METER))));
	}

	@Test
	void testFormatShort3() {
		QuantityFormat format = new MeasureQuantityFormat(new DecimalFormat("0.#"), new DefaultUnitFormat());
		assertEquals("1\u00B0", format.format(new AngleAmount(1, MechanicalUnits.DEGREE_ANGLE)));
	}

	@Test
	void testFormatFull1() {
		QuantityFormat format = new MeasureQuantityFormat(new RationalFormat(), new FullUnitFormat());
		assertEquals("1\u202Fdecimeter", format.format(new LengthAmount(Rational.ONE, MetricPrefix.deci(METER))));
	}

	@Test
	void testFormatFull2() {
		QuantityFormat format = new MeasureQuantityFormat(new RationalFormat(), new FullUnitFormat());
		assertEquals("2\u202Fhectometers", format.format(new LengthAmount(Rational.TWO, MetricPrefix.hecto(METER))));
	}

	@Test
	void testFormatList() {
		Locale.setDefault(Locale.US);
		MeasureQuantityFormat format = new MeasureQuantityFormat(new FullUnitFormat());
		Unit<Length> cm = centi(METER);
		QuantityDecomposer<Length> decomposer = new QuantityDecomposer<>(asList(METER, cm));
		Quantity<Length> length = of(1.25, METER);
		List<Quantity<Length>> list = decomposer.decompose(length);
		String actual = format.format(list);
		String expected = "1\u202Fmeter 25\u202Fcentimeters";
		assertEquals(expected, actual);
	}

	@Test
	void testParseCase1() {
		assertThrows(UnsupportedOperationException.class,
				() -> new MeasureQuantityFormat(NumberFormat.getInstance()).parse(null, null));
	}

	@Test
	void testParseCase2() {
		assertThrows(UnsupportedOperationException.class, () -> new MeasureQuantityFormat().parse(null));
	}

	@Test
	void testFailureCase1() {
		assertThrows(MeasurementException.class,
				() -> new MeasureQuantityFormat().format(Quantities.of(1, METER), new BrokenAppendable()));
	}

	@Test
	void testFailureCase2() {
		List<Quantity<Length>> quantities = asList(Quantities.of(1, METER), Quantities.of(1, METER));
		assertThrows(MeasurementException.class,
				() -> new MeasureQuantityFormat().format(quantities, new BrokenAppendable()));
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
