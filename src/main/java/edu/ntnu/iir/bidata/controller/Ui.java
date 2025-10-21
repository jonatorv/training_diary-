package edu.ntnu.iir.bidata.controller;

import edu.ntnu.iir.bidata.model.DiaryEntry;

/**
 * Handles the user interface for the diary application.
 *
 * <p>This class is responsible for initializing the diary entries and starting the application.
 */
public class Ui {
  private DiaryEntry diaryEntry1;
  private DiaryEntry diaryEntry2;

  /** Initializes the diary entries. */
  public void init() {

    try {
      diaryEntry1 =
          new DiaryEntry("Afternoon run", "Jonas", "4x4. 4 min på, 2 min av", 2, "Running");
      diaryEntry2 = new DiaryEntry("Morning run", "Jonas", "4x4. 4 min på, 2 min av", 2, "Running");
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

    if (diaryEntry1 != null) {
      diaryEntry1.printDiaryInfo();
    }

    if (diaryEntry2 != null) {
      diaryEntry2.printDiaryInfo();
    }
  }
}
