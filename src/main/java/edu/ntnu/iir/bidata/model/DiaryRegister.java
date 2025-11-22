package edu.ntnu.iir.bidata.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a register that stores and manages DiaryEntry objects.
 *
 * <p>It is responsible for storing and managing DiaryEntry objects, including:</p>
 * <ul>
 *   <li>Creating and managing the diary entries.</li>
 *   <li>Sorting the diary entries by date</li>
 *   <li>Searching for diary entries on a specific date.</li>
 *   <li>Deleting diary entries from a specific date.</li>
 * </ul>
 */
public class DiaryRegister {
  private final ArrayList<DiaryEntry> diaryEntries;

  /** The constructor creates a new, empty diary register. */
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
   * @throws IllegalArgumentException if any field is invalid.
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
   * @throws IllegalArgumentException if any field is invalid or the date is in the future.
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

  /** Returns a copy of all diary entries stored in the register.
   *
   * @return a list containing copies of all diary entries.
   * */
  public List<DiaryEntry> getDiaryEntries() {
    return new ArrayList<>(diaryEntries);
  }

  /**
   * Deletes all diary entries that match the specific date.
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
   * Finds all diary entries stored on the given date.
   *
   * @param date the date to search entries for.
   * @return a list of diary entries on the specified date.
   * @throws IllegalArgumentException if there are no entries on the specified date.
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



  /**
   * Returns all diary entries sorted by date, with the newest entry first.
   *
   * @return a list of sorted diary entries.
   * @throws IllegalArgumentException if there are no entries in the register.
   */
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
