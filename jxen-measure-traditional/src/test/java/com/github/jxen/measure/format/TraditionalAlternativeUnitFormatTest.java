package com.github.jxen.measure.format;

import com.github.jxen.measure.traditional.ImperialUnits;
import com.github.jxen.measure.traditional.RussianUnits;
import com.github.jxen.measure.traditional.TroyUnits;
import java.util.Locale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TraditionalAlternativeUnitFormatTest {

	@BeforeEach
	void setUp() {
		Locale.setDefault(Locale.US);
	}

	@Test
	void testFormatImperialUnits() {
		Assertions.assertEquals("\u2033", new TraditionalAlternativeUnitFormat().format(ImperialUnits.INCH));
	}

	@Test
	void testFormatRussianUnits() {
		Assertions.assertEquals("\u2033", new TraditionalAlternativeUnitFormat().format(RussianUnits.INCH));
	}

	@Test
	void testFormatTroyUnits() {
		Assertions.assertEquals("lb\u202Ft", new TraditionalAlternativeUnitFormat().format(TroyUnits.POUND));
	}
}
