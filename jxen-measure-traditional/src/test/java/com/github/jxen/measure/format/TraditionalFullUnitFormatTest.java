package com.github.jxen.measure.format;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.jxen.measure.traditional.ApothecariesUnits;
import com.github.jxen.measure.traditional.ImperialUnits;
import com.github.jxen.measure.traditional.RussianUnits;
import com.github.jxen.measure.traditional.TroyUnits;
import com.github.jxen.measure.traditional.UsCustomaryUnits;
import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TraditionalFullUnitFormatTest {

	@BeforeEach
	void setUp() {
		Locale.setDefault(Locale.US);
	}

	@Test
	void testFormatTroyUnits() {
		assertEquals("troy\u202Fpound", new TraditionalFullUnitFormat().format(TroyUnits.POUND));
	}

	@Test
	void testFormatApothecariesUnits() {
		assertEquals("grain", new TraditionalFullUnitFormat().format(ApothecariesUnits.GRAIN));
	}

	@Test
	void testFormatImperialUnits() {
		assertEquals("inch", new TraditionalFullUnitFormat().format(ImperialUnits.INCH));
	}

	@Test
	void testFormatUsCustomaryUnits() {
		assertEquals("inch", new TraditionalFullUnitFormat().format(UsCustomaryUnits.INCH));
	}

	@Test
	void testFormatRussianUnits() {
		assertEquals("inch", new TraditionalFullUnitFormat().format(RussianUnits.INCH));
	}
}
