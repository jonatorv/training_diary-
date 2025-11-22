package edu.ntnu.iir.bidata.controller.view;

import edu.ntnu.iir.bidata.model.DiaryEntry;
import edu.ntnu.iir.bidata.model.DiaryRegister;
import java.time.LocalDate;
import java.util.List;

/**
 * Handles all the console output related to displaying diary information.
 *
 * <p>This class is responsible for formatting and printing diary entries, menus, instructions,
 * error messages, and feedback messages to the user.</p>
 * */
public class DiaryPrinter {
  /** Separator line used for formatting menu output. */
  private static final String SEPERATOR = "------------------------------------------------------>";

  /** Prints all details of a single diary entry in a formatted layout.
   *
   * @param entry DiaryEntry to print.
   */
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

  /** Prints all diary entries stored in the register.
   *
   * @param register the diary register containing entries.
   */
  public void printAllDiaryEntries(DiaryRegister register) {
    if (register.getDiaryEntries().isEmpty()) {
      System.out.println("No diary entries found");
      return;
    }
    System.out.println("All diary entries: ");
    for (DiaryEntry entry : register.getDiaryEntries()) {
      printDiaryEntry(entry);
    }
  }

  /**
   * Prints diary entries from a specific date.
   *
   * @param date      the date to search for.
   * @param register  the diary register to retrieve entries from.
   */
  public void printDiaryEntryFromDate(LocalDate date, DiaryRegister register) {
    if (date.isAfter(LocalDate.now())) {
      System.out.println("Sorry! You cannot search for entries in the future.");
      return;
    }

    try {
      List<DiaryEntry> entries = register.findDiaryEntriesByDate(date);
      if (entries.isEmpty()) {
        System.out.println("No diary entries found on " + date);
        return;
      }
      System.out.println("Diary entries from " + date + ": ");
      for (DiaryEntry entry : entries) {
        printDiaryEntry(entry);
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /** Prints diary entries sorted by date, newest first.
   *
   * @param register the diary register containing entries.
   */
  public void printDiaryEntriesSortedByDate(DiaryRegister register) {
    try {
      List<DiaryEntry> entries = register.getSortedDiaryEntriesByDate();
      if (entries.isEmpty()) {
        System.out.println("No diary entries found");
        return;
      }
      System.out.println("Diary entries sorted by date (newest first): ");
      for (DiaryEntry entry : entries) {
        printDiaryEntry(entry);
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /** Prints the welcome message and the main menu. */
  public void printWelcomeMessage() {
    System.out.println(SEPERATOR);
    System.out.println("Welcome to your personal training diary!");
    System.out.println("Choose one of the options below:");
    System.out.println("0: Open the overview menu");
    System.out.println("1: Open the entry administration menu");
    System.out.println("2: Exit the application");
    System.out.println(SEPERATOR);
  }

  /** Prints the overview menu options. */
  public void printChooseOperationMessage() {
    System.out.println(SEPERATOR);
    System.out.println("Choose an operation:");
    System.out.println("0: Show all diary entries");
    System.out.println("1: Show diary entries from a specific date");
    System.out.println("2: Show diary entries sorted by date (newest first)");
    System.out.println("3: Return to the main menu");
    System.out.println(SEPERATOR);
  }

  /** Prints the entry administration menu. */
  public void printAdministrationMenuMessage() {
    System.out.println(SEPERATOR);
    System.out.println("Choose an operation from the entry administration menu:");
    System.out.println("0: Add a new diary entry");
    System.out.println("1: Add a new diary entry with custom date");
    System.out.println("2: Delete a diary entry");
    System.out.println("3: Return to the main menu");
    System.out.println(SEPERATOR);
  }

  /** Prints a prompt asking for a year. */
  public void printEnterYearMessage() {
    System.out.println("Enter year: ");
  }

  /** Prints a prompt asking for a month. */
  public void printEnterMonthMessage() {
    System.out.println("Enter month: ");
  }

  /** Prints a prompt asking for a day. */
  public void printEnterDayMessage() {
    System.out.println("Enter day: ");
  }

  /** Prints a prompt asking for a title. */
  public void printEnterTitleMessage() {
    System.out.println("Please enter the title of the trainingsession: ");
  }

  /** Prints a prompt asking for an author. */
  public void printEnterAuthorMessage() {
    System.out.println("Enter your name: ");
  }

  /** Prints a prompt asking for the session content. */
  public void printEnterContentMessage() {
    System.out.println("Write a short description or reflection about the session: ");
  }

  /** Prints prompt asking for the duration of the session. */
  public void printEnterDurationMessage() {
    System.out.println("How long did the session last (in minutes)?");
  }

  /** Prints a prompt asking for the exercise type. */
  public void printEnterExerciseTypeMessage() {
    System.out.println("Enter the type of exercise (for example running, cycling or strength)");
  }

  /** Prints a message indicating that the chosen option is invalid.*/
  public void printInvalidOptionMessage() {
    System.out.println("Invalid Number! Please enter a number corresponding to the menu options!");
    System.out.println();
  }

  /** Prints a success message when a diary entry is successfully deleted. */
  public void deleteDiaryEntryTrueMessage() {
    System.out.println("Diary entry deleted successfully!");
  }

  /** Prints a message indicating that no entry was found on the chosen date. */
  public void deleteDiaryEntryFalseMessage() {
    System.out.println("No diary entry found on the specified date!");
  }
}
