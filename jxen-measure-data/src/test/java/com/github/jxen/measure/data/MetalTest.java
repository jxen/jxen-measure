package com.github.jxen.measure.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MetalTest {

  @Test
  void testCode() {
    assertEquals("Au", Metal.GOLD.getCode());
  }

  @Test
  void testName() {
    assertEquals("gold", Metal.GOLD.getName());
  }
}
