package edu.ntnu.iir.bidata.controller;

import edu.ntnu.iir.bidata.controller.menus.EntryAdministrations;
import edu.ntnu.iir.bidata.controller.menus.EntryOverview;
import edu.ntnu.iir.bidata.controller.menus.MainMenu;
import edu.ntnu.iir.bidata.controller.view.DiaryPrinter;
import edu.ntnu.iir.bidata.model.DiaryRegister;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

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
          "Halvmaraton", "Jonas", "Halvmaraton", 90, "løping", LocalDate.of(2025, 10, 4));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      System.out.println("------------------------------");
    }
  }

  /** Starts the application. */
  public void start() {
    printer.printWelcomeMessage();
    Scanner inputReader = new Scanner(System.in);
    boolean running = true;

    while (running) {
      int mainMenuChoice = 0;
      boolean invalidMainMenu = false;
      try {
        mainMenuChoice = inputReader.nextInt();
      } catch (InputMismatchException e) {
        System.out.println(
            "Invalid input - please enter a number corresponding to the menu options!");
        inputReader.nextLine();
        invalidMainMenu = true;
      }

      if (mainMenuChoice < 0 || mainMenuChoice >= MainMenu.values().length) {
        printer.printInvalidOptionMessage();
      } else if (invalidMainMenu) {

      } else {

        MainMenu mainMenu = MainMenu.values()[mainMenuChoice];
        switch (mainMenu) {
          // ---------------------------------------------------------------------------------------
          case ENTRY_OVERVIEW:
            boolean runningOverviewMenu = true;
            while (runningOverviewMenu) {
              printer.printChooseOperationMessage();
              int overviewMenuChoice = 0;
              boolean invalidRunningOverviewMenu = false;
              try {
                overviewMenuChoice = inputReader.nextInt();
              } catch (InputMismatchException e) {
                System.out.println(
                    "Invalid input - please enter a number corresponding to the menu options!");
                inputReader.nextLine();
                invalidRunningOverviewMenu = true;
              }

              if (overviewMenuChoice < 0 || overviewMenuChoice >= EntryOverview.values().length) {
                printer.printInvalidOptionMessage();
              } else if (invalidRunningOverviewMenu) {

              } else {
                EntryOverview entryOverview = EntryOverview.values()[overviewMenuChoice];

                switch (entryOverview) {
                  case PRINT_ALL_DIARY_ENTRIES:
                    printer.printAllDiaryEntries(register);
                    break;

                  case PRINT_DIARY_ENTRIES_FROM_DATE:
                    printDiaryEntryFromDate(inputReader);
                    break;

                  case PRINT_DIARY_ENTRIES_SORTED_BY_DATE:
                    printer.printDiaryEntriesSortedByDate(register);
                    break;

                  case EXIT:
                    runningOverviewMenu = false;
                    printer.printWelcomeMessage();
                    break;

                  default:
                    printer.printInvalidOptionMessage();
                    break;
                }
              }
            }
            break;
          // ---------------------------------------------------------------------------------------
          case ENTRY_ADMINISTRATIONS:
            boolean runningAdministrationMenu = true;

            while (runningAdministrationMenu) {
              printer.printAdministrationMenuMessage();
              int administrationMenuChoice = 0;
              boolean invalidAdministrationMenu = false;
              try {
                administrationMenuChoice = inputReader.nextInt();
              } catch (InputMismatchException e) {
                System.out.println(
                    "Invalid input - please enter a number corresponding to the menu options!");
                inputReader.nextLine();
                invalidAdministrationMenu = true;
              }

              if (administrationMenuChoice < 0
                  || administrationMenuChoice >= EntryAdministrations.values().length) {
                printer.printInvalidOptionMessage();
              } else if (invalidAdministrationMenu) {

              } else {
                EntryAdministrations entryAdministrations =
                    EntryAdministrations.values()[administrationMenuChoice];

                switch (entryAdministrations) {
                  case CREATE_AND_ADD_DIARY_ENTRY:
                    createAndAddDiaryEntry(inputReader);
                    break;

                  case CREATE_AND_ADD_DIARY_ENTRY_CUSTOM_DATE:
                    createAndAddDiaryEntryCustomDate(inputReader);
                    break;

                  case DELETE_DIARY_ENTRY_FROM_DATE:
                    deleteDiaryEntryFromDate(inputReader);
                    break;

                  case EXIT:
                    runningAdministrationMenu = false;
                    printer.printWelcomeMessage();
                    break;

                  default:
                    printer.printInvalidOptionMessage();
                    break;
                }
              }
            }
            break;

          case EXIT:
            running = false;
            break;

          default:
            printer.printInvalidOptionMessage();
            break;
        }
      }
    }
  }

  /**
   * Deletes a diary entry from a date based on user input.
   *
   * @param inputReader Scanner for user input.
   */
  private void deleteDiaryEntryFromDate(Scanner inputReader) {
    int day;
    int year;
    int month;
    try {
      printer.printEnterDayMessage();
      day = inputReader.nextInt();
      printer.printEnterMonthMessage();
      month = inputReader.nextInt();
      printer.printEnterYearMessage();
      year = inputReader.nextInt();
      LocalDate date = LocalDate.of(year, month, day);
      int oldSize = register.getDiaryEntries().size();
      register.deleteDiaryEntryFromDate(date);
      int newSize = register.getDiaryEntries().size();

      if (newSize < oldSize) {
        printer.deleteDiaryEntryTrueMessage();
      } else {
        printer.deleteDiaryEntryFalseMessage();
      }

    } catch (InputMismatchException e) {
      System.out.println("Date must be an number - diary entry could not be deleted!");
      inputReader.nextLine();
    } catch (DateTimeException e) {
      System.out.println("Invalid date entered - diary entry could not be deleted!");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Creates and adds a diary entry with custom date based on user input.
   *
   * @param inputReader Scanner for user input.
   */
  private void createAndAddDiaryEntryCustomDate(Scanner inputReader) {
    inputReader.nextLine();
    printer.printEnterTitleMessage();
    String title = inputReader.nextLine();
    printer.printEnterAuthorMessage();
    String author = inputReader.nextLine();
    printer.printEnterContentMessage();
    String content = inputReader.nextLine();
    printer.printEnterDurationMessage();
    int duration;
    try {
      duration = inputReader.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("Duration must be an number - diary entry could not be created!");
      inputReader.nextLine();
      return;
    }
    printer.printEnterExerciseTypeMessage();
    String exerciseType = inputReader.next();

    try {
      printer.printEnterDayMessage();
      int day = inputReader.nextInt();
      printer.printEnterMonthMessage();
      int month = inputReader.nextInt();
      printer.printEnterYearMessage();
      int year = inputReader.nextInt();

      LocalDate date = LocalDate.of(year, month, day);

      register.createAndAddDiaryEntryCustomDate(
          title, author, content, duration, exerciseType, date);
    } catch (DateTimeException e) {
      System.out.println("Invalid date entered - diary entry could not be created!");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Creates and adds a diary entry with current date based on user input.
   *
   * @param inputReader Scanner for user input.
   */
  private void createAndAddDiaryEntry(Scanner inputReader) {
    inputReader.nextLine();
    printer.printEnterTitleMessage();
    String title = inputReader.nextLine();
    printer.printEnterAuthorMessage();
    String author = inputReader.nextLine();
    printer.printEnterContentMessage();
    String content = inputReader.nextLine();
    printer.printEnterDurationMessage();
    int duration;
    try {
      duration = inputReader.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("Duration must be an number - diary entry could not be created!");
      inputReader.nextLine();
      return;
    }
    printer.printEnterExerciseTypeMessage();
    String exerciseType = inputReader.next();

    try {
      register.createAndAddDiaryEntry(title, author, content, duration, exerciseType);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Print diary entries for the date entered by the user.
   *
   * @param inputReader Scanner for user input.
   */
  private void printDiaryEntryFromDate(Scanner inputReader) {
    try {
      printer.printEnterDayMessage();
      int day = inputReader.nextInt();
      printer.printEnterMonthMessage();
      int month = inputReader.nextInt();
      printer.printEnterYearMessage();
      int year = inputReader.nextInt();
      LocalDate date = LocalDate.of(year, month, day);
      printer.printDiaryEntryFromDate(date, register);

    } catch (InputMismatchException e) {
      System.out.println("Date must be an number - diary entry could not be printed!");
      inputReader.nextLine();
    } catch (DateTimeException e) {
      System.out.println("Invalid date entered - diary entry could not be printed!");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}
