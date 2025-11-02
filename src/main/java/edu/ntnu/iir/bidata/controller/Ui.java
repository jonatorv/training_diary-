package edu.ntnu.iir.bidata.controller;

import edu.ntnu.iir.bidata.controller.view.DiaryPrinter;
import edu.ntnu.iir.bidata.model.DiaryRegister;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Handles the user interface for the diary application.
 *
 * <p>This class is responsible for initializing the diary entries and starting the application.
 */
public class Ui {
  private DiaryRegister register;
  private DiaryPrinter printer;

  /** Initializes the diary entries. */
  public void init() {
    register = new DiaryRegister();
    printer = new DiaryPrinter();

    try {
      register.createAndAddDiaryEntry("Maraton", "Jonas", "Halvmaraton", 90, "løping");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println("------------------------------");
    }
    try {
      register.createAndAddDiaryEntryCustomDate(
          "Halvmaraton",
          "Jonas",
          "Halvmaraton",
          90,
          "løping",
          LocalDate.of(2025, 10, 4));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println("------------------------------");
    }
  }

  /** Starts the application. */
  public void start() {
    System.out.println();
    System.out.println("Welcome to the diary application!");
    printer.printAllDiaryEntries(register);
  }
}
