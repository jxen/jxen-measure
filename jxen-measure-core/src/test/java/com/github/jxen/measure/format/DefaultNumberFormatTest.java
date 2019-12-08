package com.github.jxen.measure.format;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParsePosition;
import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultNumberFormatTest {

	@BeforeEach
	void setUp() {
		Locale.setDefault(Locale.US);
	}

	@Test
	void testFormatCase01() {
		DefaultNumberFormat format = new DefaultNumberFormat();
		assertEquals("1", format.format(1.0));
	}

	@Test
	void testFormatCase02() {
		DefaultNumberFormat format = new DefaultNumberFormat();
		assertEquals("1235", format.format(1234.56));
	}

	@Test
	void testFormatCase03() {
		DefaultNumberFormat format = new DefaultNumberFormat();
		assertEquals("123.5", format.format(123.456));
	}

	@Test
	void testFormatCase04() {
		DefaultNumberFormat format = new DefaultNumberFormat();
		assertEquals("12.35", format.format(12.3456));
	}

	@Test
	void testFormatCase05() {
		DefaultNumberFormat format = new DefaultNumberFormat();
		assertEquals("1.235", format.format(1.23456));
	}

	@Test
	void testFormatCase06() {
		DefaultNumberFormat format = new DefaultNumberFormat();
		assertEquals("0.1235", format.format(0.123456));
	}

	@Test
	void testFormatCase07() {
		DefaultNumberFormat format = new DefaultNumberFormat();
		assertEquals("1.235E-2", format.format(0.0123456));
	}

	@Test
	void testFormatCase08() {
		DefaultNumberFormat format = new DefaultNumberFormat();
		assertEquals("1.235E-3", format.format(0.00123456));
	}

	@Test
	void testFormatCase09() {
		DefaultNumberFormat format = new DefaultNumberFormat();
		assertEquals("1.235E-4", format.format(0.000123456));
	}

	@Test
	void testFormatCase10() {
		DefaultNumberFormat format = new DefaultNumberFormat();
		assertEquals("1.235E8", format.format(123456789.0));
	}

	@Test
	void testFormatCase11() {
		DefaultNumberFormat format = new DefaultNumberFormat();
		assertEquals("1.235E17", format.format(123456789123456789.0));
	}

	@Test
	void testFormatCase12() {
		DefaultNumberFormat format = new DefaultNumberFormat();
		assertEquals("1E-9", format.format(0.000000001));
	}

	@Test
	void testParse() {
		DefaultNumberFormat format = new DefaultNumberFormat();
		assertEquals(1L, format.parse("1", new ParsePosition(0)));
	}
}
