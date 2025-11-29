package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.model.DiaryEntry;
import java.time.LocalDate;
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
    diaryEntry = new DiaryEntry("Langkøyring", "Martin", "Intervalløkt 17x13", 1440, "Løping");
    Assertions.assertEquals(1440, diaryEntry.getDuration());
  }

  @Test
  void testIdIncrementAutomatically(){
    DiaryEntry entry1 = new DiaryEntry("Title1", "Author1", "Content1", 30, "Type1");
    DiaryEntry entry2 = new DiaryEntry("Title2", "Author2", "Content2", 30, "Type2");
    Assertions.assertEquals(entry1.getId() + 1, entry2.getId());
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
          diaryEntry = new DiaryEntry("Langkøyring", "Martin", "Intervalløkt 17x13", -1, "Løping");
        });
  }

  @Test
  void testZeroDuration() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          diaryEntry = new DiaryEntry("Langkøyring", "Martin", "Intervalløkt 17x13", 0, "Løping");
        });
  }

  @Test
  void testEmptyTitle(){
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          diaryEntry = new DiaryEntry("", "Martin", "Intervalløkt 17x13", 40, "Løping");
        });
  }

  @Test
  void testEmptyAuthor(){
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          diaryEntry = new DiaryEntry("Morning run", "", "Half maraton", 40, "Running");
        });
  }

  @Test
  void testEmptyContent(){
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          diaryEntry = new DiaryEntry("Morning run", "John", "", 40, "Running");
        });
  }

  @Test
  void testEmptyExerciseType(){
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          diaryEntry = new DiaryEntry("Morning run", "John", "Half maraton", 40, "");
        });
  }

  @Test
  void testFutureDate(){
    LocalDate date = LocalDate.of(2050, 1, 15);


    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          diaryEntry = new DiaryEntry("Morning run", "John", "Half maraton", 40, "Running", date);
        });
  }

  @Test
  void testDurationOverMaximumDuration(){
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          diaryEntry = new DiaryEntry("Morning run", "John", "Half maraton", 1500, "Running");
        });
  }
}
