package com.github.jxen.measure.spi;

import com.github.jxen.measure.system.MathConstants;
import com.github.jxen.measure.system.PhysicalConstants;
import com.github.jxen.measure.system.Si;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.measure.spi.SystemOfUnits;
import javax.measure.spi.SystemOfUnitsService;

class DefaultSystemOfUnitsService implements SystemOfUnitsService {

  private final Map<String, SystemOfUnits> systems = new HashMap<>();

  DefaultSystemOfUnitsService() {
    add(Si.SYSTEM);
    add(MathConstants.SYSTEM);
    add(PhysicalConstants.SYSTEM);
  }

  @Override
  public SystemOfUnits getSystemOfUnits(String name) {
    return systems.get(name);
  }

  @Override
  public SystemOfUnits getSystemOfUnits() {
    return Si.SYSTEM;
  }

  @Override
  public Collection<SystemOfUnits> getAvailableSystemsOfUnits() {
    return systems.values();
  }

  final void add(SystemOfUnits system) {
    systems.put(system.getName(), system);
  }
}
