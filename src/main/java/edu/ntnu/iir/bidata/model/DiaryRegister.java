package edu.ntnu.iir.bidata.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Diary register is a collection of diary entries. It is responsible for storing and managing
 * DiaryEntry objects.
 * - The class is responsible for creating and managing the diary entries.
 * - The class is responsible for sorting the diary entries by date.
 * - The class is responsible for searching for diary entries on a specific date.
 * - The class is responsible for deleting diary entries from a specific date.
 */
public class DiaryRegister {
  private ArrayList<DiaryEntry> diaryEntries;

  /** Creates a new diary register. */
  public DiaryRegister() {
    diaryEntries = new ArrayList<>();
  }

  /**
   * Creates a new diary entry and adds it to the diary register with the current date.
   *
   * @param title the title of the entry.
   * @param author the author of the entry.
   * @param content the content of the entry.
   * @param duration the duration of the entry.
   * @param exerciseType the exercise type of the entry.
   */
  public void createAndAddDiaryEntry(
      String title, String author, String content, int duration, String exerciseType) {
    DiaryEntry newEntry = new DiaryEntry(title, author, content, duration, exerciseType);
    diaryEntries.add(newEntry);
  }

  /**
   * Creates a new diary entry with custom date and adds it to the diary register.
   *
   * @param date the date of the entry.
   * @param title the title of the entry.
   * @param author the author of the entry.
   * @param content the content of the entry.
   * @param duration the duration of the entry.
   * @param exerciseType the exercise type of the entry.
   */
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

  /** Returns a copy of the diary entries in a list. */
  public List<DiaryEntry> getDiaryEntries() {
    return new ArrayList<>(diaryEntries);
  }

  /**
   * Deletes all diary entries from a specific date.
   *
   * @param date the date to delete entries from.
   */
  public void deleteDiaryEntryFromDate(LocalDate date) {
    Iterator<DiaryEntry> iterator = diaryEntries.iterator();
    while (iterator.hasNext()) {
      DiaryEntry entry = iterator.next();
      if (entry.getDate().isEqual(date)) {
        iterator.remove();
      }
    }
  }

  /**
   * Finds all diary entries on a specific date.
   *
   * @param date the date to search entries for.
   * @return a list of diary entries on the specified date.
   */
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

  /** Sorts the diary entries by date. The newest entry first. */
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
