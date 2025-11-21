package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.model.DiaryEntry;
import edu.ntnu.iir.bidata.model.DiaryRegister;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiaryRegisterTest {
  private DiaryRegister diaryRegister;

  @BeforeEach
  void setUp() {
    diaryRegister = new DiaryRegister();
  }
  // Positive tests -------------------------------------------------------------------
  @Test
  void testCreateAndAddDiaryEntry() {
    diaryRegister.createAndAddDiaryEntry("Morning Run", "Alice", "5km easy run", 30, "Running");

    List<DiaryEntry> entries = diaryRegister.getDiaryEntries();
    Assertions.assertEquals(1, entries.size());
    Assertions.assertEquals(LocalDate.now(), entries.get(0).getDate());
  }

  @Test
  void testCreateAndAddDiaryEntryWithCustomDate() {
    LocalDate date = LocalDate.of(2023, 1, 15);
    diaryRegister.createAndAddDiaryEntryCustomDate("Evening Cycle", "Bob", "20km cycling", 60, "Cycling", date);

    List<DiaryEntry> entries = diaryRegister.getDiaryEntries();
    Assertions.assertEquals(1, entries.size());
    Assertions.assertEquals(date, entries.get(0).getDate());
  }

  @Test
  void testDeleteDiaryEntryFromDate(){
    LocalDate date = LocalDate.of(2025, 1, 15);
    diaryRegister.createAndAddDiaryEntryCustomDate("Afternoon run", "Martin", "21km run", 160, "Running", date);

    diaryRegister.deleteDiaryEntryFromDate(date);
    Assertions.assertEquals(0, diaryRegister.getDiaryEntries().size());
  }

  @Test
  void testFindDiaryEntriesByDate(){
    LocalDate date = LocalDate.of(2025, 1, 10);
    diaryRegister.createAndAddDiaryEntryCustomDate("Morning run", "Martin", "21km run", 160, "Running", date);
    diaryRegister.createAndAddDiaryEntryCustomDate("Morning Run", "John", "5km", 20, "Running", date);

    List<DiaryEntry> entries = diaryRegister.findDiaryEntriesByDate(date);
    Assertions.assertEquals(2, entries.size());
  }

  @Test
  void testGetDiaryEntriesNotSame(){
    diaryRegister.createAndAddDiaryEntry("Raceday", "John", "10km", 35, "Runnning");

    List<DiaryEntry> list1 = diaryRegister.getDiaryEntries();
    List<DiaryEntry> list2 = diaryRegister.getDiaryEntries();

    Assertions.assertNotSame(list1, list2);
  }

  @Test
  void testGetSortedDiaryEntriesByDate(){
    LocalDate oldDate = LocalDate.of(2024, 4, 2);
    LocalDate newDate = LocalDate.of(2025, 6, 2);

    diaryRegister.createAndAddDiaryEntryCustomDate("Morning run", "Martin", "21km run", 160, "Running", oldDate);
    diaryRegister.createAndAddDiaryEntryCustomDate("Morning Run", "John", "5km", 20, "Running", newDate);

    Assertions.assertEquals(newDate, diaryRegister.getSortedDiaryEntriesByDate().get(0).getDate());
  }

  // Negative tests -------------------------------------------------------------------
  @Test
  void testCreateAndAddDiaryEntryWithFutureDate() {
    LocalDate date = LocalDate.of(2050, 1, 15);

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      diaryRegister.createAndAddDiaryEntryCustomDate("Future Workout", "Charlie", "10km", 45, "Running", date);
    });
  }

  @Test
  void testDeleteDiaryEntryFromDateWithNoEntries(){
    LocalDate FalseDate = LocalDate.of(2025, 1, 15);
    LocalDate trueDate = LocalDate.of(2025, 1, 10);
    diaryRegister.createAndAddDiaryEntryCustomDate("Morning run", "Martin", "21km run", 160, "Running", trueDate);

    List<DiaryEntry> entriesBefore = diaryRegister.getDiaryEntries();
    diaryRegister.deleteDiaryEntryFromDate(FalseDate);
    List<DiaryEntry> entriesAfter = diaryRegister.getDiaryEntries();
    Assertions.assertEquals(entriesBefore, entriesAfter);
  }
}
