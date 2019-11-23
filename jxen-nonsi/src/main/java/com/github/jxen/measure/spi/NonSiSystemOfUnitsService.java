package com.github.jxen.measure.spi;

import com.github.jxen.measure.nonsi.ImperialUnits;
import com.github.jxen.measure.nonsi.RussianUnits;
import com.github.jxen.measure.nonsi.TroyUnits;
import com.github.jxen.measure.unit.MetricUnits;
import java.util.Arrays;
import java.util.Collection;
import javax.measure.spi.SystemOfUnits;

class NonSiSystemOfUnitsService extends DefaultSystemOfUnitsService {

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
		return Arrays.asList(MetricUnits.SYSTEM, ImperialUnits.SYSTEM, TroyUnits.SYSTEM, RussianUnits.SYSTEM);
	}
}
