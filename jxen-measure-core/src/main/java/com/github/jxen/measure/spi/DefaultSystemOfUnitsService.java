package com.github.jxen.measure.spi;

import com.github.jxen.measure.unit.MetricUnits;
import java.util.Collection;
import java.util.Collections;
import javax.measure.spi.SystemOfUnits;
import javax.measure.spi.SystemOfUnitsService;

class DefaultSystemOfUnitsService implements SystemOfUnitsService {

	@Override
	public SystemOfUnits getSystemOfUnits(String name) {
		return MetricUnits.SYSTEM.getName().equals(name) ? MetricUnits.SYSTEM : null;
	}

	@Override
	public SystemOfUnits getSystemOfUnits() {
		return MetricUnits.SYSTEM;
	}

	@Override
	public Collection<SystemOfUnits> getAvailableSystemsOfUnits() {
		return Collections.singleton(MetricUnits.SYSTEM);
	}
}
