package com.github.jxen.measure.format;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.jxen.measure.nonsi.ApothecariesUnits;
import com.github.jxen.measure.nonsi.ImperialUnits;
import com.github.jxen.measure.nonsi.RussianUnits;
import com.github.jxen.measure.nonsi.TroyUnits;
import com.github.jxen.measure.nonsi.UsCustomaryUnits;
import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NonSiFullUnitFormatTest {

	@BeforeEach
	void setUp() {
		Locale.setDefault(Locale.US);
	}

	@Test
	void testFormatTroyUnits() {
		assertEquals("troy\u202Fpound", new NonSiFullUnitFormat().format(TroyUnits.POUND));
	}

	@Test
	void testFormatApothecariesUnits() {
		assertEquals("grain", new NonSiFullUnitFormat().format(ApothecariesUnits.GRAIN));
	}

	@Test
	void testFormatImperialUnits() {
		assertEquals("inch", new NonSiFullUnitFormat().format(ImperialUnits.INCH));
	}

	@Test
	void testFormatUsCustomaryUnits() {
		assertEquals("inch", new NonSiFullUnitFormat().format(UsCustomaryUnits.INCH));
	}

	@Test
	void testFormatRussianUnits() {
		assertEquals("inch", new NonSiFullUnitFormat().format(RussianUnits.INCH));
	}
}
