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
      System.out.println("No entries found");
      return;
    }
    for (DiaryEntry entry : register.getDiaryEntries()) {
      printDiaryEntry(entry);
    }
  }

  /** Prints all diary entries from a specific date to the console. */
  public void printDiaryEntryFromDate(LocalDate date, DiaryRegister register) {
    if (date.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("Sorry! There are no entries registred in the future");
    }

    try {
      List<DiaryEntry> entries = register.findDiaryEntriesByDate(date);
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
    System.out.println("Welcome to the diary application! Press 0 to start the application");
  }

  /** Prints a choose operation message to the console. */
  public void printChooseOperationMessage() {
    System.out.println("Choose a operation from the menu!");
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
    System.out.println("Enter title: ");
  }

  /** Prints a enter author message to the console. */
  public void printEnterAuthorMessage(){
    System.out.println("Enter author: ");
  }

  /** Prints a enter content message to the console. */
  public void printEnterContentMessage(){
    System.out.println("Enter content: ");
  }

  /** Prints a enter duration message to the console. */
  public void printEnterDurationMessage(){
    System.out.println("Enter duration: ");
  }

  /** Prints a enter exercise type message to the console. */
  public void printEnterExerciseTypeMessage(){
    System.out.println("Enter exercise type: ");
  }

}
