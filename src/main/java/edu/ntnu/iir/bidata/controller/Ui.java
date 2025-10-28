package edu.ntnu.iir.bidata.controller;

import edu.ntnu.iir.bidata.model.DiaryRegister;
import java.time.LocalDateTime;

/**
 * Handles the user interface for the diary application.
 *
 * <p>This class is responsible for initializing the diary entries and starting the application.
 */
public class Ui {
  private DiaryRegister register;

  /** Initializes the diary entries. */
  public void init() {
    register = new DiaryRegister();
    try {
      register.createAndAddDiaryEntry("Halvmaraton", "Jonas", "Halvmaraton", 90, "løping");
      register.createAndAddDiaryEntryCustomDate("Halvmaraton", "Jonas", "Halvmaraton", 90, "løping", LocalDateTime.of(2025, 10, 4, 10, 0)
      );

    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println("------------------------------");
    }
  }

  /** Starts the application. */
  public void start() {
    System.out.println();
    System.out.println("Welcome to the diary application!");
    System.out.println();


    /**
     * if (diaryEntry1 != null) {
     *       diaryEntry1.printDiaryInfo();
     *     }
     *
     *     if (diaryEntry2 != null) {
     *       diaryEntry2.printDiaryInfo();
     *     }
     */
  }
}
