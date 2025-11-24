package com.gdn.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Number Helper Test")
class NumberHelperTest {
  @Test
  @DisplayName("is odd test")
  public void isOddTest() {
    assertFalse(NumberHelper.isOdd(2));
    assertTrue(NumberHelper.isOdd(3));
  }

  @Test
  @DisplayName("is even test")
  public void isEvenTest() {
    assertTrue(NumberHelper.isEven(2));
    assertTrue(NumberHelper.isEven(4));
    assertFalse(NumberHelper.isEven(3));
    assertFalse(NumberHelper.isEven(5));
  }

  @Test
  @DisplayName("is odd and is even with zero")
  public void testZero() {
    assertFalse(NumberHelper.isOdd(0));
    assertTrue(NumberHelper.isEven(0));
  }

  @Test
  @DisplayName("is odd and is even with negative numbers")
  public void testNegativeNumbers() {
    assertTrue(NumberHelper.isOdd(-1));
    assertTrue(NumberHelper.isOdd(-3));
    assertFalse(NumberHelper.isOdd(-2));
    assertFalse(NumberHelper.isOdd(-4));

    assertTrue(NumberHelper.isEven(-2));
    assertTrue(NumberHelper.isEven(-4));
    assertFalse(NumberHelper.isEven(-1));
    assertFalse(NumberHelper.isEven(-3));
  }

  @Test
  @DisplayName("constructor instantiation")
  public void constructorTest() {
    NumberHelper helper = new NumberHelper();
    assertNotNull(helper);
  }
}