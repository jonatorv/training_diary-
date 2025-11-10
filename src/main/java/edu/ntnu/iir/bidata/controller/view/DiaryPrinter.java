package edu.ntnu.iir.bidata.controller.view;

import edu.ntnu.iir.bidata.model.DiaryEntry;
import edu.ntnu.iir.bidata.model.DiaryRegister;
import java.time.LocalDate;
import java.util.List;

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
      System.out.println("No diary entries found");
      return;
    }
    System.out.println("All diary entries: ");
    for (DiaryEntry entry : register.getDiaryEntries()) {
      printDiaryEntry(entry);
    }
  }

  /** Prints all diary entries from a specific date to the console. */
  public void printDiaryEntryFromDate(LocalDate date, DiaryRegister register) {
    if (date.isAfter(LocalDate.now())) {
      System.out.println("Sorry! You cannot search for entries in the future.");
        return;
    }

    try {
      List<DiaryEntry> entries = register.findDiaryEntriesByDate(date);
      if (entries.isEmpty()){
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

  public void printDiaryEntriesSortedByDate(DiaryRegister register) {
    try {
      List<DiaryEntry> entries = register.getSortedDiaryEntriesByDate();
      if (entries.isEmpty()){
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

  /** Prints a welcome message to the console. */
  public void printWelcomeMessage() {
    System.out.println("Welcome to your personal training diary!");
    System.out.println("Choose one of the options below:");
    System.out.println("0: Open the overview menu");
    System.out.println("1: Open the entry administration menu");
    System.out.println("2: Exit the application");
    System.out.println("--------------------------------------------------------------------------->");




  }

  /** Prints a choose operation message to the console. */
  public void printChooseOperationMessage() {
    System.out.println("--------------------------------------------------------------------------->");
    System.out.println("Choose an operation:");
    System.out.println("0: Show all diary entries");
    System.out.println("1: Show diary entries from a specific date");
    System.out.println("2: Show diary entries sorted by date (newest first)");
    System.out.println("3: Return to the main menu");
    System.out.println("--------------------------------------------------------------------------->");
  }

  public void printAdministrationMenuMessage(){
    System.out.println("Choose an operation from the entry administration menu:");
    System.out.println("0: Add a new diary entry");
    System.out.println("1: Add a new diary entry with custom date");
    System.out.println("2: Delete a diary entry");
    System.out.println("3: Return to the main menu");
    System.out.println("--------------------------------------------------------------------------->");

  }

  /** Prints a enter year message to the console. */
  public void printEnterYearMessage() {
    System.out.println("Enter year: ");
  }

  /** Prints a enter month message to the console. */
  public void printEnterMonthMessage() {
    System.out.println("Enter month: ");
  }

  /** Prints a enter day message to the console. */
  public void printEnterDayMessage() {
    System.out.println("Enter day: ");
  }

  /** Prints a enter title message to the console. */
  public void printEnterTitleMessage(){
    System.out.println("Please enter the title of the trainingsession: ");
  }

  /** Prints a enter author message to the console. */
  public void printEnterAuthorMessage(){
    System.out.println("Enter your name: ");
  }

  /** Prints a enter content message to the console. */
  public void printEnterContentMessage(){
    System.out.println("Write a short description or reflection about the session: ");
  }

  /** Prints a enter duration message to the console. */
  public void printEnterDurationMessage(){
    System.out.println("How long did the session last (in minutes)?");
  }

  /** Prints a enter exercise type message to the console. */
  public void printEnterExerciseTypeMessage(){
    System.out.println("Enter the type of exercise (for example running, cycling or strength)");
  }

  public void printInvalidOptionMessage() {
    System.out.println("Invalid option! Please try again.");
    System.out.println();
  }
}
