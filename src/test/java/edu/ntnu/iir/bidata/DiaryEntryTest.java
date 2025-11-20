package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.model.DiaryEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiaryEntryTest {

  private DiaryEntry diaryentry;

  @BeforeEach
  void setUp() {
    diaryentry = new DiaryEntry("Langkøyring", "Martin", "Intervalløkt 17x13", 1, "Løping");
  }

  // Positive tests -------------------------------------------------------------------
  @Test
  void testMinimumValidDuration() {
    Assertions.assertEquals(1, diaryentry.getDuration());
  }

  @Test
  void testMaximumValidDuration() {
    diaryentry.setMinDuration(1440);
    Assertions.assertEquals(1440, diaryentry.getDuration());
  }

  @Test
  void testConstructorSetsAllFieldCorrectly() {
    Assertions.assertEquals("Langkøyring", diaryentry.getTitle());
    Assertions.assertEquals("Martin", diaryentry.getAuthor());
    Assertions.assertEquals("Intervalløkt 17x13", diaryentry.getContentOfSession());
    Assertions.assertEquals("Løping", diaryentry.getExerciseType());
  }

  @Test
  void testConstructorSets() {
    Assertions.assertEquals(1, diaryentry.getDuration());
  }

  // Negative tests -------------------------------------------------------------------
  @Test
  void testNegativeDuration() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          diaryentry.setMinDuration(-1);
        });
  }

  @Test
  void testZeroDuration() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          diaryentry.setMinDuration(0);
        });
  }
}
