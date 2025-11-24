package com.gdn.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("String Helper Test")
class StringHelperTest {

  @Test
  @DisplayName("toUpperCase with valid strings")
  public void toUpperCaseWithValidStringsTest() {
    List<String> input = Arrays.asList("hello", "world", "java");
    List<String> result = StringHelper.toUpperCase(input);

    assertEquals(3, result.size());
    assertEquals("HELLO", result.get(0));
    assertEquals("WORLD", result.get(1));
    assertEquals("JAVA", result.get(2));
  }

  @Test
  @DisplayName("toUpperCase filters out null values")
  public void toUpperCaseFiltersNullValuesTest() {
    List<String> input = Arrays.asList("hello", null, "world", null, "java");
    List<String> result = StringHelper.toUpperCase(input);

    assertEquals(3, result.size());
    assertEquals("HELLO", result.get(0));
    assertEquals("WORLD", result.get(1));
    assertEquals("JAVA", result.get(2));
  }

  @Test
  @DisplayName("toUpperCase with empty list")
  public void toUpperCaseWithEmptyListTest() {
    List<String> input = Collections.emptyList();
    List<String> result = StringHelper.toUpperCase(input);

    assertNotNull(result);
    assertTrue(result.isEmpty());
  }

  @Test
  @DisplayName("toUpperCase with null input throws exception")
  public void toUpperCaseWithNullInputTest() {
    assertThrows(NullPointerException.class, () -> {
      StringHelper.toUpperCase(null);
    });
  }

  @Test
  @DisplayName("constructor instantiation")
  public void constructorTest() {
    StringHelper helper = new StringHelper();
    assertNotNull(helper);
  }
}
