package edu.ntnu.iir.bidata.model;

import edu.ntnu.iir.bidata.controller.view.DiaryPrinter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Diary register is a collection of diary entries. It is responsible for storing and managing
 * DiaryEntry objects..
 */
public class DiaryRegister {
  private ArrayList<DiaryEntry> diaryEntries;

  /** Creates a new diary register. */
  public DiaryRegister() {
    diaryEntries = new ArrayList<>();
  }

  /** Creates a new diary entry and adds it to the diary register. */
  public void createAndAddDiaryEntry(
      String title, String author, String content, int duration, String exerciseType) {
    DiaryEntry newEntry = new DiaryEntry(title, author, content, duration, exerciseType);
    diaryEntries.add(newEntry);
  }

  /** Creates a new diary entry with custom date and adds it to the diary register. */
  public void createAndAddDiaryEntryCustomDate(
      String title,
      String author,
      String content,
      int duration,
      String exerciseType,
      LocalDate date) {
    DiaryEntry newEntry = new DiaryEntry(title, author, content, duration, exerciseType, date);
    diaryEntries.add(newEntry);
  }

  /** Returns the diary entries. */
  public List<DiaryEntry> getDiaryEntries() {
    return new ArrayList<>(diaryEntries);
  }

  /** Deletes all diary entries from a specific date. */
  public boolean deleteDiaryEntryFromDate(LocalDate date) {
    Iterator<DiaryEntry> iterator = diaryEntries.iterator();
    boolean deleted = false;
    while (iterator.hasNext()) {
      DiaryEntry entry = iterator.next();
      if (entry.getDate().isEqual(date)) {
        iterator.remove();
        deleted = true;
      }
    }
    return deleted;
  }

  /** Finds all diary entries on a specific date. */
  public List<DiaryEntry> findDiaryEntriesByDate(LocalDate date) {
    ArrayList<DiaryEntry> result = new ArrayList<>();
    for (DiaryEntry entry : diaryEntries) {
      if (entry.getDate().isEqual(date)) {
        result.add(entry);
      }
    }
    if (result.isEmpty()) {
      throw new IllegalArgumentException(
          "There are no registered training sessions on " + date + ".");
    } else {
      return result;
    }
  }

  /** Sorts the diary entries by date. The newest entry is first. */
  public List<DiaryEntry> getSortedDiaryEntriesByDate() {
    ArrayList<DiaryEntry> sortedList = new ArrayList<>(diaryEntries);
    sortedList.sort(Comparator.comparing(DiaryEntry::getDate).reversed());
    if (sortedList.isEmpty()) {
      throw new IllegalArgumentException("There are no registered training sessions.");
    } else {
      return sortedList;
    }
  }
}
