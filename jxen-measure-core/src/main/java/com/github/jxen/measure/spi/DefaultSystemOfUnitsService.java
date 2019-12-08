package com.github.jxen.measure.spi;

import static com.github.jxen.measure.unit.Si.SYSTEM;

import java.util.Collection;
import java.util.Collections;
import javax.measure.spi.SystemOfUnits;
import javax.measure.spi.SystemOfUnitsService;

class DefaultSystemOfUnitsService implements SystemOfUnitsService {

	@Override
	public SystemOfUnits getSystemOfUnits(String name) {
		return SYSTEM.getName().equals(name) ? SYSTEM : null;
	}

	@Override
	public SystemOfUnits getSystemOfUnits() {
		return SYSTEM;
	}

	@Override
	public Collection<SystemOfUnits> getAvailableSystemsOfUnits() {
		return Collections.singleton(SYSTEM);
	}
}
