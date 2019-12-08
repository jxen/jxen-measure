package com.github.jxen.measure.format;

import com.github.jxen.measure.traditional.ImperialUnits;
import com.github.jxen.measure.traditional.RussianUnits;
import com.github.jxen.measure.traditional.TroyUnits;
import java.util.Locale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TraditionalDefaultUnitFormatTest {

	@BeforeEach
	void setUp() {
		Locale.setDefault(Locale.US);
	}

	@Test
	void testFormatImperialUnits() {
		Assertions.assertEquals("in", new TraditionalDefaultUnitFormat().format(ImperialUnits.INCH));
	}

	@Test
	void testFormatRussianUnits() {
		Assertions.assertEquals("in", new TraditionalDefaultUnitFormat().format(RussianUnits.INCH));
	}

	@Test
	void testFormatTroyUnits() {
		Assertions.assertEquals("lb\u202Ft", new TraditionalDefaultUnitFormat().format(TroyUnits.POUND));
	}
}
