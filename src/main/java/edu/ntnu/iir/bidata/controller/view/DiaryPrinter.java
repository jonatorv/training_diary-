package edu.ntnu.iir.bidata.controller.view;

import edu.ntnu.iir.bidata.model.DiaryEntry;
import edu.ntnu.iir.bidata.model.DiaryRegister;
import java.time.LocalDate;

/** Prints diary entries to the console. The class is responsible for formatting the output. */
public class DiaryPrinter {

  /** Prints the diary entry information to the console. */
  public void printDiaryEntry(DiaryEntry entry) {
    System.out.println("-----------------------------------------------");
    System.out.println("ID: " + entry.getId());
    System.out.println();
    System.out.println("Title: " + entry.getTitle());
    System.out.println("Author: " + entry.getAuthor());
    System.out.println("Content: " + entry.getContentOfSession());
    System.out.println("Duration: " + entry.getDuration() + " min");
    System.out.println("Exercise type: " + entry.getExerciseType());
    System.out.println("Time: " + entry.getDate());
    System.out.println("-----------------------------------------------");
    System.out.println();
  }

  /** Prints all diary entries to the console. */
  public void printAllDiaryEntries(DiaryRegister register) {
    if (register.getDiaryEntries().isEmpty()) {
      System.out.println("No entries found");
      return;
    }
    for (DiaryEntry entry : register.getDiaryEntries()) {
      printDiaryEntry(entry);
    }
  }

  /** Prints all diary entries from a specific date to the console. */
  public void printDiaryEntryFromDate(LocalDate date, DiaryRegister register) {
    for (DiaryEntry entry : register.getDiaryEntries()) {
      if (date.isEqual(entry.getDate())) {
        printDiaryEntry(entry);
      }
    }
  }
}
