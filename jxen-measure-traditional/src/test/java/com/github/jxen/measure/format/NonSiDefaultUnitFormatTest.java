package com.github.jxen.measure.format;

import com.github.jxen.measure.nonsi.ImperialUnits;
import com.github.jxen.measure.nonsi.RussianUnits;
import com.github.jxen.measure.nonsi.TroyUnits;
import java.util.Locale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NonSiDefaultUnitFormatTest {

	@BeforeEach
	void setUp() {
		Locale.setDefault(Locale.US);
	}

	@Test
	void testFormatImperialUnits() {
		Assertions.assertEquals("in", new NonSiDefaultUnitFormat().format(ImperialUnits.INCH));
	}

	@Test
	void testFormatRussianUnits() {
		Assertions.assertEquals("in", new NonSiDefaultUnitFormat().format(RussianUnits.INCH));
	}

	@Test
	void testFormatTroyUnits() {
		Assertions.assertEquals("lb\u202Ft", new NonSiDefaultUnitFormat().format(TroyUnits.POUND));
	}
}
