package com.github.jxen.measure.data;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class DensitiesTest {

  @Test
  void testGet() {
    assertNotNull(Densities.get(Metal.GOLD));
  }
}
