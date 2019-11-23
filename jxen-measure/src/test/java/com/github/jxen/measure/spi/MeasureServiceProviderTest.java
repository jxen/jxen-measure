package com.github.jxen.measure.spi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;
import java.util.ServiceLoader;
import javax.measure.quantity.Length;
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
	void testGetUnitFormatService() {
		assertThrows(UnsupportedOperationException.class, () -> service.getUnitFormatService());
	}

	@Test
	void testGetFormatService() {
		assertNotNull(service.getFormatService());
	}

	@Test
	void testGetQuantityFactory() {
		assertNotNull(service.getQuantityFactory(Length.class));
	}
}
