package com.github.jxen.measure.spi;

import com.github.jxen.measure.misc.ImperialUnits;
import com.github.jxen.measure.misc.RussianUnits;
import com.github.jxen.measure.misc.TroyUnits;
import com.github.jxen.measure.unit.Si;
import java.util.Arrays;
import java.util.Collection;
import javax.measure.spi.SystemOfUnits;

class MiscSystemOfUnitsService extends DefaultSystemOfUnitsService {

	@Override
	public SystemOfUnits getSystemOfUnits(String name) {
		for (SystemOfUnits system : getAvailableSystemsOfUnits()) {
			if (system.getName().equals(name)) {
				return system;
			}
		}
		return null;
	}

	@Override
	public Collection<SystemOfUnits> getAvailableSystemsOfUnits() {
		return Arrays.asList(Si.SYSTEM, ImperialUnits.SYSTEM, TroyUnits.SYSTEM, RussianUnits.SYSTEM);
	}
}
