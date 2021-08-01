package com.github.jxen.measure.spi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;
import java.util.ServiceLoader;
import javax.measure.quantity.Length;
import javax.measure.spi.FormatService.FormatType;
import javax.measure.spi.ServiceProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MeasureServiceProviderTest {

  private ServiceProvider service;

  @BeforeEach
  void setUp() {
    Iterator<ServiceProvider> it = ServiceLoader.load(ServiceProvider.class).iterator();
    if (it.hasNext()) {
      service = it.next();
    }
  }

  @Test
  void testInstance() {
    assertNotNull(service);
  }

  @Test
  void testGetSystemOfUnitsService() {
    assertNotNull(service.getSystemOfUnitsService());
  }

  @Test
  void testGetSystemOfUnitsServiceGetSystemOfUnitsSi() {
    assertNotNull(service.getSystemOfUnitsService().getSystemOfUnits("SI"));
  }

  @Test
  void testGetSystemOfUnitsServiceGetSystemOfUnitsUnknown() {
    assertNull(service.getSystemOfUnitsService().getSystemOfUnits("Unknown"));
  }

  @Test
  void testGetSystemOfUnitsServiceGetAvailableSystemsOfUnits() {
    assertEquals(3, service.getSystemOfUnitsService().getAvailableSystemsOfUnits().size());
  }

  @Test
  void testGetFormatService() {
    assertNotNull(service.getFormatService());
  }

  @Test
  void testGetFormatServiceGetQuantityFormat() {
    assertNotNull(service.getFormatService().getQuantityFormat());
  }

  @Test
  void testGetFormatServiceGetQuantityFormatNamed() {
    assertNotNull(service.getFormatService().getQuantityFormat("full"));
  }

  @Test
  void testGetFormatServiceGetUnitFormat() {
    assertNotNull(service.getFormatService().getUnitFormat());
  }

  @Test
  void testGetFormatServiceGetUnitFormatFull() {
    assertNotNull(service.getFormatService().getUnitFormat("full"));
  }

  @Test
  void testGetFormatServiceGetUnitFormatDefault() {
    assertNotNull(service.getFormatService().getUnitFormat("default"));
  }

  @Test
  void testGetFormatServiceGetAvailableFormatNamesTyped() {
    assertEquals(2, service.getFormatService().getAvailableFormatNames(FormatType.UNIT_FORMAT).size());
  }

  @Test
  void testGetQuantityFactory() {
    assertNotNull(service.getQuantityFactory(Length.class));
  }
}
