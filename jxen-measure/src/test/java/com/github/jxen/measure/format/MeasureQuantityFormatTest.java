package com.github.jxen.measure.format;

import static com.github.jxen.measure.quantity.Quantities.of;
import static com.github.jxen.measure.unit.MetricPrefix.centi;
import static com.github.jxen.measure.unit.MetricUnits.METER;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.jxen.math.rational.Rational;
import com.github.jxen.math.rational.format.RationalFormat;
import com.github.jxen.measure.quantity.LengthAmount;
import com.github.jxen.measure.unit.MetricPrefix;
import com.github.jxen.measure.unit.MetricUnits;
import com.github.jxen.measure.quantity.QuantityDecomposer;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
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
	void testFormatShort1() {
		QuantityFormat format = new MeasureQuantityFormat(new DecimalFormat("0.#"), new DefaultUnitFormat());
		assertEquals("1\u202Fcm", format.format(new LengthAmount(1, MetricPrefix.centi(MetricUnits.METER))));
	}

	@Test
	void testFormatShort2() {
		QuantityFormat format = new MeasureQuantityFormat(new DecimalFormat("0.#"), new DefaultUnitFormat());
		assertEquals("2\u202F\u00B5m", format.format(new LengthAmount(2, MetricPrefix.micro(MetricUnits.METER))));
	}

	@Test
	void testFormatFull1() {
		QuantityFormat format = new MeasureQuantityFormat(new RationalFormat(), new FullUnitFormat());
		assertEquals("1\u202Fdecimeter", format.format(new LengthAmount(Rational.ONE, MetricPrefix.deci(MetricUnits.METER))));
	}

	@Test
	void testFormatFull2() {
		QuantityFormat format = new MeasureQuantityFormat(new RationalFormat(), new FullUnitFormat());
		assertEquals("2\u202Fhectometers", format.format(new LengthAmount(Rational.TWO, MetricPrefix.hecto(MetricUnits.METER))));
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
}
