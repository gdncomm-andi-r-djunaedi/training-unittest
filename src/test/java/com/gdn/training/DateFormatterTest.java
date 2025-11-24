package com.gdn.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Date Formatter Test")
class DateFormatterTest {

  @Test
  @DisplayName("getFormattedYearMonth with valid date")
  public void getFormattedYearMonthWithValidDateTest() throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date testDate = sdf.parse("2025-11-15");

    String result = DateFormatter.getFormattedYearMonth(testDate);

    assertEquals("2025-11", result);
  }

  @Test
  @DisplayName("getFormattedYearMonth with null date throws exception")
  public void getFormattedYearMonthWithNullDateTest() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      DateFormatter.getFormattedYearMonth(null);
    });

    assertEquals("date is null", exception.getMessage());
  }

  @Test
  @DisplayName("getFormattedYearMonth formats correctly for different months")
  public void getFormattedYearMonthFormatsCorrectlyTest() throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    Date januaryDate = sdf.parse("2024-01-20");
    assertEquals("2024-01", DateFormatter.getFormattedYearMonth(januaryDate));

    Date decemberDate = sdf.parse("2024-12-31");
    assertEquals("2024-12", DateFormatter.getFormattedYearMonth(decemberDate));
  }

  @Test
  @DisplayName("constructor instantiation")
  public void constructorTest() {
    DateFormatter formatter = new DateFormatter();
    assertNotNull(formatter);
  }
}
