package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.model.DiaryEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiaryEntryTest {

  private DiaryEntry diaryEntry;

  @BeforeEach
  void setUp() {
    diaryEntry = new DiaryEntry("Langkøyring", "Martin", "Intervalløkt 17x13", 1, "Løping");
  }

  // Positive tests -------------------------------------------------------------------
  @Test
  void testMinimumValidDuration() {
    Assertions.assertEquals(1, diaryEntry.getDuration());
  }

  @Test
  void testMaximumValidDuration() {
    diaryEntry.setMinDuration(1440);
    Assertions.assertEquals(1440, diaryEntry.getDuration());
  }

  @Test
  void testConstructorSetsAllFieldCorrectly() {
    Assertions.assertEquals("Langkøyring", diaryEntry.getTitle());
    Assertions.assertEquals("Martin", diaryEntry.getAuthor());
    Assertions.assertEquals("Intervalløkt 17x13", diaryEntry.getContentOfSession());
    Assertions.assertEquals("Løping", diaryEntry.getExerciseType());
  }

  @Test
  void testConstructorSets() {
    Assertions.assertEquals(1, diaryEntry.getDuration());
  }

  // Negative tests -------------------------------------------------------------------
  @Test
  void testNegativeDuration() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          diaryEntry.setMinDuration(-1);
        });
  }

  @Test
  void testZeroDuration() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          diaryEntry.setMinDuration(0);
        });
  }
}
