package com.github.jxen.measure.format;

import com.github.jxen.measure.nonsi.ImperialUnits;
import com.github.jxen.measure.nonsi.RussianUnits;
import com.github.jxen.measure.nonsi.TroyUnits;
import java.util.Locale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NonSiFullUnitFormatTest {

	@BeforeEach
	void setUp() {
		Locale.setDefault(Locale.US);
	}

	@Test
	void testFormatImperialUnits() {
		Assertions.assertEquals("inch", new NonSiFullUnitFormat().format(ImperialUnits.INCH));
	}

	@Test
	void testFormatRussianUnits() {
		Assertions.assertEquals("inch", new NonSiFullUnitFormat().format(RussianUnits.INCH));
	}

	@Test
	void testFormatTroyUnits() {
		Assertions.assertEquals("troy pound", new NonSiFullUnitFormat().format(TroyUnits.POUND));
	}
}
